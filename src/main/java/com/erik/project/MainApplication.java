package com.erik.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erik.project.entities.Transaction;
import com.erik.project.entities.User;
import com.erik.project.service.TransactionService;
import com.erik.project.service.UserService;

@SpringBootApplication
public class MainApplication {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionService transactionService;
	
	
	public static void main(String[] args) {
			
		SpringApplication.run(MainApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(){
			
		return args -> {

			//Add some users in the data base.
			User user1 = new User("Erik");
			user1.setUserId(1);

			User user2 = new User("Mario");
			user2.setUserId(2);	
			
			User user3 = new User("Luigi");
			user3.setUserId(3);

			userService.saveItem(user1);
			userService.saveItem(user2);
			userService.saveItem(user3);

			//--
			
			//Add some transactions in the data base.
			Transaction transaction1 = new Transaction(100, "example1", user1);
			transaction1.setTransactionId(1);
			
			Transaction transaction2 = new Transaction(200, "example2", user1);
			transaction1.setTransactionId(2);
			
			Transaction transaction3 = new Transaction(300, "example3", user1);
			transaction1.setTransactionId(3);			

			transactionService.saveTransaction(transaction1);
			transactionService.saveTransaction(transaction2);
			transactionService.saveTransaction(transaction3);

		};
	}

}