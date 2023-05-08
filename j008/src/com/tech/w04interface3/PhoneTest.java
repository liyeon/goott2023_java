package com.tech.w04interface3;

public class PhoneTest {
	public static void main(String[] args) {
		VoiceCall voCall = new PhoneCall();
		VisualCall viCall = new PhoneCall();
		
		voCall.sendVoicelMsg();
		voCall.getVoiceMsg();
		viCall.getVisualMsg();
		viCall.getVisualMsg();
	}//main
}//class