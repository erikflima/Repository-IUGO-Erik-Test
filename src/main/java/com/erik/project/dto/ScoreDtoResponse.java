package com.erik.project.dto;

public class ScoreDtoResponse {

	private Integer userId;	
	
	private Integer leaderboardId;	

	private Integer score;	

	private Integer rank;	
	
	
	public ScoreDtoResponse() {
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


	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}