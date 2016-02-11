package com.pvelychko.service;

import java.util.Collection;
import java.util.Optional;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.User;

public interface BookService {

    Optional<Book> getBookById(int id);

    Optional<Book> getBookByName(String name);
    
    Optional<Book> getBookByAuthor(String author);

    Collection<Book> getUserBooks(User student);
    
    Collection<Book> getAllBooks();

    Collection<Book> getAvailableBooks();
    
    Collection<Book> getBorrowedBooks();

}