package com.tech.w02lunch2;

public class ChinaLunch extends Lunch {
	private double discount;

	
	public ChinaLunch() {
	}


	public ChinaLunch(String fmenu, int fprice, int personCnt, double discount) {
		super(fmenu, fprice, personCnt);
		this.discount=discount;
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
