package com.deloitte.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.dto.Movie;



@FeignClient(name = "MOVIE-SERVICE")
public interface MovieFeign {
	@GetMapping("movies/findmoviesbyactorid/{actorId}")
	public List<Movie> findMoviesByActorId(@PathVariable int actorId);
}
