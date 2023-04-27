package com.tech.w01;

public class MethodExam2 {

	public static void main(String[] args) {
		//자신의 클래스를 객체로 만들기
		MethodExam2 m1 = new MethodExam2();
		
		//호출
		m1.makeSum();
	}//main

//	private static void makeSum() {
//		 System.out.println("makeSum 메소드 호출");
//		
//	}
	
	//makeSum
	public void makeSum(){
		int sum=0;
		int start=50;
		int end=100;
		for (int i = start; i <= end; i++) {
			sum+=i;
		}//for
		System.out.println("start : "+start);
		System.out.println("end : "+end);
		System.out.println("Sum : "+sum);
	}//makeSum

}//class