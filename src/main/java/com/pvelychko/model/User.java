package com.pvelychko.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.pvelychko.model.enums.State;

public class User extends BaseItem {
 
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
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.getId();
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (super.getId() != other.getId())
            return false;
        if (super.getName() == null) {
            if (other.getName() != null)
                return false;
        } else if (!email.equals(other.getEmail()))
            return false;
        return true;
    }
	
	@Override
    public String toString() {
        return "User [id=" + super.getId() + ", name=" + super.getName()
        		+ (ssoId == null ? "" : ", ssoId=" + ssoId)
        		+ (email == null ? "" : ", email=" + email)
        		+ (state == null ? "" : ", state=" + state)
        		+ ", userProfiles=" + userProfiles.size() +"]";
    }
    
}
