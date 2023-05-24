package com.tech.w07.generic3;

class OrderVal<K, V> {
	private K key;
	private V value;

	public OrderVal(K key, V value) {
		this.key = key;
		this.value = value;
	}// constructor

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}// class

public class OrderTest {
	public static void main(String[] args) {
		OrderVal<String, Integer> pi = new OrderVal<String, Integer>("myKey", 10000);
		OrderVal<String, String> ps = new OrderVal<String, String>("myKey", "10000원");
		System.out.println(pi.getKey() + ":" + pi.getValue());
		System.out.println(ps.getKey() + ":" + ps.getValue());
	}// main
}// class