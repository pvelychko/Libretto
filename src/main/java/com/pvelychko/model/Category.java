package com.pvelychko.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Category extends BaseItem {
	
	@Column(nullable = false, length = 1024)
	private String description;
	
	@OneToMany(targetEntity = Book.class)
	@JoinColumn(name = "categoryId")
	private Set<Book> books;
	
	// Description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Books
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.getId();
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        Category other = (Category) obj;
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
        return "Category [id=" + super.getId() + ", name=" + super.getName()
        		+ ", books=" + books.size()
        		+ ", description=" + description +"]";
    }
	
}
