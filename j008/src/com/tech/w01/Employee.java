package com.tech.w01;

public class Employee {
	private String empno;// 사번
	private String ename;// 이름
	private int pay;// 급여

	public Employee() {
	}

	public Employee(String empno, String ename, int pay) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.pay = pay;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public double getMonthPay() {
		return 0;
	}
}// class