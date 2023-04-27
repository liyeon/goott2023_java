package com.tech.w01;

import java.util.Scanner;

public class BMIExam2 {

	public static void main(String[] args) {
		// 객체 생성
		BMIExam2 m = new BMIExam2();
		Scanner s = new Scanner(System.in);
		
		System.out.print("키를 입력해주세요 >>");
		double h = s.nextDouble();;
		h=h/100;
		System.out.print("몸무게를 입력해주세요 >>");
		double w = s.nextDouble();;
		double index = m.calculater(h, w);// return 을 float 으로 받겠다.
		System.out.println("체질량지수 : " + index);
		// 체질량 지수로 비만도 판정
		String massage = m.getResult(index);
		System.out.println("판정  : " + massage);
	}// main

	public String getResult(double index) {
		String msg = "";
		if (index >= 25) {
			msg = "비만";
		} else if (index >= 23) {
			msg = "과체중";
		} else if (index >= 18.5) {
			msg = "정상";
		} else {
			msg = "저체중";
		}
		return msg;
	}// getResult

	public double calculater(double h, double w) {

		double hmulti = h * h;
		double index = w / hmulti;

		return index;
	}// clculater

}// class