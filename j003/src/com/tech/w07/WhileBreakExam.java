package com.tech.w07;

public class WhileBreakExam {
	public static void main(String[] args) {
		gotolabel:
		for(int i=0; i< 5; i++) {
			int j=1;
			while(j<3) {
				if(i==3) {
					//break;
					break gotolabel;
				}//if문 종료
				System.out.println("i : "+i+" j : "+j);
				j++;
			}//while문 종료
		}//for문 종료
	}//main 종료
}//class 종료