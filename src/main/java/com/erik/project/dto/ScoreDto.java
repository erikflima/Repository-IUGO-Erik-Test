package com.erik.project.dto;

import javax.validation.constraints.Positive;

public class ScoreDto {

	@Positive  (message = "The field 'userId' must be positive value.")
	private Integer userId;	
	
	@Positive  (message = "The field 'userId' must be positive value.")
	private Integer leaderboardId;
	
	@Positive  (message = "The field 'userId' must be positive value.")
	private Integer score;
	
	
	public ScoreDto() {
	}

	//-------------------------Getters and Setters----------------------//
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getLeaderboardId() {
		return leaderboardId;
	}

	public void setLeaderboardId(Integer leaderboardId) {
		this.leaderboardId = leaderboardId;
	}


	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}