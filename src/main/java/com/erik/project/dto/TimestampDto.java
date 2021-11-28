package com.erik.project.dto;
import java.sql.Timestamp;

public class TimestampDto {

	private Timestamp timestamp;
	
	public TimestampDto( Timestamp timestamp ) {
		
		this.timestamp = timestamp;
	}

	//-------------------------Getters and Setters----------------------//
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}