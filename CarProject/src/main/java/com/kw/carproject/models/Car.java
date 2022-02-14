package com.kw.carproject.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cars")
public class Car {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 @Size(min=3, max=25, message="Car color must be between 3 and 25 characters long!")
	 private String color;
	 
	 @NotNull
	 @Max(value=15, message="Number of seats cannot exceed 15!")
	 private Integer numberOfSeats;
	 
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
	
	// ===================================
	// Many To One
	// ===================================
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="driver_id")
	private User driver;
	
	// ===================================
	// Constructors
	// ===================================
	
	public Car() {}
	
	public Car(
			@NotNull @Size(min = 3, max = 25, message = "Car color must be between 3 and 25 characters long!") String color,
			@NotNull @Max(value = 15, message = "Number of seats cannot exceed 15!") Integer numberOfSeats,
			User driver) {
		this.color = color;
		this.numberOfSeats = numberOfSeats;
		this.driver = driver;
	}
	
	// ===================================
	// Getters & Setters
	// ===================================
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
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
	public User getDriver() {
		return driver;
	}
	public void setDriver(User driver) {
		this.driver = driver;
	}

}
