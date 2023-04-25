package com.tech.w01;

import java.util.Scanner;

public class ArrayExam3 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		// Scanner 를 활용한 데이터 입력
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<arr.length; i++) {
			System.out.println("숫자"+(i+1)+"번째를 입력하세요.");
			arr[i] = scan.nextInt();
			
		}//반복문
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("입력한 " + (i + 1) + " 번째 숫자는 : " + arr[i] + " 입니다.");
		}//반복문 종료
		scan.close();
	}// main 종료

}// class 종료