package com.tech.w02Lamda;

interface Bank {
	void save(int money);// 추상메소드
}

class Customer {
	public void deposit(Bank saveMoney) {
		saveMoney.save(1000);
	}// deposit

}// class

public class LamdaTest1 {

	public static void main(String[] args) {
		Customer customer = new Customer();
		// 람다를 사용하지 않을 때
		customer.deposit(new Bank() {
			@Override
			public void save(int money) {
				System.out.println("입금액 : " + money);
			}
		});

		System.out.println("=============");

		// 람다식을 사용한 표현 방법
		customer.deposit((int money) -> System.out.println("1번 입금액 : " + money + "람다식"));

		// 람다식을 사용한 표현 방법2 타입 생략
		customer.deposit((money) -> System.out.println("2번 입금액 : " + money + "람다식"));
		// 람다식을 사용한 표현 방법3 ()생략 가능
		customer.deposit(money -> System.out.println("2번 입금액 : " + money + "람다식"));

	}// main

}// class