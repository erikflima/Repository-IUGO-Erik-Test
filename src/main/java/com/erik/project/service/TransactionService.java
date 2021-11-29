package com.erik.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.project.entities.Transaction;
import com.erik.project.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	
	public TransactionService() {
	}

	//--------------------------------------------------//
	
	public void saveTransaction( Transaction transaction) {

		transactionRepository.save( transaction );
	}


	public int transactionCountByUser(Integer userId) {
		
		int totalOfTransactions = transactionRepository.transactionCountByUser(userId);
		
		return totalOfTransactions;
	}
	
	
	public Integer transactionSumByUser(Integer userId) {
		
		Integer totalSumOfTransactions = transactionRepository.transactionSoma(userId);
		
		if( totalSumOfTransactions == null ){
			
			return 0;
		}
		
		return totalSumOfTransactions;
	}
	
}