package com.scrumtrek.simplestore.codes;

public class NewReleasePriceCode implements PriceCodes {
    public static final int NEW_RELEASE_BONUS = 3;
    public static final String NEW_RELEASE_PRICE_CODE_NAME = "NEW_RELEASE_PRICE_CODE";

    @Override
    public double getAmount(double amount, int rentalDays) {
        return (double)rentalDays * NEW_RELEASE_BONUS;
    }

    @Override
    public String getName() {
        return NEW_RELEASE_PRICE_CODE_NAME;
    }
}
