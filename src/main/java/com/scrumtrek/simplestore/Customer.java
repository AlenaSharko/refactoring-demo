package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String m_Name;
    private List<Rental> m_Rentals = new ArrayList<Rental>();

    public Customer(String name) {
        m_Name = name;
    }

    public String getName() {
        return m_Name;
    }

    public void addRental(Rental arg) {
        m_Rentals.add(arg);
    }

    public String Statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = Report.TITLE + m_Name + "\n";

        for (Rental each : m_Rentals) {

            double currentPrice = getCurrentMoviePrice(each); // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + currentPrice + "\n";

            totalAmount += currentPrice;
        }

        // Add footer lines
        result += Report.AMOUNT_TEXT_REPORT + totalAmount + "\n";

        result += Report.EARNED_TEXT + frequentRenterPoints + Report.END_PART;

        return result;
    }

    public double getCurrentMoviePrice(Rental rental) {
        double currentPrice = 0;
        PriceCodes priceCode = rental.getMovie().getPriceCode();
        // Determine amounts for each line
        currentPrice += priceCode.getStartPrice();
        if (rental.getDaysRented() > priceCode.getLowCostDaysCount()) {
            currentPrice += (rental.getDaysRented() - priceCode.getLowCostDaysCount()) * priceCode.getAmountPrice();
        }

        return currentPrice;

    }
}
