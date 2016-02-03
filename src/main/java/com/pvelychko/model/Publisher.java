package com.pvelychko.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Publisher extends BaseItem {
	
	@OneToMany(targetEntity = Book.class)
	@JoinColumn(name = "publisherId")
	private Set<Book> books = new HashSet<>();
	
	@Column(nullable = true, length = 128)
	private String website;
	
	@Column(nullable = true, length = 15)
	private String tel;
	
	@Column(nullable = false, length = 64)
	private String email;
	
	// Books
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	// Website
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	// Telephone
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	// Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.getId();
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        result = prime * result + (email == null ? 0 : email.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Publisher))
            return false;
        Publisher other = (Publisher) obj;
        if (super.getId() != other.getId())
            return false;
        if (email == null) {
            if (other.getEmail() != null)
                return false;
        } else if (!email.equals(other.getEmail()))
            return false;
        return true;
    }
	
	@Override
    public String toString() {
        return "Publisher [id=" + super.getId() + ", name=" + super.getName()
        		+ ", books=" + books.size() 
        		+ (website == null ? "" : ", website=" + website)
        		+ (tel == null ? "" : ", tel=" + tel)
        		+ (email == null ? "" : ", email=" + email) +"]";
    }
	
}
