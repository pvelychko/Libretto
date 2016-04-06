package com.pvelychko.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.Category;
import com.pvelychko.service.BookService;
import com.pvelychko.service.CategoryService;

/**
 * Books controller class
 * 
 * @author pvelychko
 *
 */
@Controller
public class BooksController {

	private final CategoryService categoryService;
	private final BookService bookService;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksController.class);

    /**
     * Constructor
     * @param categoryService
     * @param bookService
     */
    @Autowired
    public BooksController(CategoryService categoryService, BookService bookService) {
    	this.categoryService = categoryService;
        this.bookService = bookService;
    }
    
    /**
     * Get category info by id
     * @param id
     * @param model
     * @return view
     */
    @RequestMapping("/category/{id}")
    public String getUserPage(@PathVariable Integer id, Model model) {
        LOGGER.debug("Getting books page for category={}", id);
        
        Category category = categoryService.getCategoryById(id);
//        .orElseThrow(() -> 
//        		new NoSuchElementException(String.format("Category=%s not found", id)));
//        
        model.addAttribute("currentCategory", category);
        model.addAttribute("currentBook", null);
        model.addAttribute("books", bookService.getBookByCategory(category));
        
        return "home";
    }
    
    /**
     * Get book info by id
     * @param id
     * @param model
     * @return view
     */
    @RequestMapping("/book/{id}")
    public String getBookPage(@PathVariable Integer id, Model model) {
        LOGGER.debug("Getting page for book={}", id);
        
        Book book = bookService.getBookById(id);
//        .orElseThrow(() -> 
//        		new NoSuchElementException(String.format("Book=%s not found", id)));
//        
        model.addAttribute("currentCategory", book.getCategory());
        model.addAttribute("currentBook", book);
        
        return "home";
    }
    
}