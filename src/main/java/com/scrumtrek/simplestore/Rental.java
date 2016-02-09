package com.scrumtrek.simplestore;

public class Rental {
	private Movie mMovie;
	private int mDaysRented;

	public Rental(Movie movie, int daysRented) {
		mMovie = movie;
		mDaysRented = daysRented;
	}

	public int getDaysRented() {
		return mDaysRented;
	}

	public Movie getMovie() {
		return mMovie;
	}
}

