package com.tech.w02;

public class Person {
	//필드 두개
	String name;
	int age;

	public static void main(String[] args) {
		Person person=new Person();
		person.name="길동이";
		person.laugh();//메소드 호출
		person.name="태여니";
		person.laugh();//메소드 호출
		
		//외부 파일 접근
		Television tvP=new Television();
		tvP.onOff=true;
		System.out.println(tvP.onOff);
		
		//======================= 인스턴스
		//설계도면은 같은데 내용물이 다른 객체를 인스턴스라고함
		Television myTv=new Television();
		myTv.channel=7;
		myTv.volumn=9;
		myTv.onOff=true;
		Television yourTv=new Television();
		yourTv.channel=9;
		yourTv.volumn=12;
		yourTv.onOff=true;
	}// main

	public void laugh() {
		System.out.println(name+"가 깔깔거리는중");
	}//laugh
}// class