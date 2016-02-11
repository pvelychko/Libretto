package com.pvelychko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pvelychko.service.BookService;
import com.pvelychko.service.UserService;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    //private final BookService bookService;

    
//    @Autowired
//    public HomeController() { // BookService bookService
//        //this.bookService = bookService;
//    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(@ModelAttribute("model") ModelMap model) {
        //LOGGER.debug("Getting books page"); 
        //model.addAttribute("books", bookService.getAllBooks());
        
        LOGGER.debug("Getting home page");
        return "home";
    }

}