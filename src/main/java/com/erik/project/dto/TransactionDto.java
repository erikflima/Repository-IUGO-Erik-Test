package com.erik.project.dto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class TransactionDto {
	
	@Positive  (message = "The field 'transactionId' must be positive value.")
	private Integer transactionId;
	
	@Positive  (message = "The field 'userId' must be positive value.")
	private Integer userId;

	@Positive  (message = "The field 'currencyAmount' must be positive value.")
	private Integer currencyAmount;	
	
	@NotEmpty(message = "The field 'verifier' cannot be empty.")
	@Length(min = 1, max = 200, message = "Name must contain between 3 and 200 characters")
	private String verifier;	
	
	
	TransactionDto(){
	}

	
	//-------------------------Getters and Setters----------------------//
	
	
	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getCurrencyAmount() {
		return currencyAmount;
	}


	public void setCurrencyAmount(Integer currencyAmount) {
		this.currencyAmount = currencyAmount;
	}


	public String getVerifier() {
		return verifier;
	}


	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

}