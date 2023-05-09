package com.tech.w05.mission;

public abstract class Trans {
	private int person;
	private int distance;
	
	public Trans() {}
	
	// 인원 거리 단가
	public Trans(int person, int distance) {
		this.person=person;
		this.distance=distance;
	}
	
	public int getPerson() {
		return person;
	}

	public int getDistance() {
		return distance;
	}

	public abstract int getCharge();
	
	@Override
	public String toString() {
		return "인원 : "+getPerson()+"명 | 거리 : "+getDistance() ;
	}
}//class