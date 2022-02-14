package com.kw.carproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kw.carproject.models.Car;
import com.kw.carproject.models.LoginUser;
import com.kw.carproject.models.User;
import com.kw.carproject.services.CarService;
import com.kw.carproject.services.UserService;

@Controller
public class MainController {
	
    private UserService userServ;
    private final CarService carServ;
    public MainController(UserService userServ, CarService carServ) {
    	this.userServ = userServ;
    	this.carServ = carServ;
    }
    
    // ===================================
    // Render Login/Register page
    // ===================================
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    // ===================================
    // Process Register route
    // ===================================
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, 
    		Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        // user id put into session
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    
    // ===================================
    // Process Login route
    // ===================================
     
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, 
    		Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        // user id put into session
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
    
    // ===================================
    // Logout Route
    // ===================================
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    // ===================================
    // Render Dashboard Route
    // ===================================
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model,
    		RedirectAttributes flash) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		flash.addFlashAttribute("login", "Please login or register before entering site!!");
    		return "redirect:/"; 
    	}
    	
    	User user = userServ.getUserInfo(userId);
    	model.addAttribute("loggedUser", user);
    	
    	List<Car> cars = carServ.getAllCars();
    	model.addAttribute("cars", cars);
    	
    	return "dashboard.jsp";
    }
	
    // ===================================
    // Create Routes
    // ===================================
    
    @GetMapping("/new")
    public String newCar(HttpSession session, RedirectAttributes flash, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		flash.addFlashAttribute("login", "Please login or register before entering site!!");
    		return "redirect:/"; 
    	}
    	
    	model.addAttribute("userId", userId);
    	model.addAttribute("car", new Car());
    	
    	return "new.jsp";
    }
    
    @PostMapping("/create")
	public String createCar(@Valid @ModelAttribute("car") Car car, BindingResult result,
			HttpSession session, Model model) {
    	if(result.hasErrors()) {
    		Long userId = (Long) session.getAttribute("user_id");
    		model.addAttribute("userId", userId);
    		return "new.jsp";
    	} else {
    		carServ.saveCar(car);
        	return "redirect:/dashboard";
    	}
    }

    // ===================================
    // Show One Route
    // ===================================
    
    @GetMapping("/show/{id}")
    public String showCar(@PathVariable("id") Long carId,
    		HttpSession session, 
    		Model model,
    		RedirectAttributes flash) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		flash.addFlashAttribute("login", "Please login or register before entering site!!");
    		return "redirect:/"; 
    	}
    	
    	Car car = carServ.findOneCar(carId);
    	model.addAttribute("car", car);
    	
    	return "show.jsp";
    }
    
    // ===================================
    // Edit Routes
    // ===================================
    
    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable("id") Long carId,
    		HttpSession session,
    		Model model,
    		RedirectAttributes flash) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		flash.addFlashAttribute("login", "Please login or register before entering site!!");
    		return "redirect:/"; 
    	}
    	
    	Car car = carServ.findOneCar(carId);
//    	System.out.println(car.getDriver().getId());
//    	System.out.println(userId);
    	if(car.getDriver().getId().equals(userId)) {
        	model.addAttribute("car", car);
        	return "edit.jsp";
    	}
		flash.addFlashAttribute("driver", "You must be the driver to edit the car!!");
    	return "redirect:/dashboard";
    }
    
    @PutMapping("/update/{id}")
    public String updateCar(@Valid @ModelAttribute("car") Car car, BindingResult result) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	} else {
    		carServ.saveCar(car);
    		return "redirect:/dashboard";
    	}
    }
    
    // ===================================
    // Delete Route
    // ===================================
    
    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Long carId) {
    	carServ.deleteCar(carId);
    	return "redirect:/dashboard";
    }
    
    
    
}
