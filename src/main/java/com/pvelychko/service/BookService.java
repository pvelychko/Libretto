package com.pvelychko.service;

import java.util.List;

import com.pvelychko.domain.Book;

public interface BookService {
	
	public Book find(int id);
	public List<Book> findAllAvailable();
	public List<Book> findAllBorrowed();
	
	public void save(Book book);
	
	public void delete(int id);
	
	public List<Book> findByName(String name);
	public List<Book> findByAuthor(String author);
	public List<Book> findByNameAndAuthor(String name, String author);

	public void borrow(int studentId, int bookId);
	public void bringBack(int bookId);
	
}
