package com.company;

import java.util.Collections;
import java.util.Comparator;

public class Museum {
    private String name;
    private String purpose;
    private String address;
    private String workTime;
    private double price;

    public String getName() {
        return name;
    }

    // constructor
    public Museum(String name, String purpose, String address, String workTime, double price) {
        setName(name);
        setPurpose(purpose);
        setAddress(address);
        setWorkTime(workTime);
        setPrice(price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", purpose='" + purpose + '\'' +
                ", address='" + address + '\'' +
                ", workTime='" + workTime + '\'' +
                ", price=" + price +
                '}';
    }
}
