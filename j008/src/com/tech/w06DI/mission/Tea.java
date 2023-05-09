package com.tech.w06DI.mission;
public class Tea {
	private KoreanTea tea;
	
	public Tea() {}
	
	public Tea(KoreanTea tea) {
		this.tea=tea;
		System.out.println("무슨 차일까");
	}
	
	public void teaType() {
		System.out.println(tea.teaCall());
	}
}//class