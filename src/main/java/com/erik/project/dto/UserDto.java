package com.erik.project.dto;
import javax.validation.constraints.Positive;

public class UserDto {
	
	
	@Positive  (message = "The field 'userId' must be positive value.")
	private Integer userId;

	
	public UserDto() {
	}

	//-------------------------Getters and Setters----------------------//
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}