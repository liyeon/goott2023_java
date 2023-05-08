package com.tech.w08Star;

public class StarTest {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println("*");
		}

		System.out.println("============================");

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		System.out.println("============================");

		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		System.out.println("============================");

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println("============================");
		
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*(6-i-1)+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("============강사님 코드================");
		int num = 5;
		
		for (int i = 0; i < num; i++) {
			for (int j = num; j > i; j--) {
				System.out.print(" ");
			}
			int t = 2*i+1;
			for (int j = 0; j < t; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}// main
}// class