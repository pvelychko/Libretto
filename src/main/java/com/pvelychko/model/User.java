package com.pvelychko.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class User {
 
    @Column(name="ssoId", unique=true, nullable=false)
    private String ssoId;
     
    @Column(name="password", nullable=false)
    private String password;
 
    @Column(name="email", nullable=false)
    private String email;
 
    @Column(name="state", nullable=false)
    private String state= State.ACTIVE.getState();
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_UserProfile", 
             joinColumns = {@JoinColumn(name = "USER_ID")}, 
             inverseJoinColumns = {@JoinColumn(name = "USER_PROFILE_ID")})
    private Set<UserProfile> userProfiles = new HashSet<>();

    // SsoId
	public String getSsoId() {
		return ssoId;
	}
	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	// Password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	// Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// State
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	// UserProfiles
	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}
	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
    
}
