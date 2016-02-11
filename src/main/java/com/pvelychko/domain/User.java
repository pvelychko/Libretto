package com.pvelychko.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User extends BaseItem {
	private static final long serialVersionUID = -662182071362633226L;

	@Column(name = "email", nullable = false, unique = true)
    private String email;

	@Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
	@OneToMany(targetEntity = Book.class)
	@JoinColumn(name = "studentId")
	private List<Book> books = new ArrayList<>();
    
    // Email
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// PasswordHash
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	// Role
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	// Books
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
