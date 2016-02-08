package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Customer testCustomer;
    private Movie movie;

    @Before
    public void setUp() {
        testCustomer = new Customer("test");
        movie = new Movie("testMovie", new RegularPriceCode());
    }

    @Test
    public void statementNewReleaseTest() {
        movie.setPriceCode(new NewReleasePriceCode());
        testCustomer.addRental(new Rental(movie, 1));
        String actualString = testCustomer.Statement();

        Assert.assertEquals("Rental record for test\n" +
                "\ttestMovie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points.", actualString);
    }

    @Test
    public void statementNewReleaseWithMoreDaysTest() {
        movie.setPriceCode(new NewReleasePriceCode());
        testCustomer.addRental(new Rental(movie, 3));
        String actualString = testCustomer.Statement();

        Assert.assertEquals("Rental record for test\n" +
                "\ttestMovie\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points.", actualString);
    }

    @Test
    public void statementRegularMinTest() {
        movie.setPriceCode(new RegularPriceCode());
        testCustomer.addRental(new Rental(movie, 1));

        String actualString = testCustomer.Statement();
        boolean bool = actualString.contains("testMovie\t2.0");
        Assert.assertTrue(bool);
//
//        Assert.assertEquals("Rental record for test
//        testMovie	3.5
//        Amount owed is 3.5
//        You earned 1 frequent renter points.", actualString);
    }

    @Test
    public void stateRegularMaxTest() {
        movie.setPriceCode(new RegularPriceCode());
        testCustomer.addRental(new Rental(movie, 3));

        String actualString = testCustomer.Statement();

        Assert.assertEquals("Rental record for test\n" +
                "\ttestMovie\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points.", actualString);
    }

    @Test
    public void stateChildrensMinTest() {
        movie.setPriceCode(new ChildrenPriceCode());
        testCustomer.addRental(new Rental(movie, 2));

        String actualString = testCustomer.Statement();

        Assert.assertEquals("Rental record for test\n" +
                "\ttestMovie\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points.", actualString);
    }

    @Test
    public void stateChildrensMaxTest() {
        movie.setPriceCode(new ChildrenPriceCode());
        testCustomer.addRental(new Rental(movie, 4));

        String actualString = testCustomer.Statement();

        Assert.assertEquals("Rental record for test\n" +
                "\ttestMovie\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points.", actualString);
    }

    @Test
    public void someRentalsTest() {
        movie.setPriceCode(new ChildrenPriceCode());
        testCustomer.addRental(new Rental(movie, 5));
        testCustomer.addRental(new Rental(movie, 1));

        String actualString = testCustomer.Statement();

        Assert.assertEquals("Rental record for test\n" +
                "\ttestMovie\t3.0\n" +
                "\ttestMovie\t1.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 2 frequent renter points.", actualString);
    }
}
