package com.tech.w11;

public class OrderUtil {

	//static은 공간을 객체 간 공유 가능
//	private static int count;
	//객체가 달라지면 리셋해서 실행
	private int count;
	
	public static void main(String[] args) {
		OrderUtil u1 = new OrderUtil();
		OrderUtil u2 = new OrderUtil();
		OrderUtil u3 = new OrderUtil();
		
		u1.pressButton();
		u1.pressButton();
		u2.pressButton();
		u3.pressButton();
	}//main
	
	public void pressButton() {
		count++;
		System.out.println("고객님 접수 번호는 : "+count+"번째입니다.");
	}
}//class