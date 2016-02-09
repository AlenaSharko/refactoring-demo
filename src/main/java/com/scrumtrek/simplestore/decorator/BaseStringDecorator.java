package com.scrumtrek.simplestore.decorator;

import com.scrumtrek.simplestore.Report;

public class BaseStringDecorator implements Decorator {

    public String decorateName(String name) {
        return Report.TITLE.getMessage() + name + "\n";
    }

    public String decorateFilm(String title, double amount) {
        return "\t" + title + "\t" + amount + "\n";
    }

    public String decorateAmount(double totalAmount) {
        return Report.AMOUNT_TEXT_REPORT.getMessage() + totalAmount + "\n";
    }

    public String decoratePoint(int points) {
        return Report.EARNED_TEXT.getMessage() + points + Report.END_PART.getMessage();
    }
}
