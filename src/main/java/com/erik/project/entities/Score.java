package com.erik.project.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score implements Serializable {
	
	private static final long serialVersionUID = 6L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer leaderboardId;	

	private Integer score;	

	private Integer rank;	
	
	private Integer highestScoreEverMade;
	
	//uni-directional many-to-one association to User
	@ManyToOne (fetch=FetchType.EAGER)
	private User user;


	public Score() {
	}


	//-------Getters and Setters-------//

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


	public Integer getHighestScoreEverMade() {
		return highestScoreEverMade;
	}

	public void setHighestScoreEverMade(Integer highestScoreEverMade) {
		this.highestScoreEverMade = highestScoreEverMade;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}