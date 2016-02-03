package com.pvelychko.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category extends BaseItem {
	private static final long serialVersionUID = 1202249013435539391L;
	
	@OneToMany(targetEntity = Book.class)
	@JoinColumn(name = "categoryId")
	private Set<Book> books = new HashSet<>();

	// Books
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
}
