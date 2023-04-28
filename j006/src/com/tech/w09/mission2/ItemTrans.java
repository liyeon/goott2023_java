package com.tech.w09.mission2;

public class ItemTrans {
	private int point;
	private int total;

	public void getItem(String skill) {
		if (skill.equals("점프")) {
			point = 1000;
		} else if (skill.equals("더블점프")) {
			point = 3000;
		} else if (skill.equals("적군킬")) {
			point = 5000;
		}
		total += point;
	}

	public int getPoint() {
		return point;
	}

	public int getTotal() {
		return total;
	}

}// class