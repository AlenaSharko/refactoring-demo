package com.scrumtrek.simplestore.decorator;

import com.scrumtrek.simplestore.Report;

public class HTMLDecorate implements Decorator {
    private static final String START_HTML = "<html>\n" +
            "    <head></head>\n" +
            "    <body>\n";
    private static final String END_HTML = "    </body>\n" +
            "</html>";

    private final static String brTag = "<br>";

    @Override
    public String decorateName(String name) {
        return START_HTML + Report.TITLE.getMessage() + name + brTag;
    }
    @Override
    public String decorateFilm(String title, double amount) {
        return title + setBold(amount) + brTag;
    }
    @Override
    public String decorateAmount(double totalAmount) {
        return Report.AMOUNT_TEXT_REPORT.getMessage() + setBold(totalAmount) + brTag;
    }
    @Override
    public String decoratePoint(int points) {
        return Report.EARNED_TEXT.getMessage() + points + Report.END_PART.getMessage() + END_HTML;
    }

    private String setBold(double value) {
        return " <b>" + value + "</b>";
    }
}
