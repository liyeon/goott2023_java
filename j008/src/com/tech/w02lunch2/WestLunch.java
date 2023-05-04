package com.tech.w02lunch2;

public class WestLunch extends Lunch {
	private double discount;

	public WestLunch() {
	}

	public WestLunch(String menu, int price, int number, double discount) {
		super(menu, price, number);
		this.discount = discount;
	}

	@Override
	public String toString() {
		return super.toString() + " 할인율 : " + discount*100 + "%";
	}

	@Override
	public double getTotal() {
		double total = fprice*personCnt*(1-discount);
		return total;
	}
}
