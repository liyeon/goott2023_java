package com.tech.w01crypt;

public class CryptoTest {
	public static void main(String[] args) throws Exception {
		String password = "123456";
		//되돌릴수없음
		System.out.println("단방향 암호화");
		String key = CryptoUtil.sha512(password);
		System.out.println("sha512로 변환된 값 : " + key);

		System.out.println("양방향 암호화");
		//키값과 조합하면 원래 비밀번호를 얻어낼수있음
		String key2 = "1kjkjkjk$%!@#@#@#%ohhkkhkhk9999";
//		String encryStr = CryptoUtil.encryptAES256(password, key2);
		String encryStr = CryptoUtil.encryptAES256(password, key);
		System.out.println("비밀번호 : "+password);
		System.out.println("비밀번호 2차 암호화 : "+encryStr);
		//복호화
		System.out.println("복호화 처리");
		String decryptStr = CryptoUtil.decryptAES256(encryStr, key);
		System.out.println("복호화된 데이터 : "+decryptStr);
	}// main
}// class