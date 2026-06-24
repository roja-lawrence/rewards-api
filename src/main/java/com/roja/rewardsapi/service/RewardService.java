package com.roja.rewardsapi.service;

import com.roja.rewardsapi.dto.RewardResponse;
import com.roja.rewardsapi.entity.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;

import java.time.Month;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

public class RewardService {

    public RewardResponse calculateRewards(Long customerId, int months)  {

        List<Transaction> transactions = List.of(
                new Transaction(1L, 101L, 120.0,
                        java.time.LocalDate.of(2026, 1, 10)),
                new Transaction(2L, 101L, 75.0,
                        java.time.LocalDate.of(2026, 2, 15)),
                new Transaction(3L, 101L, 200.0,
                        java.time.LocalDate.of(2026, 3, 20))
        );

        Map<String, Integer> monthlyRewards = new HashMap<>();

        int total = 0;

        for (Transaction transaction : transactions) {

            int points = calculatePoints(transaction.getAmount());

            String month =
                    Month.from(transaction.getTransactionDate()).name();

            monthlyRewards.put(
                    month,
                    monthlyRewards.getOrDefault(month, 0) + points
            );

            total += points;
        }

        return new RewardResponse(
                customerId,
                monthlyRewards,
                total
        );
    }

    public int calculatePoints(double amount) {

        int points = 0;

        if (amount > 100) {
            points += (int) ((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }

        return points;

    }
    @Async
    public CompletableFuture<List<Transaction>> fetchTransactions() {

        return CompletableFuture.completedFuture(
                List.of(
                        new Transaction(1L,101L,120.0,
                                LocalDate.of(2026,1,10))
                )
        );
    }


    private static final Logger logger =
            LoggerFactory.getLogger(RewardService.class);
}