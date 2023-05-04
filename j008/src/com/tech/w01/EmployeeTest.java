package com.tech.w01;

public class EmployeeTest {

	public static void main(String[] args) {
		//사번
		//이름
		//연봉
		
		//배열 선언
		Employee[] emps = new Employee[4];
		
		//보너스 등등 내용 전달하고 급여 산출
//		Employee emp1 = new RegulerEmployee("E001", "홍홍동", 3000, 500);
//		Employee emp2 = new TempEmployee("E002","홍길순", 4000,0);
//		Employee emp3 = new PartTimeEmployee("E003","김자바", 50,10);
		
		emps[0] = new RegulerEmployee("E001", "홍홍동", 3000, 500);
		emps[1] = new RegulerEmployee("E002", "홍홍동2", 5000, 1500);
		emps[2] = new TempEmployee("E003","홍길순", 4000,0);
		emps[3] = new PartTimeEmployee("E004","김자바", 50,10);
		
		for (int i = 0; i < emps.length; i++) {
			printPay(emps[i]);
		}
	}//main

	private static void printPay(Employee emp) {
		System.out.println("==========================");
		System.out.println(emp);
		System.out.println("-------------------------");
		System.out.println(emp.getMonthPay());
	}

}//class