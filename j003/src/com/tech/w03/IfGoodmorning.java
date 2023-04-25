package com.tech.w03;

import java.util.Calendar;
import java.util.Date;

public class IfGoodmorning {

	public static void main(String[] args) {
		//객체 생성 
		Date date = new Date();
		int currHour = date.getHours();//이 메소드를 사용하지 마세요.
		System.out.println(currHour);
		//if 12 보다 작으면 Goodmorning 아니면 Good Evening
		if (currHour<12) {
			System.out.println("GoodMorning");
		}else {
			System.out.println("GoodEvening");
		}
		
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour>12) {
			System.out.println("GoodEvening");
		}else {
			System.out.println("GoodMorning");
		}
	}//

}//