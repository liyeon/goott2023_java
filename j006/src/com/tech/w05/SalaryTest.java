package com.tech.w05;

public class SalaryTest {
	public static void main(String[] args) {
		/*
		 * 급여 명세서 작성
		 * 조건 1) 기본급여 1,500,000원, 수당 55,000원
		 * 세금기본급의 10%
		 * 
		 * 조건 2) 실수령액 = 기본급 + 수당 -세금
		 */
		Salary sa =new Salary();
		int gibon=2000000;
		int sudang=1000000;
		double tot=sa.getSalary(gibon,sudang);
		System.out.println("실수령액 출력 : "+tot);
	}//main
}//