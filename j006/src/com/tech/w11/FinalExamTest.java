package com.tech.w11;

public class FinalExamTest {
	public static void main(String[] args) {
		FinalExam fe = new FinalExam();
		int w = 100;
		int h = 501;

		double result = fe.getArea(fe.TRIANGLE, w, h);

		System.out.println("Area : "+result);
	}// main
}// class