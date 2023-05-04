package com.tech.w02lunch;

public class ChinaLunch extends Lunch {
	private double discount;

	public ChinaLunch() {
	}

	public ChinaLunch(String menu, int price, int number, double discount) {
		super(menu, price, number);
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
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
		double disc = getDiscount()/100*getTotal();
		return getTotal()-disc;
	}
	@Override
	public String toString() {
		return super.toString() + " 할인율 : " + getDiscount() + "%";
	}

}
