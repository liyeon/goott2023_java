package com.tech.w10;

public class SchoolTest extends School{
	public static void main(String[] args) {
		//~객체 생성~
		SchoolTest st = new SchoolTest();
		st.doStudy();
		System.out.println("=========================");
		st.superCall();
	}//main
	
	public void superCall() {
		System.out.println("this call");
		super.doStudy();//부모
		this.doStudy();//지금 클래스
		
	}
	public void doStudy() {
		System.out.println("자식 등교시간 조정");
	}//method
}//class