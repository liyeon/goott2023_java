package com.tech.w06;

public class ForGuGuExam3 {

	public static void main(String[] args) {
		//횡으로 출력
		for (int dan = 1; dan <= 9; dan++) {
			for (int i = 2; i <= 9; i++) {
				System.out.printf("%d  X %d = %2d \t", i, dan, dan * i);
			} // for문 종료
			System.out.println("\n");
		} // dan for문
	}// main 종료
}// class 종료