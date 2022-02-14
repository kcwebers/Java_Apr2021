package com.kw.carproject.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kw.carproject.models.LoginUser;
import com.kw.carproject.models.User;
import com.kw.carproject.repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepo;
    public UserService(UserRepository userRepo) {
    	this.userRepo = userRepo;
    }
    
    public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirmation Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Invalid credentials!!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("email", "Matches", "Invalid credentials!!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    // ==========================
    // Find One User based on Id
    // ==========================
    
    public User getUserInfo(Long id) {
    	Optional<User> optionalUser = userRepo.findById(id);
    	if(optionalUser.isPresent()) {
    		return optionalUser.get();
    	} else {
    		return null;
    	}
    }
    
}
