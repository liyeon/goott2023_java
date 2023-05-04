package com.tech.w01;

public class PartTimeEmployee extends Employee{
	private int workDay;
	public PartTimeEmployee() {
	}

	public PartTimeEmployee(String empno, String ename, int pay, int workDay) {
		super(empno, ename, pay);
		this.workDay=workDay;
	}


	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

	@Override
	public double getMonthPay() {
		float monthPay=getPay()*getWorkDay();
		return monthPay;
	}
	
	@Override
	public String toString() {
		return super.toString()+" : "+getWorkDay();
	}
}//class