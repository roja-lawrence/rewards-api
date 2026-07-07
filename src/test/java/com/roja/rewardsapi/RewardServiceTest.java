package com.roja.rewardsapi;

import com.roja.rewardsapi.dto.RewardResponse;
import com.roja.rewardsapi.entity.Transaction;
import com.roja.rewardsapi.repository.TransactionRepository;
import com.roja.rewardsapi.service.RewardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.slf4j.MDC.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    void testCalculateRewards_SingleTransaction() {

        Transaction transaction = new Transaction();
        transaction.setCustomerId(1);
        transaction.setAmount(120);
        transaction.setTransactionDate(LocalDate.of(2026, 1, 15));

        List<Transaction> transactions = List.of(transaction);

        RewardResponse response = rewardService.calculateRewards(transactions);

        assertNotNull(response);
        assertEquals(90, response.getTotalRewards());
    }

    @WebMvcTest(RewardController.class)
    class RewardControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private RewardService rewardService;

        @Test
        void testGetRewards() throws Exception {

            when(rewardService.calculateRewards(any()))
                    .thenReturn(new HashMap<>());

            mockMvc.perform(get("/api/rewards"))
                    .andExpect(status().isOk());
        }
    }
}