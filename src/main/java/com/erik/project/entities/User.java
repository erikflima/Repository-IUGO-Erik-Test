package com.erik.project.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;	

	private String name;
	
	
	public User() {
	}
	
	public User( String name ) {
		this.name = name;
	}

	//-------Getters and Setters-------//
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}