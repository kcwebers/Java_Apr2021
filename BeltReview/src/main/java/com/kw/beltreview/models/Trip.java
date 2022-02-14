package com.kw.beltreview.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="trips")
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, message="Location must be at least 5 characters long!")
	private String location;
	
	@NotNull(message="Please supply a date!")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotNull
	@Size(min=10, message="Description must be at least 10 characters long!")
	private String description;
	
	
	// =============================================
	// MANY TO ONE W/ USERS
	// =============================================
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User organizer;
	
	// =============================================
	// MANY TO MANY W/ USERS
	// =============================================
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "travellers", 
        joinColumns = @JoinColumn(name = "trip_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> attendees;
	
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
	
	// =============================================
	// CONSTRUCTORS
	// =============================================
	
	public Trip() {}
	
	public Trip(@NotNull @Size(min = 5, message = "Location must be at least 5 characters long!") String location,
			@NotNull(message = "Please supply a date!") Date date,
			@NotNull @Size(min = 10, message = "Description must be at least 10 characters long!") String description,
			User organizer) {
		this.location = location;
		this.date = date;
		this.description = description;
		this.organizer = organizer;
	}
	
	
	// =============================================
	// GETTERS AND SETTERS
	// =============================================
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getOrganizer() {
		return organizer;
	}
	public void setOrganizer(User organizer) {
		this.organizer = organizer;
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
	public List<User> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	
}
