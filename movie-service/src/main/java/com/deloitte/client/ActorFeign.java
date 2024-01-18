package com.deloitte.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.dto.Actor;


@FeignClient(name = "ACTOR-SERVICE")
public interface ActorFeign {
	@GetMapping("actors/{actorId}")
	public Actor search(@PathVariable int actorId);
}