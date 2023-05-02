package com.tech.w02;

public class CarMakeClass {
	public static void main(String[] args) {
		
		BenzClass bc = new BenzClass();
		EquusClass ec = new EquusClass();
		SonataClass sc = new SonataClass();

		bc.doJoripBenz();
		
		System.out.println("==================");
		
		ec.doJoripEquus();
		
		System.out.println("==================");
		
		sc.doJoripSonata();
	}// main
}// class