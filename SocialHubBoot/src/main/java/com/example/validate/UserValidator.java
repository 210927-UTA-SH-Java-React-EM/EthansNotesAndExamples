package com.example.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.models.User;

/*
 * Spring core provides a validator interface that works with spring errors as well as DataBinder
 * 
 * 
 */
public class UserValidator implements Validator{
	
	//This method is called first to make sure the validator will work with a given object
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}
	
	//If the object passes the support method, then the validate method is called
	@Override
	public void validate(Object target, Errors errors) {
		// Going to check to see if the input user object contains first name
		// Takes in the errors object, the attribute we want to validate
		// The error "status code"
		// The message we want to see if something goes wrong
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty", "The user must have a first name");
		
		
		
		User u = (User)target;
		if(u.getId() < 1) {
			//rejectValue is taking the name of the attribute we want to check
			//A error status code
			// The message we want to print out
			errors.rejectValue("id", "invalid.id", "User id should be a positive number");
		}
	}
	
	
	
}
