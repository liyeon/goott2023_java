package com.tech.w09.mission;

import java.util.Scanner;

public class JumpTest {

	public static void main(String[] args) {
		ItemTrans tr = new ItemTrans();

		// 점프 : 1000
		// 더블 점프 : 3000
		// 적군 킬 : 5000

		// 메인에서 결과값 출력
		Scanner s = new Scanner(System.in);
		System.out.println("점프 | 더블점프 | 적군킬");
		for (int i = 0; i < 5; i++) {
			System.out.print("스킬입력 >>");
			String str = s.next();
			tr.item(str);
		}
		System.out.println("최종 포인트 : " + tr.getTotal());
		// 포인트 : 1000
		// 포인트 : 3000
		// 포인트 : 5000
		// 최종포인트 : 9000
		s.close();
	}// main

}// class