package com.tech.w05;


public class ContinueExam {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if(i==5) {// 반복은 계속 되나 정해진 조건의 이후 문장은 실행되지 않는다.
				continue;//정해진 조건에 continue가 만나면 밑으로 내려가지 않고 다시 위로 올라간다. 
			}//조건문 종료 
			System.out.println("현재 i : "+i);
		}//반복문 종료 
	}//main 종료
}//class 종료 