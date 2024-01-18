package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.client.MovieFeign;
import com.deloitte.dto.Movie;
import com.deloitte.entity.Actor;
import com.deloitte.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	ActorService actorService;
	
	
	@Autowired
	MovieFeign movieFeign;
	
	@PostMapping("add")
	public Actor addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	
	@GetMapping("")
	public List<Actor> getAllActors(){
		return  actorService.getAllActors();
	}
	
	@GetMapping("{actorId}")
	public Actor search(@PathVariable int actorId) {
		return actorService.searchActorById(actorId);
	}
	
	@GetMapping("{actorId}/movies")
	public List<Movie> getAllMovies(@PathVariable int actorId){
		return movieFeign.findMoviesByActorId(actorId);
	}
}