package com.tech.w05;

public class BreakExam {

	public static void main(String[] args) {
		for (int i=0; i<=10; i++) {
			System.out.println(i);
			if(i==5) {
				break;//i가 5면 빠져나오기 
			}
		}//반복문 종료
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				if (i==3) {
					break;// break 문에서 가까운 반복문만 탈출
				}
				System.out.println("i : "+i+" j : "+j);
			}// 여기로 빠져나옴
		}//반복문 종료
//		
		gotolabel:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				if (i==3) {
//					break;
					break gotolabel;
				}
				System.out.println("i : "+i+" j : "+j);
			}// 여기로 빠져나옴
		}//반복문 종료
	}// main 종료
}//class 종료