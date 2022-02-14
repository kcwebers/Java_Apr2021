package com.kw.bookauth.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="authors")
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Please add a value to the First Name field!")
	@Size(min=2, max=100, message="First Name must be between 2-100 characters!")
	private String firstName;
	
	@NotEmpty(message = "Please add a value to the Last Name field!")
	@Size(min=2, max=100, message="Last Name must be between 2-100 characters!")
	private String lastName;
	
	@Min(18)
	@Max(100)
	private Integer age;

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
    
    // ============================
    // One to Many Relationship with Book
    // ============================
    
    @OneToMany(mappedBy="author", fetch=FetchType.LAZY)
    private List<Book> booksWritten;
    
    // ============================
    // Constructors
    // ============================

    public Author() {}
    
	public Author(
			@NotEmpty(message = "Please add a value to the First Name field!") @Size(min = 2, max = 100, message = "First Name must be between 2-100 characters!") String firstName,
			@NotEmpty(message = "Please add a value to the Last Name field!") @Size(min = 2, max = 100, message = "Last Name must be between 2-100 characters!") String lastName,
			@Min(18) @Max(100) Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
    // ============================
    // Getters & Setters
    // ============================
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public List<Book> getBooksWritten() {
		return booksWritten;
	}
	public void setBooksWritten(List<Book> booksWritten) {
		this.booksWritten = booksWritten;
	}

}
