package com.tech.mission2;

import java.util.Random;

public class MatrixSum {
	//배열 랜덤으로 들어가고
	// 5*5 
	//가로 세로 다섯번째는 그 줄 더하기
	public void mathPrintSum() {
		int[][] arr = new int[5][5];
		Random r = new Random();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = r.nextInt(50) + 1;
				arr[i][4] += arr[i][j]; // 가로 합
				arr[4][j] += arr[i][j]; // 세로 합
				arr[4][4] += arr[i][j]; // 전체 합
			}
		}//for
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}//for
	}//mathPrintSum
}//class