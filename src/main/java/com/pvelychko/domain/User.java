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

/**
 * USer entity class
 * @author pvelychko
 *
 */
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
	/**
	 * Get email
	 * @return
	 */
    public String getEmail() {
		return email;
	}
    /**
     * Set email
     * @param email
     */
	public void setEmail(String email) {
		this.email = email;
	}

	// PasswordHash
	/**
	 * Get password hash
	 * @return
	 */
	public String getPasswordHash() {
		return passwordHash;
	}
	/**
	 * Set password hash
	 * @param passwordHash
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	// Role
	/**
	 * Get role
	 * @return
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * Set password hash
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	// Books
	/**
	 * Get list of books
	 * @return
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * Set list of books
	 * @param books
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
