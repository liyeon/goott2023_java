package com.tech.w07;

public class DoWhileExam {
	public static void main(String[] args) {
		int i=1;
		int sum=0;
		//최소 한번은 꼭 실행하고 싶을 때 사용한다.
		//최초의 한번은 do~while 두 문장이 모두 출력된다.
		do {
			// 값이 같지 않더라도 여기를 실행함ㅇ
			//여기를 먼저 실행을 하고 while값을 실행한다.
			System.out.println(i+"ㄴㅇㄹㄴㅇㄹ");
			sum=sum+i;
			i++;
		} while (i<=10);
		System.out.println("sum : "+sum);
	}//
}//