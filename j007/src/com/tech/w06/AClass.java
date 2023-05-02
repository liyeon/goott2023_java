package com.tech.w06;

public class AClass {
	private int i = 1;
	int k=2;//default
	public int p=3;
	protected int p3 = 4;
	
	
	private void accessVal() {
		AClass mine = new AClass();
		System.out.println(mine.i);
	}// method

}// class