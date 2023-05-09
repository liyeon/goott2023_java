package com.tech.w06DI02;

public class Coffee {
	
	//인터페이스를 접목한 Di 구현
	private Americano ame;
	
	public Coffee() {}
	public Coffee(Americano ame) {
		this.ame = ame;
		System.out.println("생성자 constructor호출됨?");
	}
	
	public void coffeeType() {
		System.out.println(ame.getName());
		
	}
}// class