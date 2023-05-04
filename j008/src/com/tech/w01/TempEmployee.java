package com.tech.w01;

public class TempEmployee extends Employee{
	private int hireyear;
	public TempEmployee() {
	}

	public TempEmployee(String empno, String ename, int pay, int hireyear) {
		super(empno, ename, pay);
		this.hireyear=hireyear;
	}

	public int getHireyear() {
		return hireyear;
	}

	public void setHireyear(int hireyear) {
		this.hireyear = hireyear;
	}

	@Override
	public double getMonthPay() {
		float monthPay=getPay()/12;
		return monthPay;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" : "+getHireyear();
	}
}//class