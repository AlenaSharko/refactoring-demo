package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.codes.ChildrenPriceCode;
import com.scrumtrek.simplestore.codes.NewReleasePriceCode;
import com.scrumtrek.simplestore.codes.PriceCodes;
import com.scrumtrek.simplestore.codes.RegularPriceCode;

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

	public double getAmount() {
		double thisAmount = 0.0;
//		switch (getMovie().getPriceCode().getName()) {
//			case RegularPriceCode.REGULAR_PRICE_CODE_NAME:
//				thisAmount = getMovie().getPriceCode().getAmount(thisAmount, daysRented);
//				break;
//			case NewReleasePriceCode.NEW_RELEASE_PRICE_CODE_NAME:
//				thisAmount = getMovie().getPriceCode().getAmount(thisAmount, daysRented);
//				break;
//			case ChildrenPriceCode.CHILDREN_PRICE_CODE_NAME:
//				thisAmount = getMovie().getPriceCode().getAmount(thisAmount, daysRented);
//				break;
//			default:
//				break;
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

