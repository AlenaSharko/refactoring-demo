package com.scrumtrek.simplestore;

public class Rental {
	//todo что за m?
	private Movie movieName;
	private int daysRented;
	private PriceCodes priceCode;

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
		switch (getMovie().getPriceCode().getName()) {
			case RegularPriceCode.REGULAR_PRICE_CODE_NAME:
				thisAmount = getMovie().getPriceCode().getAmount(thisAmount, daysRented);
				break;
			case NewReleasePriceCode.NEW_RELEASE_PRICE_CODE_NAME:
				thisAmount = getMovie().getPriceCode().getAmount(thisAmount, daysRented);
				break;
			case ChildrenPriceCode.CHILDREN_PRICE_CODE_NAME:
				thisAmount = getMovie().getPriceCode().getAmount(thisAmount, daysRented);
				break;
		}
		return thisAmount;
	}

	public int getUpdatedFreqPoints(int frequentRenterPoints) {
		frequentRenterPoints++;
		// Add bonus for a two-day new-release rental
		if ((getMovie().getPriceCode().getName().equals(NewReleasePriceCode.NEW_RELEASE_PRICE_CODE_NAME) &&
				(getDaysRented() > 1))) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
}

