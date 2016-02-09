/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrumtrek.simplestore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class CustomerTest {

    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Statement method, of class Customer.
     */
    @Test
    public void testRegularStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.Regular);
        instance.addRental(new Rental(m, 3));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 3.5 + "\n";
        expResult += "Amount owed is 3.5\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }
    
        @Test
    public void testChildrensStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.Childrens);
        instance.addRental(new Rental(m, 3));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 1.5 + "\n";
        expResult += "Amount owed is 1.5\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }
    
            @Test
    public void tesNewReleaseStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.NewRelease);
        instance.addRental(new Rental(m, 3));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 9.0 + "\n";
        expResult += "Amount owed is 9.0\n";
        expResult += "You earned 2 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }
    
            @Test
    public void tesNewReleaseOneDayStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.NewRelease);
        instance.addRental(new Rental(m, 1));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 3.0 + "\n";
        expResult += "Amount owed is 3.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testXXXStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.XXX);
        instance.addRental(new Rental(m, 1));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 2.0 + "\n";
        expResult += "Amount owed is 2.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
    }

    @Test
    public void testXXXWithMoreDays() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.XXX);
        instance.addRental(new Rental(m, 6));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 2.8 + "\n";
        expResult += "Amount owed is 2.8\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
    }
    
    
    @Test
    public void getCurrentMoviePriceNewReleaseTest(){
        Customer cust = new Customer("Stasik");
        Movie movie = new Movie("Star Treck", PriceCodes.NewRelease);
        Rental rental = new Rental(movie, 1);
        double actualPrice = cust.getCurrentMoviePrice(rental);
        assertEquals(3.0, actualPrice, 0.0);
    }
    
        @Test
    public void getCurrentMoviePriceChildrenTest(){
        Customer cust = new Customer("Stasik");
        Movie movie = new Movie("Cinderella", PriceCodes.Childrens);
        Rental rental = new Rental(movie, 1);
        double actualPrice = cust.getCurrentMoviePrice(rental);
        assertEquals(1.5, actualPrice, 0.0);
    }
    
        @Test
    public void getCurrentMoviePriceRegularTest(){
        Customer cust = new Customer("Stasik");
        Movie movie = new Movie("Cinderella", PriceCodes.Regular);
        Rental rental = new Rental(movie, 1);
        double actualPrice = cust.getCurrentMoviePrice(rental);
        assertEquals(2.0, actualPrice, 0.0);
    }
    
      @Test
    public void testRegularOneDayStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.Regular);
        instance.addRental(new Rental(m, 1));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 2.0 + "\n";
        expResult += "Amount owed is 2.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }
    
        @Test
    public void testChildrensOneDayStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.Childrens);
        instance.addRental(new Rental(m, 4));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 3.0 + "\n";
        expResult += "Amount owed is 3.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

}
