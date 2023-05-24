package com.tech.w03Mission;

import java.util.Arrays;

public class DiceCountExam {
	public static void main(String[] args) {

		// 주사위를 10000번 던져서 1의 몇회 2의 몇회
		int size = 6;
		int[] dice = new int[size];
		for (int i = 0; i < 10000; i++)
			dice[(int) (Math.random() * 6)]++;

		for (int i = 0; i < size; i++)
			System.out.println("[ "+(i + 1) + " ] [ " + dice[i] + " ]");

		// =================강사님
		for (int i = 0; i < 10000; i++) {
			++dice[(int) (Math.random() * 6)];
//			switch (dice[i]) {
//			case 0:++dice[0];break;
//			case 1:++dice[1];break;
//			case 2:++dice[2];break;
//			case 3:++dice[3];break;
//			case 4:++dice[4];break;
//			case 5:++dice[5];break;
//			default:break;
//			}// switch
		} // for
		System.out.println(Arrays.toString(dice));
	}// main
}// class