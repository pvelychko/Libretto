package com.pvelychko.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.Category;
import com.pvelychko.domain.User;

/**
 * Book repository interface
 * @author pvelychko
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	Collection<Book> findByStudent(User student);
	Collection<Book> findByCategory(Category category);
	
}