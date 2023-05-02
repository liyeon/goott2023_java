package com.tech.w11;

public class Calculator {
	public static void main(String[] args) {
		// 객체 생성
//		Calculator cal = new Calculator();

		double returnValue1 = Calculator.add(7, 5);
		System.out.println("결과값 : " + returnValue1);

		double returnValue2 = Calculator.sub(7, 5);
		System.out.println("결과값 : " + returnValue2);

		double returnValue3 = Calculator.multiply(7, 5);
		System.out.println("결과값 : " + returnValue3);

		double returnValue4 = Calculator.divide(7, 5);
		System.out.println("결과값 : " + returnValue4);
	}// main

	// 더하기
	public static double add(double x, double y) {
		return x + y;
	}// add

	// 빼기
	public static double sub(double x, double y) {
		return x - y;
	}// sub

	public static double multiply(double x, double y) {
		return x * y;
	}// multiply

	public static double divide(double x, double y) {
		return x / y;
	}// divide
}// class