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
@Table(name = "transaction")
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;

	private Integer currencyAmount;
	
	private String verifier;
	
	//uni-directional many-to-one association to User
	@ManyToOne (fetch=FetchType.EAGER)
	private User user;


	public Transaction() {
	}
	
	public Transaction( Integer currencyAmount, String verifier, User user  ) {

		this.currencyAmount = currencyAmount;
		this.verifier = verifier;
		this.user = user;
	}


	//-------Getters and Setters-------//


	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}