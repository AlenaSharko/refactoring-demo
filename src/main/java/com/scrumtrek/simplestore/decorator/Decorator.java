package com.scrumtrek.simplestore.decorator;

public interface Decorator {
    String decorateName(String name);

    String decorateFilm(String title, double amount);

    String decorateAmount(double totalAmount);

    String decoratePoint(int points);
}
