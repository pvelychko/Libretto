package com.pvelychko.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student extends BaseItem {
	private static final long serialVersionUID = 6358734948579326812L;

    @Column(name="email", nullable=false)
    private String email;

	@Column(name="password", nullable=false)
    private String password;
	
	@OneToMany(targetEntity = Book.class)
	@JoinColumn(name = "studentId")
	private Set<Book> books = new HashSet<>();

    // Email
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// Password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	// Books
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
