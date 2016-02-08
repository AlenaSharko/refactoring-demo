package com.scrumtrek.simplestore.printer;

import com.scrumtrek.simplestore.printer.Printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
