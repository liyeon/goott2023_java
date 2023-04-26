package com.tech.mission;

public class AverageReturnExam2 {

	public static void main(String[] args) {
		/*
		 * 함수이름 : intAvg
		 * 파람 전달(10,100.7f,150,500,5f)
		 * 모두를 더하고 더한 결과를 평균을 내어
		 * 리턴은 int 로 하고
		 */
		
		AverageReturnExam2 m1 = new AverageReturnExam2();
		
		System.out.println(m1.intAvg(100,100.7f,150,500.5f));
	}//main

	
	public int intAvg(int a, float b, int c, float d) {
		int avg=0;
		double[] arr= {a,b,c,d};
		int sum=0;
		for (int i = 0; i < arr.length; i++)sum+=arr[i];
		avg= sum/arr.length;
		return avg;
	}//
}//class