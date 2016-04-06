package com.pvelychko.domain;

import java.util.List;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Current user class
 * @author pvelychko
 *
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = -2105985446632492581L;
	
	private User user;
	
	/**
	 * Constructor
	 * @param user
	 */
    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    // User
    /**
     * Get user
     * @return
     */
    public User getUser() {
        return user;
    }

    // Id
    /**
     * Get id
     * @return
     */
    public Integer getId() {
        return user.getId();
    }

	// Name
    /**
     * Get name
     * @return
     */
    public String getName() {
        return user.getName();
    }
    
	// Name
    /**
     * Get email
     * @return
     */
    public String getEmail() {
        return user.getEmail();
    }
    
    // Role
    // Get role
    public Role getRole() {
        return user.getRole();
    }
    
    // Books
    /**
     * Get list of books
     * @return
     */
    public List<Book> getBooks() {
        return user.getBooks();
    }

    @Override
    public String toString() {
        return "CurrentUser{user=" + user + "} " + super.toString();
    }
    
}