package com.tech.w01;

public class MethodExam4 {

	public static void main(String[] args) {
		//자신의 클래스를 객체로 만들기
		MethodExam4 m1 = new MethodExam4();
		
		//호출
		//param 값 전달
		int getSum = m1.makeSum(1,10);
		System.out.println("result : "+getSum);
		
		float getAvg=m1.makeAvg(getSum,5);
		System.out.println(getAvg);
	}//main

	//makeSum
	public int makeSum(int getStart, int getEnd){//전달되는 값으로 구분 가능하다.
		int sum=0;
		int start = getStart;
		int end = getEnd;
		for (int i = start; i <= end; i++) {
			sum+=i;
		}//for
		return sum;//호출한곳으로돌려보냄
	}//makeSum
	
	public float makeAvg(int tot, int cnt) {
		float avg=(float)tot/cnt;
		return avg;
	}//makeAvg
}//class