package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.decorator.Decorator;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String mName;

    public Customer() {
        super();
    }

    private List<Rental> mRentals = new ArrayList<Rental>();

    public Customer(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void addRental(Rental arg) {
        mRentals.add(arg);
    }

    public double getTotalAmount() {
        double totalAmount = 0;

        for (Rental each : mRentals) {
            for(Movie movie : each.getMovieList()) {
                double currentPrice = getCurrentMoviePrice(each, movie);

                totalAmount += currentPrice;
            }
        }

        return totalAmount;
    }

    public double getCurrentMoviePrice(Rental rental, Movie movie) {
        double currentPrice = 0;
        PriceCodes priceCode = movie.getPriceCode();
        currentPrice += priceCode.getStartPrice();
        if (rental.getDaysRented() > priceCode.getLowCostDaysCount()) {
            currentPrice += (rental.getDaysRented() - priceCode.getLowCostDaysCount()) * priceCode.getAmountPrice();
        }
        return currentPrice;
    }

    public List<Rental> getmRentals() {
        return mRentals;
    }
}
