# rewards

Start application from entry point method com.charter.homework.rewards.RewardsApplication.main

Application provides the following endpoints
## To return a specific customer's points
- http://localhost:8080/charter/v1/customer/points?customerId=?
  where ? is the customer id number, e.g. customerId=1
## To calculate awarded points per purchase
- http://localhost:8080/charter/v1/purchase/points?purchasePrice=?
  where ? is the purchase price, e.g. purchasePrice=150
## [TODO: Calculate the reward points earned for each customer per month and total]
