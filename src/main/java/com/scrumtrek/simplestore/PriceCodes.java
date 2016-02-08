package com.scrumtrek.simplestore;

interface PriceCodes {
	double getAmount(double amount, int rentalDays);

	String getName();
}
