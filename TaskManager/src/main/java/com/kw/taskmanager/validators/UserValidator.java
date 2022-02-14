package com.kw.taskmanager.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kw.taskmanager.models.User;

@Component
public class UserValidator implements Validator {
    // both methods here are necessary and leave as is!
	// they are overriding methods that are coming from the Validator!
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // this custom validation checks if our password matches the confirmationPassword
    // it throws an error message vis the 'messages.properties' file we create!
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}


