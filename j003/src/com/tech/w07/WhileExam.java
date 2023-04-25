package com.tech.w07;

public class WhileExam {

	public static void main(String[] args) {
//1~10 합계
		int i=1;
		int sum =0;
		while(i<=10) {
			System.out.println("HELLO 스톱"+i);
			sum=sum+i;
			i++;
		}//while 종료
		System.out.println("sum:"+sum);
	}//main 종료

}//class 종료