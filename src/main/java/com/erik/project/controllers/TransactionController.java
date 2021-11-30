package com.erik.project.controllers;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.project.dto.TransactionDto;
import com.erik.project.dto.TransactionDtoResponse;
import com.erik.project.dto.TransactionStatsDtoResponse;
import com.erik.project.dto.UserDto;
import com.erik.project.entities.Transaction;
import com.erik.project.entities.User;
import com.erik.project.response.StandardizedResponse;
import com.erik.project.service.TransactionService;
import com.erik.project.service.UserService;


@RestController
@RequestMapping(value="/api/test-iugo/transaction", produces="application/json")
@CrossOrigin(origins = "*")
public class TransactionController {

	@Autowired
	UserService userService;
	
	@Autowired
	TransactionService transactionService;
	
	
	private static final Logger log = LoggerFactory.getLogger( TransactionController.class );


	public TransactionController() {
	}


	@PostMapping 
	public ResponseEntity< StandardizedResponse<TransactionDtoResponse> > transactionRecording( @Valid @RequestBody TransactionDto transactionDto,
			                                                                                                        BindingResult  bindingResult ) throws NoSuchAlgorithmException {
		
		log.info("\nEndpoint: /api/test-iugo/transaction");

		StandardizedResponse<TransactionDtoResponse> standardizedResponse = new StandardizedResponse<TransactionDtoResponse>();

		//--
				
		//Checking the validation of input data made automatically by Hibernate, based on the annotations made in the class.
		if ( bindingResult.hasErrors() ) {
			
			List<ObjectError> errorlist = bindingResult.getAllErrors();
			
			
			for( ObjectError auxiliary : errorlist  ){
				
				String extractedErrormessage = auxiliary.getDefaultMessage();
						
				standardizedResponse.getErrors().add(extractedErrormessage);
			}

			return ResponseEntity.badRequest().body( standardizedResponse );
		}	

		//--
		
		//I check if the user I received exists in the database.
		User user = userService.findById( transactionDto.getUserId() );
		if(user == null){

			standardizedResponse.getErrors().add("The user informed does not exist.");
			
			return ResponseEntity.badRequest().body( standardizedResponse );			
		}
		
		//--
		
		//TODO - Ask about "Secret key and about verifier.
		
		//--
		
		Transaction transaction = convertTransactionDtoToTransaction( transactionDto, user );
		
		transactionService.saveTransaction( transaction );
		
		//--
		
		TransactionDtoResponse transactionDtoResponse = new TransactionDtoResponse();
		transactionDtoResponse.setSuccess(true);
		
		//-
		
		standardizedResponse.setResponseContent( transactionDtoResponse );
		
		return ResponseEntity.ok().body( standardizedResponse );
	}

	
	@PostMapping("/transactionStats")
	public ResponseEntity< StandardizedResponse<TransactionStatsDtoResponse> > transactionDataQuerying( @Valid @RequestBody UserDto        userDto,
			                                                                                                                BindingResult  bindingResult ) throws NoSuchAlgorithmException {
		
		log.info("\nEndpoint: /api/test-iugo/transaction/transactionStats");

		StandardizedResponse<TransactionStatsDtoResponse> standardizedResponse = new StandardizedResponse<TransactionStatsDtoResponse>();
		TransactionStatsDtoResponse transactionStatsDto = new TransactionStatsDtoResponse();

		//--
		
		//Checking the validation of input data made automatically by Hibernate, based on the annotations made in the class.
		if ( bindingResult.hasErrors() ) {
			
			List<ObjectError> errorlist = bindingResult.getAllErrors();
			
			
			for( ObjectError auxiliary : errorlist  ){
				
				String extractedErrormessage = auxiliary.getDefaultMessage();
						
				standardizedResponse.getErrors().add(extractedErrormessage);
			}

			return ResponseEntity.badRequest().body( standardizedResponse );
		}	

		//--
		
		//I check if the user I received exists in the database.
		User user = userService.findById( userDto.getUserId() );
		if(user == null){

			standardizedResponse.getErrors().add("The user informed does not exist.");
			
			return ResponseEntity.badRequest().body( standardizedResponse );			
		}
		
		//--		

		Integer totalOfTransactions    = transactionService.transactionCountByUser( userDto.getUserId() );
		Integer totalSumOfTransactions = transactionService.transactionSumByUser( userDto.getUserId() );
		
		//--
		
		transactionStatsDto.setTransactionCount( totalOfTransactions );
		transactionStatsDto.setCurrencySum( totalSumOfTransactions );
		transactionStatsDto.setUserId( userDto.getUserId() );
		
		//--

		standardizedResponse.setResponseContent( transactionStatsDto );
		
		return ResponseEntity.ok().body( standardizedResponse );
	}

	
	//------------------------------------------------------------//


	private Transaction convertTransactionDtoToTransaction( TransactionDto transactionDto, User user ) {

		Transaction transaction = new Transaction();
		
		transaction.setTransactionId( transactionDto.getUserId() );
		transaction.setCurrencyAmount( transactionDto.getCurrencyAmount() );
		transaction.setVerifier( transactionDto.getVerifier() );
		transaction.setUser(user);
		
		return transaction;
		
		
	}
	
}