package com.erik.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.erik.project.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
    @Query("select count(*) from Transaction where USER_USER_ID = ?1 ")
    public int transactionCountByUser(Integer userId);	

    @Query("select sum(t.currencyAmount) from Transaction t where USER_USER_ID = ?1")
    public Integer transactionSoma(Integer userId);	
}