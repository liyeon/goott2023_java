package com.tech.w06;


public class ForGuGuExam2 {

	public static void main(String[] args) {
		//5단 출력
		for (int dan=2; dan<10; dan++) {
//			System.out.println("5 X "+i+" = "+5*i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d \t X \t %d \t = \t 2%d \n",dan,j,dan*j);
			}//반복문 j 종료
			System.out.println("======================");
		}//	반복문 i 종료
	}//main 종료
}//class 종료