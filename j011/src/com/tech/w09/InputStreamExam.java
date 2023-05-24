package com.tech.w09;

import java.io.IOException;

public class InputStreamExam {

	public static void main(String[] args) throws IOException {//입출력예외
		//throws
		System.out.println("String 입력");
		int r=0;
		//-1 ( 입력값이 없을 때 ) 까지 돌아라
		while((r=System.in.read())!=1) {//문자 단위로 읽어옴
			System.out.print("입력값 = ");
			if(r!=10&&r!=13) {//엔터값
				System.out.write(r);
			}//if
			System.out.println("의 아스키코드값 : "+r);
		}//while
		System.out.println("ENDDDDDDDDDDDDDDDDDD");
	}//main
}//class