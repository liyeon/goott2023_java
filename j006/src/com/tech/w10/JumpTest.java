package com.tech.w10;

public class JumpTest {

	public static void main(String[] args) {
		ItemTrans its = new ItemTrans();
		// 점프 : 1000
		// 더블 점프 : 3000
		// 적군 킬 : 5000

		int[] rArr = its.getItem();
		System.out.println(rArr[0] + ": 점프 포인트");
		System.out.println(rArr[1] + ": 더블점프 포인트");
		System.out.println(rArr[2] + ": 적군킬 포인트");
		System.out.println("최종 포인트 : " + its.getTotal());
	}// main

}// class