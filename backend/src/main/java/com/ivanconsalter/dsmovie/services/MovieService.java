package com.ivanconsalter.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivanconsalter.dsmovie.dto.MovieDTO;
import com.ivanconsalter.dsmovie.entities.Movie;
import com.ivanconsalter.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDTO> page = result.map(movie -> new MovieDTO(movie));
		
		return page; 
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie movie = movieRepository.findById(id).get();
		MovieDTO movieDTO = new MovieDTO(movie);
		
		return movieDTO;
	}

}
