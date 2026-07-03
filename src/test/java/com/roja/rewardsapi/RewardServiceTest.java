package com.roja.rewardsapi;

import com.roja.rewardsapi.repository.TransactionRepository;
import com.roja.rewardsapi.service.RewardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardServiceTest {

    private RewardService rewardService;

    @BeforeEach
    void setUp() {
        TransactionRepository repository = Mockito.mock(TransactionRepository.class);
        rewardService = new RewardService(repository);
    }

    @Test
    void shouldCalculate90PointsFor120DollarPurchase() {
        assertEquals(90,
                rewardService.calculatePoints(BigDecimal.valueOf(120)));
    }

    @Test
    void shouldCalculate25PointsFor75DollarPurchase() {
        assertEquals(25,
                rewardService.calculatePoints(BigDecimal.valueOf(75)));
    }

    @Test
    void shouldCalculate0PointsFor40DollarPurchase() {
        assertEquals(0,
                rewardService.calculatePoints(BigDecimal.valueOf(40)));
    }

    @Test
    void shouldCalculate150PointsFor150DollarPurchase() {
        assertEquals(150,
                rewardService.calculatePoints(BigDecimal.valueOf(150)));
    }
}