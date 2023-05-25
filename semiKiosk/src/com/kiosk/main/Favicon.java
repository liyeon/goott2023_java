package com.kiosk.main;

import java.awt.Image;
import java.awt.Toolkit;

public class Favicon {

	public Favicon() {}

	public static Image getFavi() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img= kit.getImage("src\\img\\favi.png");
		return img;
	}
}//