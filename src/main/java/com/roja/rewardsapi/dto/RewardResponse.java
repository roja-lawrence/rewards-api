package com.roja.rewardsapi.dto;

import java.util.Map;

public class RewardResponse {

    private Long customerId;
    private Map<String, Integer> monthlyRewards;
    private Integer totalRewards;

    public RewardResponse() {
    }

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

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(Map<String, Integer> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    public Integer getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(Integer totalRewards) {
        this.totalRewards = totalRewards;
    }
}