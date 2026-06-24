package com.roja.rewardsapi.entity;

import java.time.LocalDate;

public class Transaction {

    private Long transactionId;
    private Long customerId;
    private Double amount;
    private LocalDate transactionDate;

    public Transaction(Long transactionId, Long customerId,
                       Double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}