package com.tech.w01;

public class EmployeeTest {

	public static void main(String[] args) {
		//사번
		//이름
		//연봉
		//보너스 등등 내용 전달하고 급여 산출
		Employee emp1 = new RegulerEmployee("E001", "홍홍동", 3000, 500);
		emp1.getMonthPay();
		
	}//main

}//class