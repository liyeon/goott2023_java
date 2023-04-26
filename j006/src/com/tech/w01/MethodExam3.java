package com.tech.w01;

public class MethodExam3 {

	public static void main(String[] args) {
		//자신의 클래스를 객체로 만들기
		MethodExam3 m1 = new MethodExam3();
		
		//호출
		//param 값 전달
		int getSum = m1.makeSum(1,10);
		System.out.println("result : "+getSum);
		
	}//main

//	private static void makeSum() {
//		 System.out.println("makeSum 메소드 호출");
//		
//	}
	
	//makeSum
	public int makeSum(int getStart, int getEnd){//전달되는 값으로 구분 가능하다.
		int sum=0;
		int start = getStart;
		int end = getEnd;
		for (int i = start; i <= end; i++) {
			sum+=i;
		}//for
//		System.out.println("===========================");
//		System.out.println("start : "+start);
//		System.out.println("end : "+end);
//		System.out.println("Sum : "+sum);
//		System.out.println("===========================");
		return sum;
	}//makeSum
}//class