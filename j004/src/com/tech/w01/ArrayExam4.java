package com.tech.w01;

public class ArrayExam4 {

	public static void main(String[] args) {
//		int[] arr = new int[5];
		// 배열 선언의 다른 방법
		// 배열의 생성과 초기화를 동시에한다.
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
		System.out.println("길이 : " + arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			// 마지막 배열에서 콤마를 출력하지 않는다.
			if (i < arr.length - 1) System.out.print(", ");
		}//반복문 종료
	}// main 종료
}// class 종료