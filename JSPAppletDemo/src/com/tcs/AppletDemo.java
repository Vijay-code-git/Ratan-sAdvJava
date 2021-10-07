package com.tcs;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class AppletDemo extends Applet{
	String msg1, msg2;
	
	public void paint(Graphics g) {
		//reading the input message store into variables
		msg1 = getParameter("message1");
		msg2 = getParameter("message2");
		
		//set the font size & style
		Font f = new Font("arial",Font.BOLD,40);
		g.setFont(f);
		this.setBackground(Color.blue);
		this.setBackground(Color.white);
		
		//to print the message in applet
		g.drawString(msg1, 150, 70);
		g.drawString(msg2, 200, 100);
	}
}
