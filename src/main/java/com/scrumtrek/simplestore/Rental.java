package com.scrumtrek.simplestore;

public class Rental {
	//todo что за m?
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
}

