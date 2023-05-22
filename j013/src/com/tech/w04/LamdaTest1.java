package com.tech.w04;

interface Bank {
	void save(int bunho, int money);// 추상메소드
}

interface Card {
	void save(String name, int money);// 추상메소드
}

class Customer {
	public void deposit(Bank saveMoney) {
		saveMoney.save(1, 1000);
	}// deposit

	public void deposit(Card saveMoney) {
		saveMoney.save("hong", 2000);
	}
}// class

public class LamdaTest1 {

	public static void main(String[] args) {
		Customer customer = new Customer();
		// 람다를 사용하지 않을 때
		customer.deposit(new Bank() {
			@Override
			public void save(int bunho, int money) {
				System.out.println(bunho + "번 입금액 : " + money);
			}
		});
		customer.deposit(new Card() {
			@Override
			public void save(String name, int money) {
				System.out.println(name + "번 입금액 : " + money);
			}
		});// Card
		System.out.println("=============");

		// 람다식을 사용한 표현 방법
		customer.deposit((String a, int b) -> System.out.println(a + "번 입금액 : " + b + " 람다식"));
		customer.deposit((int a, int b) -> System.out.println(a + "번 입금액 : " + b + " 람다식"));

		// 인터페이스가 여러개일때는 타입 생략 불가
		// 람다식을 사용한 표현 방법2 타입 생략
//		customer.deposit((a, b) -> System.out.println(a + "번 입금액 : " + b + " 람다식"));
		// 람다식을 사용한 표현 방법3 ()매개변수가 두개 이상이면 생략 불가
//		customer.deposit(a,b -> System.out.println("2번 입금액 : " + a + "람다식"));
	}// main

}// class