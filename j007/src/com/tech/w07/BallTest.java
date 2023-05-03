package com.tech.w07;

public class BallTest extends Ball {

	public static void main(String[] args) {
		//ball 객체를 호출하면서 사용자 생성자 호출
		BallTest ball = new BallTest(50);
		System.out.println(ball.toString());
	}// main

	public BallTest(double radius) {
		super(radius);
	}//
}// class