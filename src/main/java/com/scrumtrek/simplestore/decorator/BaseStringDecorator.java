package com.scrumtrek.simplestore.decorator;

import com.scrumtrek.simplestore.Report;

public class BaseStringDecorator implements Decorator {

    @Override
    public String decorateName(String name) {
        return Report.TITLE.getMessage() + name + "\n";
    }

    @Override
    public String decorateFilm(String title, double amount) {
        return "\t" + title + "\t" + amount + "\n";
    }

    @Override
    public String decorateAmount(double totalAmount) {
        return Report.AMOUNT_TEXT_REPORT.getMessage() + totalAmount + "\n";
    }

    @Override
    public String decoratePoint(int points) {
        return Report.EARNED_TEXT.getMessage() + points + Report.END_PART.getMessage();
    }
}
