package com.tech.w09.mission;

public class ItemTrans {
	private int point;
	private int total;

	public void item(String skill) {
		if (skill.equals("점프")) {
			point = 1000;
			System.out.println("+1000 포인트");
		} else if (skill.equals("더블점프")) {
			point = 3000;
			System.out.println("+3000 포인트");
		} else if (skill.equals("적군킬")) {
			point = 5000;
			System.out.println("+5000 포인트");
		}
		total += point;
	}

	public int getTotal() {
		return total;
	}

}// class