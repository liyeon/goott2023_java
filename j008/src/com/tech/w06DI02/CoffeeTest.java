package com.tech.w06DI02;

public class CoffeeTest {

	public static void main(String[] args) {
		HotAmericano hot = new HotAmericano();
		IceAmericano ice = new IceAmericano();
		
		Coffee coffee = new Coffee(hot);
		Coffee coffee2 = new Coffee(ice);
		coffee.coffeeType();
		coffee2.coffeeType();
	}//main

}//class