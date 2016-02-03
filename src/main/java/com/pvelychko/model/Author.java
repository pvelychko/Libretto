package com.pvelychko.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Author extends BaseItem {
	
	@Column(name="dateOfBirth", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;
	
	@Column(name="dateOfDeath", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfDeath;
	
	@Column(name="bio", nullable = false, length = 2048)
	private String bio;

	@ManyToMany
	@JoinTable(name = "Author_Books", joinColumns = {@JoinColumn(name = "authorId") }, inverseJoinColumns = {@JoinColumn(name = "books") })
	private Set<String> books = new HashSet<>();
	
	// DateOfBirth
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// DateOfDeath
	public Date getDateOfDeath() {
		return dateOfDeath;
	}
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	// Biography
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}

	// Books
	public Set<String> getBooks() {
		return books;
	}
	public void setBooks(Set<String> books) {
		this.books = books;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.getId();
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        Author other = (Author) obj;
        if (super.getId() != other.getId())
            return false;
        if (super.getName() == null) {
            if (other.getName() != null)
                return false;
        } else if (!super.getName().equals(other.getName()))
            return false;
        return true;
    }
	
	@Override
    public String toString() {
        return "Author [id=" + super.getId() + ", name=" + super.getName()
        		+ ", dateOfBirth=" + dateOfBirth.toString() 
        		+ (dateOfDeath == null ? "" : ", name=" + super.getName())
        		+ ", bio=" + bio + ", books=" + books.size() 
        		+ ", since=" + super.getSince().toString() +"]";
    }
	
}
