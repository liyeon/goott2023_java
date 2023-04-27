package com.tech.w02;

public class Car {
	//필드에서는 기본값으로 알아서 초기화
	String color;
	int speed;
	boolean power;

	public static void main(String[] args) {
		int channel=10;
//		channel=(int)Math.random();//대입된값이면 초기화를 의미
		System.out.println(channel);
		Car c = new Car();//객체 생성
		c.runCar();
	}//
	
	//메소드
	public void runCar() {
		System.out.println("COLOR : "+color);
		System.out.println("SPEED : "+speed);
		System.out.println("POWER : "+power);
	}
	
	//
	public void stopCar() {
		System.out.println("");
	}
}//