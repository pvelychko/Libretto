package com.pvelychko.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.Category;
import com.pvelychko.service.BookService;

/**
 * Books controller helper class
 * @author pvelychko
 *
 */
@ControllerAdvice
public class BooksControllerAdvice {

	private final BookService bookService;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksControllerAdvice.class);

    /**
     * Constructor
     * @param bookService
     */
    @Autowired
    public BooksControllerAdvice(BookService bookService) {
        this.bookService = bookService;
    }
    
    /**
     * Get categories list
     * @return categories
     */
    @ModelAttribute("categories")
    public Collection<Category> getCategories() {
        return bookService.getCategories();
    }
    
    /**
     * Get books list
     * @return books
     */
    @ModelAttribute("books")
    public List<Book> getBooks() {
        return (List<Book>) bookService.getAllBooks();
    }
    
    /**
     * Get available books list
     * @return books
     */
    @ModelAttribute("availableBooks")
    public List<Book> getAvailableBooks() {
        return (List<Book>) bookService.getAvailableBooks();
    }

}