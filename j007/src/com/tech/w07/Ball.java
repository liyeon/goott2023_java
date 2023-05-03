package com.tech.w07;

public class Ball {
	// field 생성
	private double radius;

	public Ball() {
	}

	public Ball(double radius) {
		System.out.println("1번 : "+this.radius);
		this.radius=radius;
		System.out.println("2번 : "+this.radius);
	}//

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	//Object에 있는 메소드를 오버라이드 한다.
	@Override
	public String toString() {
		return "공의 반지름 : "+radius;
	}
}// class