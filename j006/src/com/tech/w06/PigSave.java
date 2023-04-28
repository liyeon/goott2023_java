package com.tech.w06;

public class PigSave {
	private int total;//getter setter로 불러온다
	
	public void deposit(int amount) {
		System.out.println(amount+"금액 저축");
		total+=amount;//total 에 누적
	}//deposit
	
	//==========getter/setter===========
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	//==========getter/setter===========
	
}//class