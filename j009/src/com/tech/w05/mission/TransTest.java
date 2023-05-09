package com.tech.w05.mission;

public class TransTest {
	public static void main(String[] args) {
		Trans[] trans = new Trans[4];
		trans[0] = new Train(10,100,500);
		trans[1] = new CityBus(10,100,100);
		trans[2] = new Express(2,20,1500);
		trans[3] = new Taxi(3,100,1000);
		for (int i = 0; i < trans.length; i++) {
			System.out.println("======================================");
			System.out.println(trans[i]);
		}//for
		System.out.println("======================================");
	}//main
}//class