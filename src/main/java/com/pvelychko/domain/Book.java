package com.pvelychko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Book entity class
 * @author pvelychko
 *
 */
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
	/**
	 * Get author
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * Set author
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// AmountOfPages
	/**
	 * Get amount of pages
	 * @return
	 */
	public int getAmountOfPages() {
		return amountOfPages;
	}
	/**
	 * Set amount of pages
	 * @param amountOfPages
	 */
	public void setAmountOfPages(int amountOfPages) {
		this.amountOfPages = amountOfPages;
	}
	
	// Category
	/**
	 * Get category
	 * @return
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * Set category
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	// Isbn13
	/**
	 * Get isbn
	 * @return isbn
	 */
	public String getIsbn13() {
		return isbn13;
	}
	/**
	 * Set isbn
	 * @param isbn13
	 */
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	// Student
	/**
	 * Get student
	 * @return student
	 */
	public User getStudent() {
		return student;
	}
	/**
	 * Set student
	 * @param student
	 */
	public void setStudent(User student) {
		this.student = student;
	}
	
}
