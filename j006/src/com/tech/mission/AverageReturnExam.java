package com.tech.mission;

public class AverageReturnExam {

	public static void main(String[] args) {
		/*
		 * 함수이름 : makeAvg
		 * 파람 전달(10,100.150,500,20)
		 */
		
		AverageReturnExam m1 = new AverageReturnExam();
		
		System.out.println(m1.makeAvg(10, 103, 150, 500, 20));
	}//main

	
	public double makeAvg(int a, int b, int c, int d, int f) {
		double avg=0.0;
		int[] arr= {a,b,c,d,f};
		int sum=0;
		for (int i = 0; i < arr.length; i++)sum+=arr[i];
		avg= sum/(double)arr.length;
		return avg;
	}//
}//class