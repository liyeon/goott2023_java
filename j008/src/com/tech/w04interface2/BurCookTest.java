package com.tech.w04interface2;

public class BurCookTest {
	public static void main(String[] args) {
		//다형성
		BurCook cook1 = new FastCook();
		BurCook cook2 = new HotelCook();
		
		cook1.makeBur();
		cook1.makeSalad();
		
		cook2.makeBur();
		cook2.makeSalad();
	}//main
}//class