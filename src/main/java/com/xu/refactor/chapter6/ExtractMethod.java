package com.xu.refactor.chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * 提炼函数-提炼一段代码成为独立函数
 * @author 39767
 *
 */
public class ExtractMethod {
	public void printOwing() {
		List<Double> list = new ArrayList<>();
		double outstanding = 0.0;
		
		//print banner
		System.out.println("*****************************");
		System.out.println("***** Customer Owes *********");
		System.out.println("*****************************");
		
		//calculate outstanding
		for (Double amount : list) {
			outstanding += amount;
		}
		
		//print details
		System.out.println("name:" + "name");
		System.out.println("outstanding:" + outstanding);
	}
	
	public void printOwing_R() {
		
		//print banner
		printBanner();
		
		//calculate outstanding
		double outstanding = calculateOutstanding();
		
		//print details
		printDetails(outstanding);
	}

	private double calculateOutstanding() {
		//calculate outstanding
		List<Double> list = new ArrayList<>();
		double result = 0.0;
		for (Double amount : list) {
			result += amount;
		}
		return result;
	}

	private void printDetails(double outstanding) {
		//print details
		System.out.println("name:" + "name");
		System.out.println("outstanding:" + outstanding);
	}

	private void printBanner() {
		//print banner
		System.out.println("*****************************");
		System.out.println("***** Customer Owes *********");
		System.out.println("*****************************");
	}

}
