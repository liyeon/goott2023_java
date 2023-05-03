package com.tech.w01;

public class RegulerEmployee extends Employee {
	private int bonus;

	public RegulerEmployee(String empno, String ename, int pay, int bonus) {
		super(empno, ename, pay);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public double getMonthPay() {
		return 0;
	}
}// class