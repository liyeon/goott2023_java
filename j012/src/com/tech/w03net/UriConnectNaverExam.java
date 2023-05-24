package com.tech.w03net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UriConnectNaverExam {
	// 네이버 소스 크롤링
	//웹 크롤링
	public static void main(String[] args) throws Exception {//
		URL site = new URL("https://dict.naver.com");
		URLConnection url = site.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream(), "utf-8"));
		String inline;
		// 한줄씩 읽어와서 inline에 넣어준다.
		while ((inline = in.readLine()) != null) {
			System.out.println(inline);
		} // while
		in.close();
	}// main
}// class