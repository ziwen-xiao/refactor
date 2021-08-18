package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private final String name;
	private final ArrayList<Rental> rentalList = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentalList.add(rental);
	}

	public String getName() {
		return name;
	}

	public String getRentalAccount() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String customerAccountHeader = "Rental Record for " + getName() + "\n";
		StringBuilder customerAccount = new StringBuilder();

		while (rentals.hasNext()) {
			double pointAmount = 0;
			Rental eachRental = rentals.next();
			int daysRented = eachRental.getDaysRented();
			int movieCode = eachRental.getMovie().getPriceCode();
			String movieTitle = eachRental.getMovie().getTitle();
			double regularMoviePointBonus = (daysRented - 2) * 1.5;
			double newReleaseMoviePointBonus = daysRented * 3;
			double childrenMoviePointBonus = (daysRented - 3) * 1.5;

			switch (movieCode) {
			case Movie.REGULAR:
				pointAmount += 2;
				if (daysRented > 2)
					pointAmount += regularMoviePointBonus;
				break;
			case Movie.NEW_RELEASE:
				pointAmount += newReleaseMoviePointBonus;
				break;
			case Movie.CHILDREN:
				pointAmount += 1.5;
				if (daysRented > 3)
					pointAmount += childrenMoviePointBonus;
				break;
			}

			frequentRenterPoints++;

			if ((movieCode == Movie.NEW_RELEASE) && daysRented > 1) {
				frequentRenterPoints++;
			}

			String customerAccountBody = "\t" + movieTitle + "\t" + pointAmount + "\n";
			customerAccount.append(customerAccountHeader).append(customerAccountBody);
			totalAmount += pointAmount;

		}

		String customerAccountFooter = "Amount owed is "+ totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points";
		return customerAccount
				.append(customerAccountFooter)
				.toString();
	}

}
