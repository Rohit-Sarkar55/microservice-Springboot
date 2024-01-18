package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Theatre;
import com.deloitte.repository.TheatreRepository;


@Service
public class TheatreServiceImpl implements TheatreService {
	
	
	

	@Autowired
	TheatreRepository repository;
	
	
	@Override
	public Theatre addTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		return repository.save(theatre);	
	}

	@Override
	public Theatre searchTheatreById(int theatreId) {
		// TODO Auto-generated method stub
		return repository.findById(theatreId).orElse(null);
	}

	@Override
	public List<Theatre> getAllTheatres() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Theatre addMovieInThisTheatre(int theatreId, int movieId) {
		// TODO Auto-generated method stub
		Theatre theatre = searchTheatreById(theatreId);
		theatre.addMovieInThisTheatre(movieId);
		return theatre;
	}

}
