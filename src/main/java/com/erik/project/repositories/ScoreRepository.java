package com.erik.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.erik.project.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
	
}