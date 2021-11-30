package com.erik.project.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.project.entities.Score;
import com.erik.project.repositories.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	
	public ScoreService() {
	}

	//--------------------------------------------------//
	
	public void save( Score score) {

		scoreRepository.save( score );
	}


	public Score findById( Integer leaderboardId) {

		Optional<Score> scoreOpt = scoreRepository.findById( leaderboardId );
		
		if( scoreOpt.isPresent() ){
			
			Score score = scoreOpt.get();
			
			return score;
		}
		
		return null;
		
	}
	
}