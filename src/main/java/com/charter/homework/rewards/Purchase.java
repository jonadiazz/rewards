package com.charter.homework.rewards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @Column(name = "purchaseId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;    
    /** Depends on database date format, we would create a Date object with proper parsing */
    @Column(name = "purchaseDate")
    private String date;
    @Column(name = "amount")
    private Integer amount;

    public Integer getPurchaseId() {
        return id;
    }

    public String getPurchaseDate() {
        return date;
    }

    public Integer getPurchaseAmount() {
        return amount;
    }
}