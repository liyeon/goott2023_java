package com.tech.w06;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(5005);
		// 서버 준비
		System.out.println("서버준비");

		// 서버소켓을 통한 accept
		try {
			while (true) {
				Socket socket = ss.accept();
				// 입출력객체
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("홍길동 메세지 전달");
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("서버종료");
			ss.close();
		} // try~catch~finally

	}// main
}// class