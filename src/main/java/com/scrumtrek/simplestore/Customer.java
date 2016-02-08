package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //todo непонятное обозначенние переменных m?
    private String customerName;
    private List<Rental> customerRentals = new ArrayList<Rental>();

    public Customer(String name) {
        customerName = name;
    }

    public String getName() {
        return customerName;
    }

    public void addRental(Rental arg) {
        customerRentals.add(arg);
    }

    //todo приоритет "2", statment
    public String Statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + customerName + "\n";

        for (Rental each : customerRentals) {
            double thisAmount = each.getAmount();
            frequentRenterPoints = each.getUpdatedFreqPoints(frequentRenterPoints);
            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // Add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }
}

