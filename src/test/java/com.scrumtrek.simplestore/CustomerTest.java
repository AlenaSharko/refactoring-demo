package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void statementTest() {
        Customer testCustomer = new Customer("test");
        Movie movie1 = new Movie("testMovie", PriceCodes.NewRelease);
        Rental rental = new Rental(movie1, 1);

        testCustomer.addRental(rental);

        String actualString = testCustomer.Statement();

        Assert.assertEquals("Rental record for test\n" +
                "\ttestMovie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points.", actualString);
    }
}
