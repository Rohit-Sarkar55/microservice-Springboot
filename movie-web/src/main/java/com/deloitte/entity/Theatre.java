package com.deloitte.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;


@Entity
@Table(name = "theatres")
public class Theatre {
	
	
	
	
	@Id
	@Column(name = "theatreId")
	@TableGenerator(name = "theatre_seq",table="theatre_seq_tab", pkColumnName = "theatre_pk",
	valueColumnName = "theatre-val", pkColumnValue = "theatre", 
	initialValue = 3001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE , generator = "theatre_seq")
	
	private int theatreId;
	private String name;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private List<Integer> listOfMovieIds;
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getListOfMovieIds() {
		if(listOfMovieIds == null) {
			setListOfMovieIds(new ArrayList<>());
		}
		return listOfMovieIds;
	}
	public void setListOfMovieIds(List<Integer> listOfMovieIds) {
		this.listOfMovieIds = listOfMovieIds;
	}
	
	
	public void addMovieInThisTheatre(int movieId) {
		if(this.listOfMovieIds == null) {
			getListOfMovieIds();
		}
		this.listOfMovieIds.add(movieId);
	}
	
	public void deleteMovieFromThisTheatre(int movieId) {
		if(this.listOfMovieIds.contains(movieId)) {
			Iterator itr = this.listOfMovieIds.iterator();
			while(itr.hasNext()) {
				int it = (int) itr.next();
				if(it == movieId) {
					itr.remove();
				}
			}
		}
	}
}
