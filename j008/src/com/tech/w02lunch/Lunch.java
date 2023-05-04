package com.tech.w02lunch;

public abstract class Lunch {
	// 메뉴이름, 가격, 갯수, 할인율 전달
	private String menu;
	private int price;
	private int number;

	public Lunch() {}

	public Lunch(String menu, int price, int number) {
		this.menu = menu;
		this.price = price;
		this.number = number;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public abstract double getTotal();
	public abstract double getRealTotal();
	
	@Override
	public String toString() {
		return "메뉴 : " + getMenu() + " 금액 :  " + getPrice() + "원 갯수 :  " + getNumber();
	}
}// class