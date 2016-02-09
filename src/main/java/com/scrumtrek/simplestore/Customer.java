package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.decorator.Decorator;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String mName;
    private List<Rental> mRentals = new ArrayList<Rental>();
    private Decorator decorator;

    public Customer(String name, Decorator decorator) {
        mName = name;
        this.decorator = decorator;
    }

    public String getName() {
        return mName;
    }

    public void addRental(Rental arg) {
        mRentals.add(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = decorator.decorateName(mName);
        for (Rental each : mRentals) {
            for(Movie movie : each.getMovieList()) {
                double currentPrice = getCurrentMoviePrice(each, movie);
                frequentRenterPoints++;
                if ((movie.getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1)) {
                    frequentRenterPoints++;
                }
                result += decorator.decorateFilm(movie.getTitle(), currentPrice);
                totalAmount += currentPrice;
            }
        }
        result += decorator.decorateAmount(totalAmount);
        result += decorator.decoratePoint(frequentRenterPoints);
        return result;
    }

    public double getCurrentMoviePrice(Rental rental, Movie movie) {
        double currentPrice = 0;
        PriceCodes priceCode = movie.getPriceCode();
        // Determine amounts for each line
        currentPrice += priceCode.getStartPrice();
        if (rental.getDaysRented() > priceCode.getLowCostDaysCount()) {
            currentPrice += (rental.getDaysRented() - priceCode.getLowCostDaysCount()) * priceCode.getAmountPrice();
        }
        return currentPrice;
    }
}
