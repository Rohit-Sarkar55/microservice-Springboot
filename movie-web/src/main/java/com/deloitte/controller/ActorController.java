package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.entity.Actor;
import com.deloitte.repository.ActorRepository;
import com.deloitte.service.ActorService;

@Controller
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	ActorService actorService;
	
	@RequestMapping("")
	public ModelAndView all() {
		System.out.println("All");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewactors");
		List<Actor> list = actorService.getAllActors();
		System.out.println(list);
		mv.addObject("actors",list );
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView createOrUpdate(Actor actor) {
		System.out.println("Create / Update");
		ModelAndView mv = new ModelAndView();
		Actor a = actorService.addActor(actor);
		
		System.out.println(a);
		return all();
	}
	@RequestMapping("{actorId}/update")
	public ModelAndView update(@PathVariable  int actorId) {
		System.out.println("Update");
		Actor a = actorService.searchActorById(actorId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editActor");
		mv.addObject("actor", a);
		return mv;
		
		
		
		
	}
	public ModelAndView home() {
		System.out.println("home");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("msg", "welcome to my website");
		return mv;
	}
	
	
}