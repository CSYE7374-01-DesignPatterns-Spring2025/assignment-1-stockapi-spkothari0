package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private static StockMarket instance;
    private Map<String, Stock> stocks;

    private StockMarket() {
        stocks = new HashMap<String, Stock>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getName(), stock);
    }

    public void removeStock(String name) {
        stocks.remove(name);
    }

    public void tradeStock(String name, String bid) {
        Stock stock = stocks.get(name);
        if (stock != null) {
            stock.setBid(bid);
        } else {
            System.out.println("Stock not found.");
        }
    }

    public void showAllStocks() {
        stocks.values().forEach(System.out::println);
    }

    public static void demo(){
        System.out.println("<------------------------Bidding Start------------------------>");
        StockMarket stockMarket= StockMarket.getInstance();
        Stock techStock = new TechStock("HCL", 100, "The HCL stock for in the " +
                "world of Technology");
        stockMarket.addStock(techStock);
        stockMarket.tradeStock("HCL", "120");
        stockMarket.tradeStock("HCL", "125");
        stockMarket.tradeStock("HCL", "135");
        stockMarket.tradeStock("HCL", "115");
        stockMarket.tradeStock("HCL", "90");
        stockMarket.tradeStock("HCL", "84");

        System.out.println(techStock.getMetric());
        System.out.println();


        Stock uber = new Uber("Uber", 131.15, "Uber Stock");
        stockMarket.addStock(uber);
        stockMarket.tradeStock("Uber", "130");
        stockMarket.tradeStock("Uber", "140");
        stockMarket.tradeStock("Uber", "150");
        stockMarket.tradeStock("Uber", "160");
        stockMarket.tradeStock("Uber", "170");
        stockMarket.tradeStock("Uber", "180");

        System.out.println(uber.getMetric());
        System.out.println();

        System.out.println("<------------------------Bidding End------------------------>");

        stockMarket.showAllStocks();

    }
}