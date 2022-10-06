package com.charter.homework.rewards;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customerId")
    private Integer id;
    @Column(name = "customerUniqueName")
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //normally use fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}