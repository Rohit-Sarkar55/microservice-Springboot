package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Theatre;

public interface TheatreService {
	Theatre addTheatre(Theatre threatre);
	
	Theatre searchTheatreById(int theatreId);
	
	List<Theatre> getAllTheatres();
	
	Theatre addMovieInThisTheatre(int theatreId , int movieId);
	Theatre deleteMovieFromThisTheatre(int theatreId , int movieId);
}
