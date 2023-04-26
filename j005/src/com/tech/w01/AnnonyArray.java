package com.tech.w01;

import java.util.Arrays;

public class AnnonyArray {
	public static void main(String[] args) {
		int[] aa = {1,2,3,4,5};
		System.out.println(Arrays.toString(aa));
		//익명 배열
		//사용되는 곳이 한차례일때 사용 할 수 있다. ( 재사용 목적이 없을 때 ) 
		System.out.println(Arrays.toString(new int[] {10,20,30,40,50}));
	}//main
}//class