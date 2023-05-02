package com.tech.w11;

public class FinalExam {

	// 사각형
	public static final int RECTANGLE = 1;
	// 삼각형
	public static final int TRIANGLE = 2;

	public double getArea(int type, int w, int h) {
		// 면적계산 리턴

		double area = 0;
		if (type == RECTANGLE) {
			area = (double) w * h;

		} else if (type == TRIANGLE) {
			area = (double) w * h / 2;
		}
		return area;
	}// getArea

}// class