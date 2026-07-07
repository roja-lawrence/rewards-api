package com.roja.rewardsapi.repository;

import com.roja.rewardsapi.entity.Transaction;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCustomerIdAndTransactionDateAfter(
            @Positive Long customerId,
            LocalDate transactionDate);
}