package com.tech.w09.mission2;

public class JumpTest {

	public static void main(String[] args) {
		ItemTrans its = new ItemTrans();

		// 점프 : 1000
		// 더블 점프 : 3000
		// 적군 킬 : 5000

		// 메인에서 결과값 출력
		its.getItem("점프");its.getItem("점프");its.getItem("점프");
		System.out.println("점프의 포인트 : "+its.getPoint());
		its.getItem("더블점프");
		System.out.println("더블점프의 포인트 : "+its.getPoint());
		its.getItem("적군킬");
		System.out.println("적군킬의 포인트 : "+its.getPoint());
		
		System.out.println("최종 포인트 : "+its.getTotal());
	}// main

}// class