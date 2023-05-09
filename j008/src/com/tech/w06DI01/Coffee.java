package com.tech.w06DI01;

public class Coffee {
	
	private HotAmericano ame;//스택영역에 객체 이름만 만들어짐 
	//힙 영역에는 실체가 없기 때문에 nullPointException
	private IceAmericano ime;
	
	public Coffee() {
		ame = new HotAmericano(); // 실제 객체 생성 ( 힙 영역에 생성됨) 오류 x 
		ime = new IceAmericano();
		System.out.println("생성자 constructor호출됨?");
	}
	
	public void coffeeType() {
		System.out.println(ame.getName());
		System.out.println(ime.getName());
		
	}
}// class