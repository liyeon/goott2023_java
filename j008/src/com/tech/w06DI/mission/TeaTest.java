package com.tech.w06DI.mission;

public class TeaTest {

	public static void main(String[] args) {
		BlackTea black = new BlackTea();
		GreenTea green = new GreenTea();
		YuzaTea yuza = new YuzaTea();
		
		Tea tea = new Tea(black);
		tea.teaType();
		
		System.out.println("=========================");
		
		Tea tea2 = new Tea(green);
		tea2.teaType();
		
		System.out.println("=========================");
		
		Tea tea3 = new Tea(yuza);
		tea3.teaType();
	}//main
}//class