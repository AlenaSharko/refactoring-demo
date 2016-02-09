package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Rental {
    private int mDaysRented;
    private ArrayList<Movie> movieList = new ArrayList<>();

    public Rental(int daysRented) {
        mDaysRented = daysRented;
    }

    public int getDaysRented() {
        return mDaysRented;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
}

