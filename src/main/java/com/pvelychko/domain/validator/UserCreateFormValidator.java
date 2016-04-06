package com.pvelychko.domain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pvelychko.domain.UserCreateForm;
import com.pvelychko.service.UserService;

/**
 * New user creation form validator class
 * @author pvelychko
 *
 */
@Component
public class UserCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateFormValidator.class);
    private final UserService userService;

    /**
     * Constructor
     * @param userService
     */
    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    /**
     * Check if class supports user creation
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    /**
     * Validate user creation form
     */
    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    /**
     * Validate passwords
     * @param errors
     * @param form
     */
    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    /**
     * Validate email
     * @param errors
     * @param form
     */
    private void validateEmail(Errors errors, UserCreateForm form) {
//        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
    	if (userService.getUserByEmail(form.getEmail()) != null) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}