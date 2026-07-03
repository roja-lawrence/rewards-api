package com.roja.rewardsapi.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    private Long transactionId;

    private Long customerId;

    @Column(nullable = false)
    private BigDecimal amount;

    private LocalDate transactionDate;

    public Transaction() {}

    public Transaction(Long transactionId,
                       Long customerId,
                       BigDecimal amount,
                       LocalDate transactionDate) {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}