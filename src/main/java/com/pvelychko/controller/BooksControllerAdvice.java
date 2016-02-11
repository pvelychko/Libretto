package com.pvelychko.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.CurrentUser;
import com.pvelychko.service.BookService;

@ControllerAdvice
public class BooksControllerAdvice {

	private final BookService bookService;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksControllerAdvice.class);

    @Autowired
    public BooksControllerAdvice(BookService bookService) {
        this.bookService = bookService;
    }
    
    @ModelAttribute("books")
    public List<Book> getBooks() {
        return (List<Book>) bookService.getAllBooks();
    }
    
    @ModelAttribute("availableBooks")
    public List<Book> getAvailableBooks() {
        return (List<Book>) bookService.getAvailableBooks();
    }
    
//    @ModelAttribute("myBooks")
//    public List<Book> getMyBooks() {
//        return (List<Book>) bookService.getUserBooks(currentUser.getUser());
//    }

}