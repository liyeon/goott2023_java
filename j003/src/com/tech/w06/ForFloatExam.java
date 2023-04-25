package com.tech.w06;


public class ForFloatExam {
	public static void main(String[] args) {
//		for (float x = 0.1f; x <1.0f; x=x+0.1f) {
//			System.out.println("print : "+x);
//		}//반복문 종료
		
//		printf
		// .2 = 소수점 둘째자리까지 표현해라 
		for (float x = 0.1f; x <1.0f; x=x+0.1f) {
			System.out.printf("print : %.2f \n",x);
		}//반복문 종료
//		printf2 . 앞의 숫자는 공백을 의미한다.
		for (float x = 0.1f; x <1.0f; x=x+0.1f) {
			System.out.printf("print : %10.2f \n",x);
		}//반복문 종료
		
		int num=100;
		float score=100.0f;
		String string="구디역";
		char ch ='굳';
		
		System.out.printf("num : %d \n", num);
		System.out.printf("c : %c \n", ch);
		System.out.printf("string : %s \n", string);
		
		System.out.println("==============================");
		// % 두개짜리는 단위를 표현하려고 하는거 그 역할에서 빠져나오게 하는거
		System.out.printf("구트는 %s 에 있는 %d%% %c %.1f%% \n", string,num,ch,score);
	}//main 종료
}// class 종료