package com.charter.homework.rewards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardPoints {

    @Autowired
    RewardPointsService rewardPointsService;

    @GetMapping(value = "/charter/v1/purchase/points")
    public Integer getPurchaseRewardPoints(@RequestParam(required = false) Integer purchasePrice) {
        return rewardPointsService.calculateRewardPointsForPurchase(purchasePrice);
    }

    @GetMapping(value = "/charter/v1/customer/points")
    public List<CustomerPoints> getCustomerRewardPoints(@RequestParam(required = false) Integer customerId, @RequestParam(required = false) String sinceDate) {
        return rewardPointsService.getCustomerRewardsPerMonth(customerId);
    }
}
