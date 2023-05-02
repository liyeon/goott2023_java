package com.tech.mission2;

public class MatrixSum2 {
	// 배열 랜덤으로 들어가고
	// 5*5
	// 가로 세로 다섯번째는 그 줄 더하기
	public void mathPrintSum() {
		int[][] arr = new int[5][5];

		// 데이터 배열에 저장
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if (row != 4 && col != 4) {
					arr[row][col] = (int) (Math.random() * 10 + 1);
					arr[row][4] += arr[row][col];//가로합
					arr[4][col] += arr[row][col];//세로합
					arr[4][4] += arr[row][col];//전체합
				} // if
			} // for col
		} // for


		// 데이터 출력
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr.length; col++) {
				System.out.print(arr[row][col] + "\t");
			} // for col
			System.out.println();
		} // for
	}// mathPrintSum
}// class