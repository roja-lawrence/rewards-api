package com.roja.rewardsapi.service;
import com.roja.rewardsapi.entity.Transaction;
import com.roja.rewardsapi.dto.RewardResponse;
//import com.roja.rewardsapi.service.Transaction;
import com.roja.rewardsapi.exception.CustomerNotFoundException;
import com.roja.rewardsapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class RewardService {

    private final TransactionRepository transactionRepository;

    public RewardResponse calculateRewards(Long customerId) {

        long months = 0;
        if (months <= 0) {
            throw new IllegalArgumentException("Months must be greater than zero");
        }

        LocalDate fromDate = LocalDate.now().minusMonths(months);

        List<Transaction> transactions =
                transactionRepository.findByCustomerIdAndTransactionDateAfter(
                        customerId, fromDate);

        if (transactions.isEmpty()) {
            throw new CustomerNotFoundException(
                    "No transactions found for customer " + customerId);
        }

        log.info("Calculating rewards for customer {}", customerId);

        Map<String, Integer> monthlyRewards = new HashMap<>();
        int totalRewards = 0;

        for (Transaction transaction : transactions) {

            int points = calculatePoints(transaction.getAmount());

            String month = transaction.getTransactionDate()
                    .getMonth()
                    .name();

            monthlyRewards.put(
                    month,
                    monthlyRewards.getOrDefault(month, 0) + points);

            totalRewards += points;
        }

        RewardResponse response = new RewardResponse();
        response.setCustomerId(customerId);
        response.setMonthlyRewards(monthlyRewards);
        response.setTotalRewards(totalRewards);

        return response;
    }

    public int calculatePoints(BigDecimal amount) {

        int points = 0;

        if (amount.compareTo(BigDecimal.valueOf(100)) > 0) {
            points += amount.subtract(BigDecimal.valueOf(100)).intValue() * 2;
            points += 50;
        } else if (amount.compareTo(BigDecimal.valueOf(50)) > 0) {
            points += amount.subtract(BigDecimal.valueOf(50)).intValue();
        }

        return points;
    }
}