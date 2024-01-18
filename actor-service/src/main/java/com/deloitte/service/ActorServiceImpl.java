package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Actor;
import com.deloitte.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorRepository repository;
	@Override
	public Actor addActor(Actor actor) {
		// TODO Auto-generated method stub
		return repository.save(actor);
	}

	@Override
	public Actor searchActorById(int actorId) {
		// TODO Auto-generated method stub
		return repository.findById(actorId).orElse(null);
	}

	@Override
	public List<Actor> getAllActors() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
