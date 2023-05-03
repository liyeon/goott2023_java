package com.tech.w02abs;

public abstract class Employee {
	private String empno;// 사번
	private String ename;// 이름
	private int pay;// 급여
	//추상메소드
	//추상메소드가 존재하면 그 클래스는 추상 클래스가 된다. 
	public abstract void getMonthPay();
	public abstract void getMonthPay2();
	public abstract void getMonthPay3();
	//일반 메소드 
	public void ppp() {
		
	}
}// class