package com.tech.w06;

public class ForExam3 {

	public static void main(String[] args) {
		// 반복문을 사용한 합계 구하기 
		//1~10 합계 
		int sum = 0; // 누적 변수
		for (int i = 1; i <= 10; i++) {
			sum*=i;
			//sum = sum*i, sum*=i
			System.out.println(i+" : 반복 ");
		}//반복문 종료
		
		//최종 출력 
		System.out.println("총 값 : "+sum);
	}//main 종료
}//class 종료