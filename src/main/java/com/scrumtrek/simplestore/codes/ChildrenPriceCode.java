package com.scrumtrek.simplestore.codes;

public class ChildrenPriceCode implements PriceCodes {
    public static final double CHILDREN_BONUS = 1.5;
    public static final int CHILDREN_DAYS = 3;
    public static final double CHILDREN_ADD = 1.5;
    public static final String CHILDREN_PRICE_CODE_NAME = "CHILDREN_PRICE_CODE";

    @Override
    public double getAmount(double amount, int rentalDays) {
        if (rentalDays > CHILDREN_DAYS) {
            return (rentalDays - CHILDREN_DAYS) * CHILDREN_ADD;
        }
        return CHILDREN_BONUS;
    }

    @Override
    public String getName() {
        return CHILDREN_PRICE_CODE_NAME;
    }
}
