package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			thisAmount = getThisAmount(thisAmount, each);
			frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints, each);
			result = showFiguresForRental(result, thisAmount, each);
			totalAmount += thisAmount;

		}
		return addFooterLines(totalAmount, frequentRenterPoints, result);
	}

	private String showFiguresForRental(String result, double thisAmount, com.twu.refactoring.Rental each) {
		result += "\t" + each.getMovie().getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n";
		return result;
	}

	private int addFrequentRenterPoints(int frequentRenterPoints, com.twu.refactoring.Rental each) {
		frequentRenterPoints++;
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& each.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	private String addFooterLines(double totalAmount, int frequentRenterPoints, String result) {
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	private double getThisAmount(double thisAmount, Rental each) {
		switch (each.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (each.getDaysRented() > 2)
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += each.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (each.getDaysRented() > 3)
				thisAmount += (each.getDaysRented() - 3) * 1.5;
			break;

		}
		return thisAmount;
	}

}
