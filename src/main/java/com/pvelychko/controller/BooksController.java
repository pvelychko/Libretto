package com.pvelychko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pvelychko.service.BookService;

@Controller
public class BooksController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooksController.class);
    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public String books(@ModelAttribute("model") ModelMap model) {
//        LOGGER.debug("Getting books page");
//        model.addAttribute("books", bookService.getAllBooks());
//        return "books";
//    }
//    
//    @RequestMapping(value = "/books/available", method = RequestMethod.GET)
//    public String availableBooks(@ModelAttribute("model") ModelMap model) {
//        LOGGER.debug("Getting available books page");
//        model.addAttribute("availableBooks", bookService.getAllAvailableBooks());
//        return "books";
//    }

}