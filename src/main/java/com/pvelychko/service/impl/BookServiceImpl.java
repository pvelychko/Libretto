package com.pvelychko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pvelychko.domain.Book;
import com.pvelychko.service.BookOwnRepository;
import com.pvelychko.service.BookQueryRepositoryExample;
import com.pvelychko.service.BookRepository;
import com.pvelychko.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookOwnRepository bookOwnRepository;
	@Autowired
	private BookQueryRepositoryExample bookQueryRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public List<Book> findByName(String name) {
		return bookQueryRepository.findByName(name);
	}

	public List<Book> findByNameMatch(String name) {
		return bookQueryRepository.findByNameMatch(name);
	}

	public List<Book> findByNameAndAuthor(String name, String author) {
		return bookOwnRepository.findByNameAndAuthor(name, author);
	}

	public void save(Book book) {
		bookRepository.save(book);
	}

	public Book find(int id) {
		return bookRepository.findOne(id);
	}

	public void delete(int id) {
		bookRepository.delete(id);
	}

	public List<Book> findByAuthor(String author) {
		return bookOwnRepository.findByAuthor(author);
	}

	public void borrow(int studentId, int bookId) {
		bookQueryRepository.borrow(studentId, bookId);
	}
	
	public void bringBack(int bookId) {
		bookQueryRepository.bringBack(bookId);
	}
	
}
