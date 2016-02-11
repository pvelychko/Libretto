package com.pvelychko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book extends BaseItem {
	private static final long serialVersionUID = 5254351674848793215L;
	
	@Column(name="author", nullable=false)
	private String author;
	
	@Column(name="amountOfPages", nullable=false)
	private int amountOfPages;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@Column(name="isbn13", nullable=false)
	private String isbn13;
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private User student;
	
	// Author
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// AmountOfPages
	public int getAmountOfPages() {
		return amountOfPages;
	}
	public void setAmountOfPages(int amountOfPages) {
		this.amountOfPages = amountOfPages;
	}
	
	// Category
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	// Isbn13
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	// Student
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	
}
