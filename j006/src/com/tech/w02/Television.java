package com.tech.w02;

public class Television {
	//접근제어자
	public int channel; //private이 클래스에서만 접근 가능
	public int volumn;
	public boolean onOff;
	public static void main(String[] args) {
		//지역변수는 수동으로 초기화 필요
		int num=0;
		boolean bool;
		
		//객체 생성
		Television tv = new Television();
		System.out.println(tv.channel);
		System.out.println(tv.volumn);
		System.out.println(tv.onOff);
		
		
		//필드 내용 수정하기
		tv.channel=1;
		tv.volumn=9;
		tv.onOff=true;
		
		System.out.println("tv Channel : "+tv.channel);
		System.out.println("tv Volumn : "+tv.volumn);
		
		if(tv.onOff) {
			System.out.println("TV ON!!!!");
		}else {
			System.out.println("TV OFF");
		}
			
	}//main
}//class