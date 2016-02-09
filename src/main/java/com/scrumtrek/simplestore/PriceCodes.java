package com.scrumtrek.simplestore;

public enum PriceCodes {

    Regular(2.0, 1.5, 2),
    NewRelease(0.0, 3.0, 0),
    Childrens(1.5, 1.5, 3);

    private double startPrice;
    private double amountPrice;
    private int lowCostDaysCount;

    PriceCodes(double firstPrice, double amountPrice, int dayFirstPrice) {
        this.startPrice = firstPrice;
        this.amountPrice = amountPrice;
        this.lowCostDaysCount = dayFirstPrice;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public double getAmountPrice() {
        return amountPrice;
    }

    public int getLowCostDaysCount() {
        return lowCostDaysCount;
    }

}
