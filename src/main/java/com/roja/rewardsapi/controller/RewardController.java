package com.roja.rewardsapi.controller;

import com.roja.rewardsapi.dto.RewardResponse;
import com.roja.rewardsapi.service.RewardService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rewards")
@Validated
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{customerId}")
    public RewardResponse getRewards(
            @PathVariable @Positive Long customerId,
            @RequestParam(defaultValue = "3")
            @Min(1)
            @Max(12)
            int months) {

        return rewardService.calculateRewards(customerId);
    }
}