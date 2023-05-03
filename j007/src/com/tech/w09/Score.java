package com.tech.w09;

public class Score {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double total;
	private double avg;

	public Score() {}

	public Score(String name, int kor, int eng, int math) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		this.total=kor+eng+math;
		this.avg=total/3;
	}
	public String getName() {
		return name;
	}
	public double getTotal() {
		return total;
	}

	public double getAvg() {
		return avg;
	}

	public int getMath() {
		return math;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

}// class