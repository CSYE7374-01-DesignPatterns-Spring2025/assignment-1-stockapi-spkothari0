package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

abstract class Stock implements Tradable {
    private String name;
    private double price;
    private String description;
    protected List<Integer> bidList;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        bidList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
}
