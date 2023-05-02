package com.tech.w05;

import java.util.Scanner;

public class PaintTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		OilPaint oi = new OilPaint();
		OrientPaint or = new OrientPaint();
		WaterPaint wa = new WaterPaint();
		
		boolean flag = true;
		while (flag) {
			System.out.println("1 : 오일, 2 : 동양화, 3 : 수채화, 0 : 종료");
			System.out.print("작업을 선택해주세요 >>");
			int num = s.nextInt();
			switch (num) {
			case 1:
				oi.oilPaint();
				break;
			case 2:
				or.oriPaint();
				break;
			case 3:
				wa.watPaint();
				break;
			case 0:
				flag = false;
				System.out.println("작업을 종료합니다.");
				break;
			default:
				System.out.println("작업이 없습니다.");
				break;
			}//switch~case 
			System.out.println("\n=========================\n");
		}//while

	}// main
}// class