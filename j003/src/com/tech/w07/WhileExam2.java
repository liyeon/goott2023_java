package com.tech.w07;

public class WhileExam2 {

	public static void main(String[] args) {
		//while 문장
		//무한루트 주의 조건
		int i=1;
		while(i<10) {
			System.out.println("HELLO 스톱"+i);
			//while을 멈추려면 증감식이 필요하다. 
//			i=i+1;
//			i+=1;
//			i=i*2;
			i*=2;
		}//while 종료
		/*  
		 *  기본형 Primitive type
		 *	byte1
		 *  short2
		 *  int4
		 *  long8
		 *	
		 *	float4
		 *	double8
		 *  char 2
		 *  boolean 1
		 * 
		 * 	진리표
		 * 	or가 참일 때 어떤 상태를
		 * 	입력값 중 하나라도 같으면 true 
		 * 	And가 참일때 어떤상태 입력값
		 *  입력값 모두가 참이여야 결과가 참이다 .
		 */
	}//main 종료

}//class 종료