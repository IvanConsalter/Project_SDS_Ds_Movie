package com.ivanconsalter.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivanconsalter.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
