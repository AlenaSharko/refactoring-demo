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

    public static final int REGULAR_BONUS = 2;
    public static final int REGULAR_DAYS = 2;
    public static final int NEW_RELEASE_BONUS = 3;
    public static final double CHILDREN_BONUS = 1.5;
    public static final int CHILDREN_DAYS = 3;
    public static final double REGULAR_ADD = 1.5;
    public static final double CHILDREN_ADD = 1.5;



    public void addRental(Rental arg) {
        customerRentals.add(arg);
    }

    //todo приоритет "2", statment
    public String Statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + customerName + "\n";

        for (Rental each : customerRentals) {
            double thisAmount = 0;
            //todo подсчет thisAmount вынести в отдельный метод
            // Determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Regular:
                    thisAmount += REGULAR_BONUS;
                    if (each.getDaysRented() > REGULAR_DAYS) {
                        thisAmount += (each.getDaysRented() - REGULAR_DAYS) * REGULAR_ADD;
                    }
                    break;

                case NewRelease:
                    thisAmount += each.getDaysRented() * NEW_RELEASE_BONUS;
                    break;

                case Childrens:
                    thisAmount += CHILDREN_BONUS;
                    if (each.getDaysRented() > CHILDREN_DAYS) {
                        thisAmount = (each.getDaysRented() - CHILDREN_DAYS) * CHILDREN_ADD;
                    }
                    break;
            }
            //todo подсчет frequentRenterPoints в отдельный метод
            // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

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

