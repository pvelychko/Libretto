package com.pvelychko.service.user;

import java.util.Collection;
import java.util.Optional;

import com.pvelychko.domain.Book;

public interface BookService {

    Optional<Book> getBookById(int id);

    Optional<Book> getBookByName(String name);
    
    Optional<Book> getBookByAuthor(String author);

    Collection<Book> getAllBooks();

    Collection<Book> getAllAvailableBooks();
    
    Collection<Book> getAllBorrowedBooks();

}