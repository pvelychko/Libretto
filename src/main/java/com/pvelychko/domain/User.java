package com.pvelychko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
}
