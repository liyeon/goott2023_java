package com.tech.w07chat;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChatServer extends JFrame implements ActionListener {
	JButton btnExit;
	TextArea ta;
	Vector vChatList;
	ServerSocket ss;
	Socket socketClient;

	public ChatServer() {
		setTitle("GUI 채팅 서버 버전 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
//		setBounds(250,250,400,200);

		vChatList = new Vector();
		btnExit = new JButton("서버 종료");
		btnExit.addActionListener(this);

		ta = new TextArea();
		add(ta, BorderLayout.CENTER);
		add(btnExit, BorderLayout.SOUTH);

		setVisible(true);

		chatStart();
	}// constructor

	public void chatStart() {
		// 서버 스타트 시키기
		try {
			ss = new ServerSocket(5011);// 포트번호
			while (true) {
				socketClient = ss.accept();// 클라이언트 접속
				ta.append(socketClient.getInetAddress().getHostAddress() + "접속함\n");// 클라이언트 접속 아이피 알아오기
				ChatHandle threadChat = new ChatHandle(); // 생성자 호출
				vChatList.add(threadChat);// 클라이언트가 접속할때마다 생성됨
				threadChat.start();
			} // while
		} catch (IOException e) {
			e.printStackTrace();
		} // try~catch

	}// chatStart method

	// inner class
	class ChatHandle extends Thread {// 쓰레드 클래스
		BufferedReader br = null;// 입력준비
		PrintWriter pw = null;// 출력준비

		public ChatHandle() {
			try {
				// 입출력 객체 생성
				InputStream is = socketClient.getInputStream();// 입력
				br = new BufferedReader(new InputStreamReader(is));
				OutputStream os = socketClient.getOutputStream();// 출력
				pw = new PrintWriter(new OutputStreamWriter(os));

			} catch (IOException e) {
				e.printStackTrace();
			} // try~catch
		}// constructor

		public void sendAllClient(String msg) {
			// 모든 클라이언트에 메세지 전달
			int size = vChatList.size();// 클라이언트의 갯수
			for (int i = 0; i < size; i++) {
				ChatHandle chr=(ChatHandle) vChatList.elementAt(i);
				chr.pw.println(msg);//메시지 출력
				chr.pw.flush();//즉시 전송
			}//for
		}// method

		@Override
		public void run() {
			try {
				String name = br.readLine();
				sendAllClient(name + "님 께서 새로 입장하셨습니다.");
				while (true) {
					String msg = br.readLine();
					String str = socketClient.getInetAddress().getHostName();// 컴퓨터 이름
					ta.append(msg + "\n");
					if (msg.equals("@@exit")) {
						break;
					} else {
						sendAllClient(name + " : " + msg);
						// 모든 클라이언트에 메세지 전달
					} // if~else
				} // while
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				vChatList.remove(this);
				try {
					br.close();
					pw.close();
					socketClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				} // try~catch
			} // try~finally
		}// run
	}// inner class

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("서버종료");
	}// method override

	public static void main(String[] args) {
		new ChatServer();
	}// main
}// class