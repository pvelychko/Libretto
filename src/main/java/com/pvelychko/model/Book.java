package com.pvelychko.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pvelychko.model.enums.Language;

@Entity
@Table(name="Books")
public class Book extends BaseItem {
	
	@Column(nullable = true, length = 10)
	private String isbn10;
	
	@Column(nullable = false, length = 13)
	private String isbn13;
	
	@Column(nullable = false, length = 1024)
	private String description;
	
	@ManyToMany(mappedBy = "books")
	private Set<Author> authors;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@Column(nullable = false)
	private int amountOfPages;
	
	@Column(nullable = false)
	private Language language;
	
	@ManyToOne
	@JoinColumn(name = "publisherId")
	private Publisher publisher;
		
	// Isbn10
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	
	// Isbn13
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	// Description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Authors
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	// Category
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	// AmountOfPages
	public int getAmountOfPages() {
		return amountOfPages;
	}
	public void setAmountOfPages(int amountOfPages) {
		this.amountOfPages = amountOfPages;
	}
	
	// Language
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.getId();
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        result = prime * result + ((isbn13 == null) ? 0 : isbn13.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Book))
            return false;
        Book other = (Book) obj;
        if (super.getId() != other.getId())
            return false;
        if (isbn13 == null) {
            if (other.getIsbn13() != null)
                return false;
        } else if (!isbn13.equals(other.getIsbn13()))
            return false;
        return true;
    }
	
	@Override
    public String toString() {
        return "Book [id=" + super.getId() + ", name=" + super.getName()
        		+ (isbn10 == null ? "" : ", isbn10=" + isbn10)
        		+ ", isbn13=" + isbn13
        		+ ", description=" + description
        		+ ", authors=" + authors.size()
        		+ ", category=" + category.getName()
        		+ ", amountOfPages=" + amountOfPages
        		+ ", language=" + language +"]";
    }
	
}
