package com.ivanconsalter.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivanconsalter.dsmovie.entities.Score;
import com.ivanconsalter.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
