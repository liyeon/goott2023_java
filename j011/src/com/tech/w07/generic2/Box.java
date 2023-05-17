package com.tech.w07.generic2;

public class Box<T> {//generic 클래스
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Box() {
	}//constructor
}// class