package com.pvelychko.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvelychko.domain.Book;
import com.pvelychko.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/add/{name}/{author}/{amountOfPages}")
	public Book addBook(@PathVariable String name, @PathVariable String author,
			@PathVariable int amountOfPages) {
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setAmountOfPages(amountOfPages);
		bookService.save(book);
		return book;
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.delete(id);
	}
	
	@RequestMapping(value = "/")
	public List<Book> getBooks() {
		return bookService.findAll();
	}
	
	@RequestMapping(value = "/{id}")
	public Book getBook(@PathVariable int id) {
		Book book = bookService.find(id);
		return book;
	}
	
	@RequestMapping(value = "/search/name/{name}")
	public List<Book> getBookByName(@PathVariable String name) {
		List<Book> books = bookService.findByName(name);
		return books;
	}

	@RequestMapping(value = "/search/{name}/{author}")
	public List<Book> getBookByNameAndAuthor(@PathVariable String name, @PathVariable String author) {
		List<Book> books = bookService.findByNameAndAuthor(name, author);
		return books;
	}
	
	@RequestMapping(value = "/borrow/{studentId}/{bookId}")
	public void borrowBook(@PathVariable Integer studentId, @PathVariable Integer bookId) {
		bookService.borrow(studentId, bookId);
	}
	
	@RequestMapping(value = "/return/{studentId}/{bookId}")
	public void returnBook(@PathVariable Integer bookId) {
		bookService.bringBack(bookId);
	}
	
}
