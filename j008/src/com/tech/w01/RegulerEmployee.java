package com.tech.w01;

public class RegulerEmployee extends Employee {
	private int bonus;

	public RegulerEmployee(String empno, String ename, int pay, int bonus) {
		super(empno, ename, pay);
		this.bonus = bonus;
	}

	@Override
	public double getMonthPay() {
		//한달 급여
		float monthPay=getPay()/12+bonus/12;
		return monthPay;
	}
	
	@Override
	public String toString() {
		return super.toString()+" : "+bonus;
	}
	
}// class