package com.roja.rewardsapi;

import com.roja.rewardsapi.service.RewardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardServiceTest {

    private final RewardService rewardService = new RewardService();

    @Test
    void shouldCalculate90PointsFor120DollarPurchase() {
        assertEquals(90, rewardService.calculatePoints(120));
    }

    @Test
    void shouldCalculate25PointsFor75DollarPurchase() {
        assertEquals(25, rewardService.calculatePoints(75));
    }

    @Test
    void shouldCalculate0PointsFor40DollarPurchase() {
        assertEquals(0, rewardService.calculatePoints(40));
    }

    @Test
    void shouldCalculate150PointsFor150DollarPurchase() {
        assertEquals(150, rewardService.calculatePoints(150));
    }
}