package com.erik.project.dto;

public class TransactionStatsDtoResponse {

	
	private Integer userId;
	
	private Integer transactionCount;
	
	private Integer currencySum;
	
	
	public TransactionStatsDtoResponse() {
	}

	//-------------------------Getters and Setters----------------------//
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount(Integer transactionCount) {
		this.transactionCount = transactionCount;
	}


	public Integer getCurrencySum() {
		return currencySum;
	}

	public void setCurrencySum(Integer currencySum) {
		this.currencySum = currencySum;
	}

}