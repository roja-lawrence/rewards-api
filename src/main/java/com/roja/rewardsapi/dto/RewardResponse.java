package com.roja.rewardsapi.dto;

import java.util.Map;

public class RewardResponse {

    private Long customerId;
    private Map<String, Integer> monthlyRewards;
    private Integer totalRewards;
    private String customerName;
    private String email;
    private int totalTransactions;
    private double totalAmountSpent;

    public RewardResponse(Long customerId,
                          Map<String, Integer> monthlyRewards,
                          Integer totalRewards) {
        this.customerId = customerId;
        this.monthlyRewards = monthlyRewards;
        this.totalRewards = totalRewards;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Map<String, Integer> getMonthlyRewards() {
        return monthlyRewards;
    }

    public Integer getTotalRewards() {
        return totalRewards;
    }
}