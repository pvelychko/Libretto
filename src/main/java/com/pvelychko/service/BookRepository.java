package com.pvelychko.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pvelychko.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select b.name, b.author, b.amountOfPages, b.isbn13 from Book b, "
			+ "Category c "
			+ "where b.student = null and b.category = c.id")
	public List<Book> findAllAvailable();
	
	@Query("select b.name, b.author, b.amountOfPages, b.isbn13, s.name from Book b, "
			+ "Category c, "
			+ "Student s " 
			+ "where s.id = b.student and b.category = c.id")
	public List<Book> findAllBorrowed();
	
}
