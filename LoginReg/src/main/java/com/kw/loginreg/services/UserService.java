package com.kw.loginreg.services;

import java.util.Optional;

import javax.persistence.Query;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.kw.loginreg.models.User;
import com.kw.loginreg.repositories.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepository;
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
    	// makes sure we set/save the hashed password!!
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
    	Optional<User> u = userRepository.findByEmail(email);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user (login specific)
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
    	Optional<User> user = userRepository.findByEmail(email);
        // if we can't find it by email, return false

        if(user == null) {
            return false;
        } else {
        	User u = user.get();
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, u.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}


