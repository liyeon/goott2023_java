package com.kiosk.page;

public class CModel {
	String cName;
	String cPrice;

	public CModel() {
	}

	public CModel(String cName, String cPrice) {
		this.cName = cName;
		this.cPrice = cPrice;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPrice() {
		return cPrice;
	}

	public void setcPrice(String cPrice) {
		this.cPrice = cPrice;
	}

}// class