package com.tech.w01;

public class BMIExam1 {

	public static void main(String[] args) {
		// 객체 생성
		BMIExam1 m = new BMIExam1();
		float h = 1.8f;
		float w = 90.0f;
		float index = m.calculater(h, w);// return 을 float 으로 받겠다.
		System.out.println("체질량지수 : " + index);
		// 체질량 지수로 비만도 판정
		String massage = m.getResult(index);
		System.out.println("판정  : " + massage);
	}// main

	public String getResult(float index) {
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

	public float calculater(float h, float w) {

		float hmulti = h * h;
		float index = w / hmulti;

		return index;
	}// clculater

}// class