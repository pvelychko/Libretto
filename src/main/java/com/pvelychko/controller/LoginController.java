package com.pvelychko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Login method controller class
 * @author pvelychko
 *
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * Login handler method
     * @param model
     * @return view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) { // @RequestParam String error
//        LOGGER.debug("Getting login page, error={}", error);
//        return new ModelAndView("login", "error", error);
    	model.addAttribute("error", null);
    	return "login";
    }
    
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView getLoginPage(@RequestParam String error, Model model) { // 
//        LOGGER.debug("Getting login page, error={}", error);
//    	model.addAttribute("error", "");
//        return new ModelAndView("login", "error", error);
//    }

}