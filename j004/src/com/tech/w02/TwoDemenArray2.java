package com.tech.w02;

public class TwoDemenArray2 {

	public static void main(String[] args) {
		//이차원 배열 선언
		/*
		 * 5,4 배열 만들어서 
		 * 값을 1씩 증가된 값이 배열에 쌓이고 결과를 출력해라 
		 */
		
		int[][] arr =new int[5][4];
		int total =0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total= total + 1;
				
				arr[i][j]=total;
				System.out.print(arr[i][j]+"\t");
			}//
			System.out.println();
		}//
	}//main
}//class