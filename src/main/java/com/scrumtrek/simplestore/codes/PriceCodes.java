package com.scrumtrek.simplestore.codes;

public interface PriceCodes {
	double getAmount(double amount, int rentalDays);

	String getName();
}
