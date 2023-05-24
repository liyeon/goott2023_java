package com.tech.w03Lamda;

interface Bank {
	void save(int bunho, int money);// 추상메소드
}

class Customer {
	public void deposit(Bank saveMoney) {
		saveMoney.save(1, 1000);
	}// deposit

}// class

public class LamdaTest1 {

	public static void main(String[] args) {
		Customer customer = new Customer();
		// 람다를 사용하지 않을 때
		customer.deposit(new Bank() {
			@Override
			public void save(int bunho, int money) {
				System.out.println(bunho + "입금액 : " + money);
			}
		});

		System.out.println("=============");

		// 람다식을 사용한 표현 방법
		customer.deposit((int bunho, int money) -> System.out.println(bunho + "번 입금액 : " + money + " 람다식"));

		// 람다식을 사용한 표현 방법2 타입 생략
		customer.deposit((bunho, money) -> System.out.println(bunho + "번 입금액 : " + money + " 람다식"));
		// 람다식을 사용한 표현 방법3 ()매개변수가 두개 이상이면 생략 불가
//		customer.deposit(bunho,money -> System.out.println("2번 입금액 : " + money + "람다식"));
	}// main

}// class