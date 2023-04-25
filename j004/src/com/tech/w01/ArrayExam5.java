package com.tech.w01;

public class ArrayExam5 {

	public static void main(String[] args) {
		// 배열의 생성과 초기화를 동시에한다.
		int[] arr = { 10, 20, 30, 40, 50, 60, 71, 82 };
		// 총점 매기기
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		} // 반복문 종료
		float avg = sum / (float)arr.length;
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("인원수 : " + arr.length);
	}// main 종료
}// class 종료