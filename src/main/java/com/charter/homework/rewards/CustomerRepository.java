package com.charter.homework.rewards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query( nativeQuery = true, value = "Select * from Customer where customerId = ?1")
    Customer findById(int customerId);
}
