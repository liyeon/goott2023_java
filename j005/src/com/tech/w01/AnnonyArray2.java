package com.tech.w01;

public class AnnonyArray2 {
	public static void main(String[] args) {
		//익명 배열
		//사용되는 곳이 한차례일때 사용 할 수 있다. ( 재사용 목적이 없을 때 ) 
		System.out.println("sum : "+sum(new int[] {10,20,30,40,50}));
		
		
	}//main
	
	// 메소드 생성
	private static int sum(int[] arrs) {
		int total=0;
		for (int i = 0; i < arrs.length; i++) {
			total+=arrs[i];
		}
		return total;
	}
}//class