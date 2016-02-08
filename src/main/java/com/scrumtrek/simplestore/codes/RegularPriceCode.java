package com.scrumtrek.simplestore.codes;

import com.scrumtrek.simplestore.codes.PriceCodes;

public class RegularPriceCode implements PriceCodes {
    public static final int REGULAR_BONUS = 2;
    public static final int REGULAR_DAYS = 2;
    public static final double REGULAR_ADD = 1.5;
    public static final String REGULAR_PRICE_CODE_NAME = "REGULAR_PRICE_CODE";

    @Override
    public double getAmount(double amount, int rentalDays) {
        if (rentalDays > REGULAR_DAYS) {
            return  (rentalDays - REGULAR_DAYS) * REGULAR_ADD + REGULAR_BONUS;
        }
        return REGULAR_BONUS;
    }

    public String getName() {
        return REGULAR_PRICE_CODE_NAME;
    }
}
