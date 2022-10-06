package com.charter.homework.rewards;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RewardPointsService {
    private static final int DOUBLE_POINT_CUT_OFF = 100;
    private static final int SINGLE_POINT_CUT_OFF = 50;
    private static final int MAX_AWARDABLE_SINGLE_POINT_REWARDS = 50;

    
    @Autowired
    private CustomerRepository customerRepo;
    
    public Integer calculateRewardPointsForPurchase(Integer purchasePrice) {
        /** if no purchase price given, return zero for no awards */
        if (null == purchasePrice) {
            return 0;
        }
        /** initialize rewarded points at zero */
        int doublePointsRewarded = 0;
        int singlePointsRewarded = 0;

        /** calculating awarded double points based on purchase price */
        if (purchasePrice > DOUBLE_POINT_CUT_OFF) {
            doublePointsRewarded = purchasePrice - DOUBLE_POINT_CUT_OFF;
            doublePointsRewarded = doublePointsRewarded * 2;
        }

        /** calculating awarded single points based on purchase price */
        if (purchasePrice > SINGLE_POINT_CUT_OFF) {
            singlePointsRewarded =  purchasePrice - SINGLE_POINT_CUT_OFF;
        }
        /** if purchase exceeds single points rewards, reset to maximum awardable points */
        if (singlePointsRewarded > MAX_AWARDABLE_SINGLE_POINT_REWARDS) {
            singlePointsRewarded = MAX_AWARDABLE_SINGLE_POINT_REWARDS;
        }

        return singlePointsRewarded + doublePointsRewarded;
    }

    /** customer data set */
    public Customer getCustomer(Integer customerId) {
        return null;
    }

    public Integer getCustomerRewardPointsSince(Integer customerId, String sinceDate) {
        /** base case */
        if (null == customerId) {
            return 0;
        }
        /** initialize reward points at zero */
        int totalRewardPointsSinceDate = 0;

        System.out.println("Searching for customer " + customerId);
        Optional<Customer> foundCustomer = customerRepo.findById(customerId);
        if (foundCustomer.isPresent()) {
            System.out.println("Customer found");
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
            for (Purchase purchase : foundCustomer.get().getPurchases()) {
                try {
                    if (dateFormatter.parse(purchase.getPurchaseDate()).after(dateFormatter.parse(sinceDate))) {
                        System.out.println("Purchase " + purchase.getPurchaseId() + " points: " + calculateRewardPointsForPurchase(purchase.getPurchaseAmount()));
                        totalRewardPointsSinceDate += calculateRewardPointsForPurchase(purchase.getPurchaseAmount());

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    /** I would add an informational or warning log here. */
                }
                
            }
        }

        return totalRewardPointsSinceDate;
    }
}