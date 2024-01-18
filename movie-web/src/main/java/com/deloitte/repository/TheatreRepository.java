package com.deloitte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
