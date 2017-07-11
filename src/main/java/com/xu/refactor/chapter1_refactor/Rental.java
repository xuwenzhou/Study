package com.xu.refactor.chapter1_refactor;

public class Rental {
	private Movie movie;//电影
	private int daysRented;//租赁天数
	
	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public double charge() {
		return this.movie.charge(this.daysRented);
	}
	
	public int point(){
		return this.movie.point(this.daysRented);
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	
	
}
