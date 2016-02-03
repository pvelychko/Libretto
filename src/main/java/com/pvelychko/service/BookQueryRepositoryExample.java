package com.pvelychko.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.pvelychko.domain.Book;

public interface BookQueryRepositoryExample extends Repository<Book, Integer> {
	@Query(value = "select name, author from Book b where b.name like %?1%")
	public List<Book> findByName(String name);

	@Query(value = "select name, author from Book b where b.name like %:name%")
	public List<Book> findByNameMatch(@Param("name") String name);
	
	@Modifying
	@Query(value = "update Book b set b.studentId = ?1 where b.id = ?2")
	public void borrow(int studentId, int bookId);
	
	@Modifying
	@Query(value = "update Book b set b.studentId = null where b.id = ?1")
	public void bringBack(int bookId);
}
