package com.pvelychko.service;

import java.util.Collection;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.Category;
import com.pvelychko.domain.User;

/**
 * Book service interface
 * @author pvelychko
 *
 */
public interface BookService {

    Book getBookById(int id);

    Book getBookByName(String name);
    
    Book getBookByAuthor(String author);
    Collection<Book> getBookByCategory(Category category);

    Collection<Book> getUserBooks(User student);
    
    Collection<Book> getAllBooks();

    Collection<Book> getAvailableBooks();
    
    Collection<Book> getBorrowedBooks();

    Collection<Category> getCategories();
    
	Book borrowBook(Book book, User student);
	Book returnBook(Book book);

}