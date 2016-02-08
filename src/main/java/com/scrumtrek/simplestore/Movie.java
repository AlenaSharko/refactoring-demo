package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.codes.PriceCodes;

public class Movie {
	private String movieTitle;
	private PriceCodes moviePriceCode;

	public Movie(String title, PriceCodes priceCode) {
		movieTitle = title;
		moviePriceCode = priceCode;
	}

	public PriceCodes getPriceCode()	{
		return moviePriceCode;
	}
	
	public void setPriceCode(PriceCodes value) {
		moviePriceCode = value;
	}

	public String getTitle() {
		return movieTitle;
	}
}

