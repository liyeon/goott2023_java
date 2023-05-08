package com.tech.w04interface3;

public class PhoneCall extends Phone implements VisualCall, VoiceCall {

	@Override
	public void sendVoicelMsg() {
		System.out.println("음성 메세지 전달");
	}

	@Override
	public void getVoiceMsg() {
		System.out.println("음성 메세지 수신");
	}

	@Override
	public void sendVisualMsg() {
		System.out.println("영상 메세지 전달");
	}

	@Override
	public void getVisualMsg() {
		System.out.println("영상 메세지 수신");
	}
}