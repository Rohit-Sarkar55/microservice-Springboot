package com.deloitte.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;


@Entity
@Table(name = "tbl_movies")
public class Movie {
	
	
	@Id
	@Column(name = "movieId")
	@TableGenerator(name = "mov_seq",table="mov_seq_tab", pkColumnName = "mov_pk",
	valueColumnName = "mov-val", pkColumnValue = "mov", 
	initialValue = 2001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE , generator = "mov_seq")
	public int movieId;
	
	
	
	public String name;
	public int actorId;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	
}
