package com.charter.homework.rewards;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

    public Integer getCustomerRewardPointsSince(Integer customerId, String sinceDate, String tilDate) {
        /** base case */
        if (null == customerId) {
            return 0;
        }
        /** initialize reward points at zero */
        int totalRewardPointsSinceDate = 0;
        // int totalRewardPointsSecondToLastMonth = 0;
        // int totalRewardPointsThirdToLastMonth = 0;

        System.out.println("Searching for customer " + customerId);
        Optional<Customer> foundCustomer = customerRepo.findById(customerId);
        if (foundCustomer.isPresent()) {
            System.out.println("Customer found");
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
            for (Purchase purchase : foundCustomer.get().getPurchases()) {
                try {
                    if (dateFormatter.parse(purchase.getPurchaseDate()).after(dateFormatter.parse(sinceDate)) &&
                        dateFormatter.parse(purchase.getPurchaseDate()).before(dateFormatter.parse(tilDate))) {
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

    public List<CustomerPoints> getCustomerRewardsPerMonth(Integer customerId) {
        /** This date formatter section can be extracted into a method */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        LocalDateTime nowMinusThreeMonths = LocalDateTime.now().minusMonths(3);
        LocalDateTime nowMinusTwoMonths = LocalDateTime.now().minusMonths(2);
        LocalDateTime nowMinusOneMonths = LocalDateTime.now().minusMonths(1);
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println("Request to calculate rewards since " + formatter.format(nowMinusThreeMonths));

        String nowMinusThree = formatter.format(nowMinusThreeMonths);
        String nowMinusTwo = formatter.format(nowMinusTwoMonths);
        String nowMinusOne = formatter.format(nowMinusOneMonths);
        String nowMinusZero = formatter.format(now);

        Integer pointsLastMonth = getCustomerRewardPointsSince(customerId, nowMinusOne, nowMinusZero);
        CustomerPoints customerPointsLastMonth = new CustomerPoints();
        customerPointsLastMonth.setCustomerId(customerId);
        customerPointsLastMonth.setMonthCount(1);
        customerPointsLastMonth.setPoints(pointsLastMonth);

        Integer pointsSecondToLastMonth = getCustomerRewardPointsSince(customerId, nowMinusTwo, nowMinusOne);
        CustomerPoints customerPointsSecondToLastMonth = new CustomerPoints();
        customerPointsSecondToLastMonth.setCustomerId(customerId);
        customerPointsSecondToLastMonth.setMonthCount(2);
        customerPointsSecondToLastMonth.setPoints(pointsSecondToLastMonth);
        
        Integer pointsThirdToLastMonth = getCustomerRewardPointsSince(customerId, nowMinusThree, nowMinusTwo);

        System.out.println("Points last month " + pointsLastMonth);
        System.out.println("Points second to last month " + pointsSecondToLastMonth);
        System.out.println("Points third to last month " + pointsThirdToLastMonth);

        CustomerPoints customerPointsThirdToLastMonth = new CustomerPoints();
        customerPointsThirdToLastMonth.setCustomerId(customerId);
        customerPointsThirdToLastMonth.setMonthCount(3);
        customerPointsThirdToLastMonth.setPoints(pointsThirdToLastMonth);

        /** All months */
        CustomerPoints customerPointsAll = new CustomerPoints();
        customerPointsAll.setCustomerId(customerId);
        customerPointsAll.setMonthCount(0);
        customerPointsAll.setPoints(pointsLastMonth + pointsSecondToLastMonth + pointsThirdToLastMonth);
        
        List<CustomerPoints> customerPointsPerMonth = new ArrayList<>();
        customerPointsPerMonth.add(customerPointsThirdToLastMonth);
        customerPointsPerMonth.add(customerPointsSecondToLastMonth);
        customerPointsPerMonth.add(customerPointsLastMonth);
        customerPointsPerMonth.add(customerPointsAll);

        return customerPointsPerMonth;
    }
}