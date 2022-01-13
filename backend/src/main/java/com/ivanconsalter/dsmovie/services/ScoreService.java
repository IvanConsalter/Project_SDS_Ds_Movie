package com.ivanconsalter.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivanconsalter.dsmovie.dto.MovieDTO;
import com.ivanconsalter.dsmovie.dto.ScoreDTO;
import com.ivanconsalter.dsmovie.entities.Movie;
import com.ivanconsalter.dsmovie.entities.Score;
import com.ivanconsalter.dsmovie.entities.User;
import com.ivanconsalter.dsmovie.repositories.MovieRepository;
import com.ivanconsalter.dsmovie.repositories.ScoreRepository;
import com.ivanconsalter.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
