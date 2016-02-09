package com.scrumtrek.simplestore;


import com.scrumtrek.simplestore.codes.NewReleasePriceCode;


public class Rental {
    private Movie movieName;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        movieName = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movieName;
    }

    public double getAmount() {
        double thisAmount = 0.0;
        thisAmount = getMovie().getPriceCode().getAmount(thisAmount, daysRented);
        return thisAmount;
    }

    public int getUpdatedFreqPoints() {
        // Add bonus for a two-day new-release rental
        if ((getMovie().getPriceCode().getName().equals(NewReleasePriceCode.NEW_RELEASE_PRICE_CODE_NAME) &&
                (getDaysRented() > 1))) {
            return 2;
        }
        return 1;
    }
}

