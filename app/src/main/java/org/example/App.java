package org.example;

import java.util.List;

class DiscountCalculator {
    public static double apply(double total, String code, String type) {
        if (code.equals("SAVE10")) total *= 0.9;
        if (code.equals("SAVE20")) total *= 0.8;
        if (type.equals("VIP")) total *= 0.95;
        return total;
    }
}

class TaxCalculator {
    public static double addTax(double amount) {
        return amount * 1.19;
    }
}

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static double calculatePrice(List<Double> prices, List<Integer> quantities, String type, String code) {
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }
        double afterDiscount = DiscountCalculator.apply(subtotal, code, type);
        return TaxCalculator.addTax(afterDiscount);
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println ("Pricing Engine Refactored Successfully!");
    }
}