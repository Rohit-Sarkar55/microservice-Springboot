package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.client.ActorFeign;
import com.deloitte.dto.Actor;
import com.deloitte.entity.Movie;
import com.deloitte.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	ActorFeign actorFeign;
	
	@PostMapping("add")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@GetMapping("")
	public List<Movie> getAll(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("{movieId}")
	public Movie search(@PathVariable int movieId) {
		return movieService.searchById(movieId);
	}
	
	@GetMapping("findactorofthismovie/{movieId}")
	public Actor findActor(@PathVariable int movieId) {
		Movie movie = movieService.searchById(movieId);
		return actorFeign.search(movie.getActorId());
	}
	
	@GetMapping("findactorbyactorid/{actorId}")
	public Actor findActorbyActorId(@PathVariable int actorId) {
		return actorFeign.search(actorId);
	}
	
	@GetMapping("findmoviesbyactorid/{actorId}")
	public List<Movie> findMoviesByActorId(@PathVariable int actorId) {
		List<Movie> movies = movieService.getMoviesByActorId(actorId);
		return movies;
	}
	
}
