package com.tech.w01;

public class SecondClass extends FirstClass{
	@Override
	public void print() {
		System.out.println("Second 밑그림작업");
		super.print();
	}//print override
	
	public void doColor() {
		System.out.println("유화 채색 입힘");
	}//doColor
}//class