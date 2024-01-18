package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Actor;

public interface ActorService {
	Actor addActor(Actor actor);
	Actor searchActorById(int actorId);
	List<Actor> getAllActors();
}
