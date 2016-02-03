package com.pvelychko.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvelychko.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
