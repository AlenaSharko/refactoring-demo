/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.decorator.BaseStringDecorator;
import com.scrumtrek.simplestore.decorator.Decorator;
import com.scrumtrek.simplestore.decorator.HTMLDecorate;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
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
     * Test of statement method, of class Customer.
     */
    @Test
    public void testRegularStatement() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.Regular);
        Rental rental = new Rental(3);
        rental.addMovie(m);
        instance.addRental(rental);

        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 3.5 + "\n";
        expResult += "Amount owed is 3.5\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testChildrensStatement() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.Childrens);
        Rental rental = new Rental(3);
        rental.addMovie(m);
        instance.addRental(rental);
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 1.5 + "\n";
        expResult += "Amount owed is 1.5\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void tesNewReleaseStatement() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.NewRelease);
        Rental rental = new Rental(3);
        rental.addMovie(m);
        instance.addRental(rental);
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 9.0 + "\n";
        expResult += "Amount owed is 9.0\n";
        expResult += "You earned 2 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void tesNewReleaseOneDayStatement() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.NewRelease);
        Rental rental = new Rental(1);
        rental.addMovie(m);
        instance.addRental(rental);
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 3.0 + "\n";
        expResult += "Amount owed is 3.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testXXXStatement() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.XXX);
        Rental rental = new Rental(1);
        rental.addMovie(m);
        instance.addRental(rental);
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 2.0 + "\n";
        expResult += "Amount owed is 2.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
    }

    @Test
    public void testXXXWithMoreDays() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.XXX);
        Rental rental = new Rental(6);
        rental.addMovie(m);
        instance.addRental(rental);
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 2.8 + "\n";
        expResult += "Amount owed is 2.8\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
    }


    @Test
    public void getCurrentMoviePriceNewReleaseTest() {
        Customer cust = new Customer("Stasik", new BaseStringDecorator());
        Movie movie = new Movie("Star Treck", PriceCodes.NewRelease);
        Rental rental = new Rental(1);
        rental.addMovie(movie);
        cust.addRental(rental);
        double actualPrice = cust.getCurrentMoviePrice(rental,movie);
        assertEquals(3.0, actualPrice, 0.0);
    }

    @Test
    public void getCurrentMoviePriceChildrenTest() {
        Customer cust = new Customer("Stasik", new BaseStringDecorator());
        Movie movie = new Movie("Cinderella", PriceCodes.Childrens);
        Rental rental = new Rental(1);
        rental.addMovie(movie);
        cust.addRental(rental);
        double actualPrice = cust.getCurrentMoviePrice(rental, movie);
        assertEquals(1.5, actualPrice, 0.0);
    }

    @Test
    public void getCurrentMoviePriceRegularTest() {
        Customer cust = new Customer("Stasik", new BaseStringDecorator());
        Movie movie = new Movie("Cinderella", PriceCodes.Regular);
        Rental rental = new Rental(1);
        rental.addMovie(movie);
        cust.addRental(rental);
        double actualPrice = cust.getCurrentMoviePrice(rental, movie);
        assertEquals(2.0, actualPrice, 0.0);
    }

    @Test
    public void testRegularOneDayStatement() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.Regular);
        Rental rental = new Rental(1);
        rental.addMovie(m);
        instance.addRental(rental);
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 2.0 + "\n";
        expResult += "Amount owed is 2.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testChildrensOneDayStatement() {
        System.out.println("statement");
        Customer instance = new Customer("Igor Startsev", new BaseStringDecorator());
        Movie m = new Movie("007", PriceCodes.Childrens);
        Rental rental = new Rental(4);
        rental.addMovie(m);
        instance.addRental(rental);
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 3.0 + "\n";
        expResult += "Amount owed is 3.0\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void baseStringDecoratorTest() {
        Decorator baseStringDecorator = new BaseStringDecorator();
        String testString = "decorate me";

        String decorateName = baseStringDecorator.decorateName(testString);
        Assert.assertEquals(Report.TITLE.getMessage() + testString + "\n", decorateName);

        String decorateFilm = baseStringDecorator.decorateFilm(testString, 0.0);
        Assert.assertEquals("\t" + testString + "\t" + 0.0 + "\n", decorateFilm);

        String decorateAmount = baseStringDecorator.decorateAmount(1.0);
        Assert.assertEquals(Report.AMOUNT_TEXT_REPORT.getMessage() + 1.0 + "\n", decorateAmount);

        String decoratePoints = baseStringDecorator.decoratePoint(100);
        Assert.assertEquals(Report.EARNED_TEXT.getMessage() + 100 + Report.END_PART.getMessage(), decoratePoints);
    }

    @Test
    public void HTMLDecoratorTest() {
        Decorator baseStringDecorator = new HTMLDecorate();
        String testString = "decorate me";
        String startHtml = "<html>\n" +
                "    <head></head>\n" +
                "    <body>\n";

        String endHTML = "    </body>\n" +
                "</html>";

        String decorateName = baseStringDecorator.decorateName(testString);
        Assert.assertEquals(startHtml + Report.TITLE.getMessage() + testString + "<br>", decorateName);

        String decorateFilm = baseStringDecorator.decorateFilm(testString, 0.0);
        Assert.assertEquals(testString + " <b>" + 0.0 + "</b>" + "<br>", decorateFilm);

        String decorateAmount = baseStringDecorator.decorateAmount(1.0);
        Assert.assertEquals(Report.AMOUNT_TEXT_REPORT.getMessage() + " <b>" + 1.0 + "</b>" + "<br>", decorateAmount);

        String decoratePoints = baseStringDecorator.decoratePoint(100);
        Assert.assertEquals(Report.EARNED_TEXT.getMessage() + 100 + Report.END_PART.getMessage() + endHTML, decoratePoints);
    }

}
