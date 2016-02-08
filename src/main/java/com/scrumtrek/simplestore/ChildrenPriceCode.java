package com.scrumtrek.simplestore;

public class ChildrenPriceCode implements PriceCodes {
    public static final double CHILDREN_BONUS = 1.5;
    public static final int CHILDREN_DAYS = 3;
    public static final double CHILDREN_ADD = 1.5;
    public static final String CHILDREN_PRICE_CODE_NAME = "CHILDREN_PRICE_CODE";

    public ChildrenPriceCode() {
    }
    @Override
    public double getAmount(double amount, int rentalDays) {
        amount += CHILDREN_BONUS;
        if (rentalDays > CHILDREN_DAYS) {
            amount = (rentalDays - CHILDREN_DAYS) * CHILDREN_ADD;
        }
        return amount;
    }

    @Override
    public String getName() {
        return CHILDREN_PRICE_CODE_NAME;
    }
}
