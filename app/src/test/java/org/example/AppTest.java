package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {

    // ===== DiscountCalculator Tests =====

    @Test
    void testDiscountSAVE10() {
        double result = DiscountCalculator.apply(100.0, "SAVE10", "REGULAR");
        assertEquals(90.0, result, 0.01);
    }

    @Test
    void testDiscountSAVE20() {
        double result = DiscountCalculator.apply(100.0, "SAVE20", "REGULAR");
        assertEquals(80.0, result, 0.01);
    }

    @Test
    void testDiscountVIP() {
        double result = DiscountCalculator.apply(100.0, "NONE", "VIP");
        assertEquals(95.0, result, 0.01);
    }

    @Test
    void testNoDiscount() {
        double result = DiscountCalculator.apply(100.0, "NONE", "REGULAR");
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testDiscountVIP_SAVE10() {
        double result = DiscountCalculator.apply(100.0, "SAVE10", "VIP");
        assertEquals(85.5, result, 0.01);
    }

    // ===== TaxCalculator Tests =====

    @Test
    void testAddTax() {
        double result = TaxCalculator.addTax(100.0);
        assertEquals(119.0, result, 0.01);
    }

    @Test
    void testAddTaxZero() {
        double result = TaxCalculator.addTax(0.0);
        assertEquals(0.0, result, 0.01);
    }

    // ===== App Tests =====

    @Test
    void testGetGreeting() {
        App app = new App();
        assertEquals("Hello World!", app.getGreeting());
    }

    @Test
    void testCalculatePriceRegular() {
        List<Double> prices = List.of(10.0, 20.0);
        List<Integer> quantities = List.of(2, 1);
        double result = App.calculatePrice(prices, quantities, "REGULAR", "NONE");
        assertEquals(47.6, result, 0.01);
    }

    @Test
    void testCalculatePriceSAVE20() {
        List<Double> prices = List.of(50.0);
        List<Integer> quantities = List.of(2);
        double result = App.calculatePrice(prices, quantities, "REGULAR", "SAVE20");
        assertEquals(95.2, result, 0.01);
    }

    @Test
    void testCalculatePriceVIP_SAVE10() {
        List<Double> prices = List.of(100.0);
        List<Integer> quantities = List.of(1);
        double result = App.calculatePrice(prices, quantities, "VIP", "SAVE10");
        assertEquals(101.745, result, 0.01);
    }
}