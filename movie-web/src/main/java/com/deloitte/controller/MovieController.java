package com.deloitte.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.entity.Actor;
import com.deloitte.entity.Movie;
import com.deloitte.entity.Theatre;
import com.deloitte.service.ActorService;
import com.deloitte.service.MovieService;
import com.deloitte.service.TheatreService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	TheatreService theatreService;
	
	@Autowired
	ActorService actorService;
	
	
	@RequestMapping("")
	public ModelAndView viewAll() {
		System.out.println("all");
		List<Movie> movies = movieService.getAllMovies();
		List<Actor> actors = actorService.getAllActors();
		System.out.println(actors);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewmovies");
		mv.addObject("movies", movies);
		mv.addObject("actors", actors);
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView create(Movie movie) {
		System.out.println("Create");
		
		Movie m = movieService.addMovie(movie);
		return viewAll();
	}
	
	@RequestMapping("{movieId}")
	public ModelAndView showThis(@PathVariable int movieId) {
		System.out.println("Show This");
		
		Movie m = movieService.searchById(movieId);
		System.out.println(m);
		
		List<Theatre> allTheatre = theatreService.getAllTheatres();
		List<Theatre> theatreList =allTheatre.stream()
				.filter((t) -> (t.getListOfMovieIds()
						.contains(m.getMovieId()))).toList();
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewMovie");
		mv.addObject("movie", m);
		mv.addObject("theatres", theatreList);
		return mv;
	}
	
}