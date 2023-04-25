package com.tech.w02;

public class BitLogicalExam {
	public static void main(String[] args) {
		//비트연산
		System.out.println(45 & 25);//& and
		System.out.println(Integer.toBinaryString(45));
		System.out.println(" "+Integer.toBinaryString(25));
		
		System.out.println(45 | 25);//| or
		System.out.println(Integer.toBinaryString(45));
		System.out.println(" "+Integer.toBinaryString(25));
		
		System.out.println(45 ^ 25);//^ 배타적 or 부호가 다를 때 1 같으면 0
		System.out.println(Integer.toBinaryString(45));
		System.out.println(" "+Integer.toBinaryString(25));
	}//
}//