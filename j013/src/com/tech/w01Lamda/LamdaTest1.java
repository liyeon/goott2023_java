package com.tech.w01Lamda;

interface Bank {
	int save();// 추상메소드
}

class Customer {
	public void deposit(Bank saveMoney) {
		int rmoney = saveMoney.save();
		System.out.println("money : "+rmoney);
	}// deposit

}// class

public class LamdaTest1 {

	public static void main(String[] args) {
		Customer customer = new Customer();
		// 람다를 사용하지 않을 때
		customer.deposit(new Bank() {
			@Override
			public int save() {
				System.out.println("1번 입금액 1000");
				return 10000;
			}
		});
		
		System.out.println("=============");
		
		//람다식을 사용한 표현 방법
		customer.deposit(()->{
			System.out.println("1번 입금액 1000람다");
			return 2000;
		});
	}// main

}// class