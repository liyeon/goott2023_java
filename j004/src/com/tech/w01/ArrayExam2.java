package com.tech.w01;

import java.util.Scanner;

public class ArrayExam2 {

	public static void main(String[] args) {
		// 배열 선언과 생성
		int[] arr = new int[5];
		// 초기화 없이 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}//반복문 종료

		// 데이터 대입
		int[] arr2 = { 100, 200, 300, 400, 500 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}//반복문 종료 
		System.out.println("배열의 길이 : " + arr2.length);

		// Scanner 를 활용한 데이터 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요.");
		arr[0]=scan.nextInt();
		System.out.println("두번째 숫자를 입력하세요.");
		arr[1]=scan.nextInt(); // 값을 입력받아 배열에 담는다.
		System.out.println("세번째 숫자를 입력하세요.");
		arr[2]=scan.nextInt();
		System.out.println("네번째 숫자를 입력하세요.");
		arr[3]=scan.nextInt();
		System.out.println("다섯번째 숫자를 입력하세요.");
		arr[4]=scan.nextInt();
		for (int i = 0; i < arr.length; i++) {
			System.out.println("입력한 " +(i+1)+" 번째 숫자는 : "+arr[i] + " 입니다.");
		}//반복문 종료
		scan.close();
	}// main 종료

}// class 종료