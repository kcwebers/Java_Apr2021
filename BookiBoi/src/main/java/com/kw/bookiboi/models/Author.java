package com.kw.bookiboi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="authors")
public class Author {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=75)
	private String firstName;
	
	@NotNull
	@Size(min=2, max=75)
	private String  lastName;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // =======================================
    // Related Data - 1:n
    // =======================================
    
    @OneToMany(mappedBy="author", fetch=FetchType.LAZY)
    private List<Book> books; 
    
    // =======================================
    // Related Data - n:m
    // =======================================
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "authors_books", 
        joinColumns = @JoinColumn(name = "author_id"), 
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> booksFavorited;
    
    // =======================================
    // Constructors
    // =======================================
    
    public Author () {}

	public Author(
			@NotNull @Size(min = 2, max = 75) String firstName,
			@NotNull @Size(min = 2, max = 75) String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	// =======================================
    // Getters & Setters
    // =======================================
    
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<Book> getBooksFavorited() {
		return booksFavorited;
	}
	public void setBooksFavorited(List<Book> booksFavorited) {
		this.booksFavorited = booksFavorited;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}
