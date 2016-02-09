package com.scrumtrek.simplestore.reporet;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.Rental;
import com.scrumtrek.simplestore.decorator.Decorator;

import java.util.List;

public class Reporter {
    public String getReport(Customer customer, Decorator decorator, boolean header, boolean rental, boolean footer) {
        String result = "";
        if(header) {
            result += decorator.decorateName(customer.getName());
        }
        if(rental) {
            List<Rental> rentalList = customer.getmRentals();
            for (Rental each : rentalList) {
                for(Movie movie : each.getMovieList()) {
                    double currentPrice = customer.getCurrentMoviePrice(each, movie);

                    result += decorator.decorateFilm(movie.getTitle(), currentPrice);
                }
            }
        }
        if(footer) {
            result += decorator.decorateAmount(customer.getTotalAmount());
        }
        return result;
    }
}
