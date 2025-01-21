package edu.neu.csye7374;

import java.util.Collections;

public class Uber extends Stock {
    public Uber(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setBid(String bid) {
        int bidValue= Integer.parseInt(bid);
        bidList.add(bidValue);
        setPrice(bidValue);
        System.out.println("The price for " + this.getName() + " is now " + bidValue);
    }

    @Override
    public String getMetric() {
        int maxBid = Collections.max(bidList);
        int firstBid = bidList.get(0);
        double performanceMetric = (double) (maxBid - firstBid) / maxBid * 100;
        return String.format("The Metric for %s: %%Change in Bid for the past %d records is: %.2f%%",
                this.getName(), bidList.size(), performanceMetric);
    }

    @Override
    public String toString() {
        return "------------Stock Name: " + this.getName() + "------------" + "\n" +
                "Price: " + this.getPrice() + "\n" +
                "Description: " + this.getDescription() + "\n" +
                "Final Bid: " + bidList.get(bidList.size()-1) + "\n" +
                getMetric();
    }
}