package com.tech.w02;

public class MinMaxExam {

	public static void main(String[] args) {
		//배열 안의 최소값 최대값 구하기
		int min=101;
		int max=0;
		int[] arr = {80,40,70,20,30};
		
		for (int i = 0; i < arr.length; i++) {
			if(min>arr[i])min=arr[i];
			if(max<arr[i])max=arr[i];
		}//for
		System.out.println("최소 : "+min+" 최대 : "+max);
	}//main

}//class