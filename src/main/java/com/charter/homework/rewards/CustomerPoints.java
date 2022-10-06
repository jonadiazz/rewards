package com.charter.homework.rewards;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component
public class CustomerPoints implements Serializable {
    private int monthCount;
    private int customerId;
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