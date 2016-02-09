/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrumtrek.simplestore;

/**
 * @author root
 */
public enum Report {
    TITLE("Rental record for "),
    AMOUNT_TEXT_REPORT("Amount owed is "),
    EARNED_TEXT("You earned "),
    END_PART(" frequent renter points.");

    private String message;

    Report(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
