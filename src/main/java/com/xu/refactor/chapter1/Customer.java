package com.xu.refactor.chapter1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector<Rental> rentals = new Vector<>();
	
	public Customer(String name) {
		super();
		this.name = name;
	}
	
	public void addRental(Rental arg){
		this.rentals.addElement(arg);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = rentals.nextElement();
			
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if(each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if(each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() * 3) * 1.5;
				break;
			default:
				break;
			}
			
			frequentRenterPoints++;
			if(each.getDaysRented() > 1 && each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
				frequentRenterPoints++;
			
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
		
		return result;
	}
}
