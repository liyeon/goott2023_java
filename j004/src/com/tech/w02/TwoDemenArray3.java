package com.tech.w02;

import java.util.Arrays;

public class TwoDemenArray3 {

	public static void main(String[] args) {
		//이차원 배열 선언
		/*
		 * 5,4 배열 만들어서 
		 * 값을 1씩 증가된 값이 배열에 쌓이고 결과를 출력해라 
		 */
		
		int[][] arr =new int[5][4];
		int cnt =1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				
				arr[i][j]=cnt;
				cnt++;
				System.out.print(arr[i][j]+"\t");
			}//
			System.out.println();
		}//
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}//main
}//class