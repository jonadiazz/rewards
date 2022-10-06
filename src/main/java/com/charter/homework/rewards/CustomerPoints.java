package com.charter.homework.rewards;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

// @Entity
// @Table(name = "CustomerPoints")
@Component
public class CustomerPoints implements Serializable {
    // @Id
    // private int id;
    
    // @Column(name = "monthCount")
    private int monthCount;
    // @Column(name = "customerId")
    private int customerId;
    // @Column(name = "points")
    private int points;

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public String toString() {
        return "CustomerPoints [monthCount=" + monthCount + ", customerId=" + customerId + ", points=" + points + "]" ;
    }
}