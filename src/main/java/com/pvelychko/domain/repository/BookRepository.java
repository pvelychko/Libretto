package com.pvelychko.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvelychko.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}