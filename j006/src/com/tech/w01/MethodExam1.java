package com.tech.w01;

public class MethodExam1 {

	public static void main(String[] args) {
		//자신의 클래스를 객체로 만들기
		MethodExam1 m1 = new MethodExam1();
		
		//호출
		m1.makeSum();
		
		//객체를 생성하지 않고 호출
//		makeSum();//객체(new)를 만들지 않으면 static 이 들어가여ㅑ한다.
		
		m1.hihi();
	}//main

//	private static void makeSum() {
//		 System.out.println("makeSum 메소드 호출");
//		
//	}
	
	//makeSum
	public void makeSum(){
		int sum=0;
		for (int i = 0; i <= 10; i++) {
			sum+=i;
		}//for
		System.out.println("Sum : "+sum);
	}//makeSum

	public void hihi() {
		System.out.println("안녕! 오랜만이야!!");
	}//hihi
}//class