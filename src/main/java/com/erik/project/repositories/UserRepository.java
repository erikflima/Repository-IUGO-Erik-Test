package com.erik.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.erik.project.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}