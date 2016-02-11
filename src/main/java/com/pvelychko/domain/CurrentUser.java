package com.pvelychko.domain;

import java.util.List;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = -2105985446632492581L;
	
	private User user;
	
    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    // User
    public User getUser() {
        return user;
    }

    // Id
    public Integer getId() {
        return user.getId();
    }

	// Name
    public String getName() {
        return user.getName();
    }
    
	// Name
    public String getEmail() {
        return user.getEmail();
    }
    
    // Role
    public Role getRole() {
        return user.getRole();
    }
    
    // Books
    public List<Book> getBooks() {
        return user.getBooks();
    }

    @Override
    public String toString() {
        return "CurrentUser{user=" + user + "} " + super.toString();
    }
    
}