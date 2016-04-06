package com.pvelychko.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category entity class
 * @author pvelychko
 *
 */
@Entity
@Table(name="Categories")
public class Category extends BaseItem {
	private static final long serialVersionUID = 1202249013435539391L;
	
	@OneToMany(targetEntity = Book.class)
	@JoinColumn(name = "categoryId")
	private Set<Book> books = new HashSet<>();

	// Books
	/**
	 * Get list of books
	 * @return
	 */
	public Set<Book> getBooks() {
		return books;
	}
	/**
	 * Set list of books
	 * @param books
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
}
