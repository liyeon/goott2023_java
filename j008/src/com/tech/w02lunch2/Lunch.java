package com.tech.w02lunch2;

public abstract class Lunch {
	// 메뉴이름, 가격, 갯수, 할인율 전달
	protected String fmenu;
	protected int fprice;
	protected int personCnt;

	public Lunch() {}

	public Lunch(String fmenu, int fprice, int personCnt) {
		this.fmenu = fmenu;
		this.fprice = fprice;
		this.personCnt = personCnt;
	}

	public abstract double getTotal();

	@Override
	public String toString() {
		return "메뉴 : " + fmenu + " 금액 :  " + fprice + "원 갯수 :  " + personCnt;
	}
}// class