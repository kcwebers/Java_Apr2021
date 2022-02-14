package com.kw.taskmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kw.taskmanager.models.Task;
import com.kw.taskmanager.models.User;
import com.kw.taskmanager.services.TaskService;
import com.kw.taskmanager.services.UserService;
import com.kw.taskmanager.validators.UserValidator;



@Controller
public class MainController {
	private final UserService userServ;
	private final UserValidator userValidator;
	private final TaskService taskServ;
	public MainController(UserService userServ, UserValidator userValidator, TaskService taskServ) {
		this.userServ = userServ;
		this.userValidator = userValidator;
		this.taskServ = taskServ;
	}
	
	// ====================================================
	// LOGIN/REGISTRATION ROUTES
	// ====================================================

	// RENDER LOGIN/REGISTER PAGE
	@RequestMapping("/")	
	public String main(Model model) {
		// pass forward an empty User instance, so it can be filled up and verified in our form:form
		model.addAttribute("user", new User());
		return "index.jsp";
	}
	
	// PROCESS REGISTRATION
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpSession session,
			RedirectAttributes redirect,
			Model model) {
		// step #1: validate that the passwords match!
		// if they don't, the error message we set in 'messages.properties' 
		// will be stored in the same space as the errors in our BindingResult
		userValidator.validate(user, result);
		if(userServ.findByEmail(user.getEmail()) != null) {
			ObjectError error = new ObjectError("email","An account already exists for this email.");
			result.addError(error);
		}
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			User u = userServ.registerUser(user);
			// make sure to add the user to session, so they are properly logged in!
			session.setAttribute("userId", u.getId()); // 
			//^ make sure you add the id to session under the same label you would in the 'login' method
			redirect.addFlashAttribute("success", "You have successfully regisetered!");
			return "redirect:/dashboard";
		}
	}
	
	// PROCESS LOGIN
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpSession session,
			RedirectAttributes redirect) {
		// because we are using a regular form, we have to check things manually!
		// first, call on the authenticateUser() method in our service and see if you get true or false!
		// if true, then the user was verified and can be logged in
		if(userServ.authenticateUser(email, password)) {
			User u = userServ.findByEmail(email);
			session.setAttribute("userId", u.getId());
			//^ make sure you add the id to session under the same label you would in the 'register' method
			redirect.addFlashAttribute("success", "You have successfully logged in!");
			return "redirect:/dashboard";
		} else { // if false, redirect the user back to the login/reg page 
			// and send a message that their credentials were wrong
			redirect.addFlashAttribute("error", "Invalid Login Credentials!");
			return "redirect:/";
		}
	}
	
	// ====================================================
	// LOGOUT
	// ====================================================
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// session.invalidate() clears out entire session, so no 'userId' will be in there and the user will be logged out!
		session.invalidate();
		return "redirect:/";
	}
	
	// ====================================================
	// DASHBOARD
	// ====================================================
	
	@RequestMapping("/dashboard")
	public String dashboard(
			Model model, 
			HttpSession session,
			RedirectAttributes redirect) {
		// pull userId from session, if it's not in session, no one is logged in!
		// you are going to pull the info from session via the label you set when you added it to session
		// session.setAttrbute('userId') == session.getAttribute('userId') : 'userId' in both places!
		Long userId = (Long) session.getAttribute("userId");
		// check to see if userId is null
		if(userId == null) {
			redirect.addFlashAttribute("please", "Please Register or Login before entering our site!");
			return "redirect:/";
		}
		
		// add the user to the model, so we can access their information and display their name :)
		model.addAttribute("user", userServ.findUserById(userId));
		model.addAttribute("tasks", taskServ.findAllTasks());
		return "dashboard.jsp";
	}
	
	// ====================================================
	// TASK ROUTES
	// ====================================================
	
	@RequestMapping("/task/new")
	public String newTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("users", userServ.findAllUsers());
		return "newTask.jsp";
	}
	
	@RequestMapping(value="/task/new", method=RequestMethod.POST)
	public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("users", userServ.findAllUsers());
			return "newTask.jsp";
		} else {
			taskServ.saveTask(task);
			return "redirect:/dashboard";
		}
	}
	
	// =================================================
	// SHOW TASK ROUTE
	// =================================================
	
	@RequestMapping("/task/{id}")
	public String showTask(
			@PathVariable("id") Long taskId,
			Model model) {
		
		Task task = taskServ.findTaskById(taskId);
		model.addAttribute("task", task);
		return "showTask.jsp";
	}
	
	// =================================================
	// EDIT TASK ROUTES
	// =================================================
	
	@RequestMapping("/task/{id}/edit")
	public String editTask(
			@PathVariable("id") Long taskId,
			Model model) {
		Task task = taskServ.findTaskById(taskId);
		model.addAttribute("task", task);
		model.addAttribute("users", userServ.findAllUsers());
		return "editTask.jsp";
	}
	
	@RequestMapping(value="/task/{id}/edit", method=RequestMethod.PUT)
	public String updateTask(@Valid @ModelAttribute("task") Task task, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("users", userServ.findAllUsers());
			return "editTask.jsp";
		} else {
			taskServ.saveTask(task);
			return "redirect:/dashboard";
		}
	}
	
	// =================================================
	// DELETE TASK ROUTE
	// =================================================
	
	@RequestMapping(value="/task/{id}/delete", method=RequestMethod.DELETE)
	public String deleteTask(
			@PathVariable("id") Long taskId) {
		taskServ.deleteTask(taskId);
		return "redirect:/dashboard";
	}
}
