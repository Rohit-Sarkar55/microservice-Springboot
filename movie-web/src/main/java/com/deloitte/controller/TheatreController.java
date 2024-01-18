package com.deloitte.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.entity.Movie;
import com.deloitte.entity.Theatre;
import com.deloitte.service.MovieService;
import com.deloitte.service.TheatreService;

@Controller
@RequestMapping("/theatres")
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping("")
	public ModelAndView viewAll() {
		System.out.println("view all");
		List<Theatre> list = theatreService.getAllTheatres();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewtheatres");
		mv.addObject("theatres", list);
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView create(Theatre theatre) {
		System.out.println("View All");
		Theatre t = theatreService.addTheatre(theatre);
		System.out.println(t);
		List<Theatre> list = theatreService.getAllTheatres();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewtheatres");
		mv.addObject("theatres", list);
		return mv;
	}
	@RequestMapping("{theatreId}")
	public ModelAndView showThisTheatre(@PathVariable int theatreId) {
		System.out.println("show this");
		Theatre t = theatreService.searchTheatreById(theatreId);
		System.out.println(t);
		
		List<Movie> movies = new ArrayList<>();
		for(int movieId: t.getListOfMovieIds()) {
			Movie movie = movieService.searchById(movieId);
			movies.add(movie);
		}
		
		List<Movie> restAll = movieService.getAllMovies();
		restAll = restAll.stream().
				filter((m)->( ! t.getListOfMovieIds().contains(m.getMovieId())   ))
				.toList();
		
		System.out.println(restAll);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewTheatre");
		mv.addObject("theatre", t);
		mv.addObject("movies", movies);
		mv.addObject("restmovies", restAll);
		return mv;
	}
	
	@RequestMapping("{theatreId}/addmovie")
	public ModelAndView addMovie( @PathVariable int theatreId , @RequestParam int movieId) {
		System.out.println(theatreId + " " + movieId);
		
		Theatre theatre = theatreService.addMovieInThisTheatre(theatreId, movieId);
		Theatre updatedTheatre = theatreService.addTheatre(theatre);
		return showThisTheatre(theatreId);
	}
	
	@RequestMapping("{theatreId}/deletemovie/{movieId}")
	public ModelAndView deleteMovie(@PathVariable int theatreId , @PathVariable int movieId ) {
		System.out.println(theatreId + " " + movieId);
		Theatre theatre = theatreService.deleteMovieFromThisTheatre(theatreId, movieId);
		Theatre updatedTheatre = theatreService.addTheatre(theatre);
		System.out.println(updatedTheatre);
		return showThisTheatre(theatreId);
	}
}
