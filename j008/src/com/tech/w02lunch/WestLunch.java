package com.tech.w02lunch;

public class WestLunch extends Lunch {
	private double discount;

	public WestLunch() {
	}

	public WestLunch(String menu, int price, int number, double discount) {
		super(menu, price, number);
		this.discount = discount;
	}

	double total;
	@Override
	public double getTotal() {
		total = getPrice() * getNumber();
		return total;
	}

	@Override
	public double getRealTotal() {
		double disc = getDiscount()/100*getTotal();;
		return getTotal()-disc;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return super.toString() + " 할인율 : " + getDiscount() + "%";
	}
}
