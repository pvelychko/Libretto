package com.pvelychko.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.User;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	Collection<Book> findByStudent(User student);
	
}