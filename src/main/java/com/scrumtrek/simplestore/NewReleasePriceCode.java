package com.scrumtrek.simplestore;

public class NewReleasePriceCode implements PriceCodes {
    public static final int NEW_RELEASE_BONUS = 3;
    public static final String NEW_RELEASE_PRICE_CODE_NAME = "NEW_RELEASE_PRICE_CODE";

    public NewReleasePriceCode() {
    }
    @Override
    public double getAmount(double amount, int rentalDays) {
        amount += rentalDays * NEW_RELEASE_BONUS;
        return amount;
    }
    
    public String getName() {
        return NEW_RELEASE_PRICE_CODE_NAME;
    }
}
