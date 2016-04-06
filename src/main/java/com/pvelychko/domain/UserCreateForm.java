package com.pvelychko.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * User creation form class
 * @author pvelychko
 *
 */
public class UserCreateForm {

    @NotEmpty
    private String name = "";
	
    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private Role role = Role.USER;

    // Name
    /**
     * Get name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
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

    // Password
    /**
     * Get password
     * @return
     */
    public String getPassword() {
        return password;
    }
    /**
     * Set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    // PasswordRepeated
    /**
     * Get password repeat
     * @return
     */
    public String getPasswordRepeated() {
        return passwordRepeated;
    }
    /**
     * Set password repeat
     * @param passwordRepeated
     */
    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
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
     * Set role
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
        		"name='" + name + '\'' +
                "email='" + email.replaceFirst("@.+", "@***") + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                ", role=" + role +
                '}';
    }

}
