package com.xu.refactor.chapter1_refactor;

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
		double charge = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		StringBuilder result = new StringBuilder();
		result.append("Rental Record for ").append(this.getName()).append("\n");
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			//计算影片价格
			charge = each.charge();
			//计算积分
			frequentRenterPoints += each.point();
			//计算总额
			totalAmount += charge;
			//编辑结果
			result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(charge)).append("\n");
		}
		result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n")
		.append("You earned ").append(String.valueOf(frequentRenterPoints)).append("frequent renter points");
		
		return result.toString();
	}
}
