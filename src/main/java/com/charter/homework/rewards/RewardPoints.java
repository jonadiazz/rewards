package com.charter.homework.rewards;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        // LocalDateTime nowMinusThreeMonths = LocalDateTime.now().minusMonths(3);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        // System.out.println("Request to calculate rewards since " + formatter.format(nowMinusThreeMonths));

        // String nowMinusThree = formatter.format(nowMinusThreeMonths);
        // return rewardPointsService.getCustomerRewardPointsSince(customerId, (null != sinceDate) ? sinceDate : nowMinusThree);
    }

    // @GetMapping(value = "/charter/v1/customers/points")
    // public List<CustomerPoints> getCustomerRewardPointsLastMonth(@RequestParam(required = false) Integer customerId, @RequestParam(required = false) String sinceDate) {
        
    //     return getCustomerRewardsPerMonth(customerId);
    //     // return rewardPointsService.getCustomerRewardPointsSince(customerId, (null != sinceDate) ? sinceDate : nowMinusThree);
    // }
}
