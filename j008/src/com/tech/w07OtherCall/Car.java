package com.tech.w07OtherCall;

public class Car {

	String company = "현대";
	String model;
	String color;
	int maxSpeed;

	public Car() {
	}
	//생성자 오버로딩
	//매개변수의 타입, 개수, 순서가 다르게 여러개의 생성자를 선언하는것
	public Car(String model) {
//		this.model=model;
		this(model, "은색", 250);//다른 생성자 호출
		System.out.println("여기를 거쳐서 다른 생성자 호출");
	}

	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public void printMyCarInfo() {
		System.out.println("company : " + company);
		System.out.println("model : " + model);
		System.out.println("color : " + color);
		System.out.println("maxSpeed : " + maxSpeed);
	}// method

}// class