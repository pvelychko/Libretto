package com.pvelychko.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.pvelychko.domain.Book;

public interface BookOwnRepository extends Repository<Book, Integer>{
	@Query(value="select author from Book b where b.author=?1")
	List<Book> findByName(String name);
	List<Book> findByAuthor(String author);
	List<Book> findByNameAndAuthor(String name, String author);
}
