package com.tech.w05.mission;

public class Taxi extends Trans {
	private int price;
	
	public Taxi() {}
	public Taxi(int person, int distance, int price) {
		super(person, distance);
		this.price=price;
	}
	
	public int getPrice() {
		return price;
	}
	@Override
	public int getCharge() {
		return getPerson() * getDistance() * getPrice();
	}
	
	@Override
	public String toString() {
		return super.toString() +" | 단가 : "+getPrice()+"\n금액 : "+getCharge()+"원";
	}
}//class