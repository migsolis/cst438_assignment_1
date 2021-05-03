package com.cst438.assignment1;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieRating {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=3, max=30)
	private String title;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int rating;
	
	@NotNull
	@Size(min=3, max=30)
	private String user;
	
	private Instant date;
	
	public MovieRating() {
		id = null;
		title = null;
		rating = 0;
		user = null;
		date = null;
	}
	

	public MovieRating(Long id, String title, int rating, String user, Instant date) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.user = user;
		this.date = date;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
}
