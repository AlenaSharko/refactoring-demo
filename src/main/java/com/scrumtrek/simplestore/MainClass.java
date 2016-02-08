package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.codes.ChildrenPriceCode;
import com.scrumtrek.simplestore.codes.NewReleasePriceCode;
import com.scrumtrek.simplestore.codes.RegularPriceCode;
import com.scrumtrek.simplestore.printer.ConsolePrinter;
import com.scrumtrek.simplestore.printer.Printer;

class MainClass {
	//todo может public static void main() ? приоритет "1"
	 public static void main(String[] args) {
		 Printer printer = new ConsolePrinter();
		// Create movies
		Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
		Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
		Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

		// Create customers
		Customer custMickeyMouse = new Customer("Mickey Mouse");
		 //todo бесполезные переменные
		Customer custDonaldDuck = new Customer("Donald Duck");
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		// Create rentals
		Rental rental1 = new Rental(movCinderella, 5);
		Rental rental2 = new Rental(movStarWars, 5);
		Rental rental3 = new Rental(movGladiator, 5);

		// Assign rentals to customers
		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);

		// Generate invoice
		String statement = custMickeyMouse.Statement();

		// Print the statement
		 printer.print(statement);
	}
}

