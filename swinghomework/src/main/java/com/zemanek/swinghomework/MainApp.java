package com.zemanek.swinghomework;

import java.awt.EventQueue;

import com.zemanek.swinghomework.gui.MainFrame;

/**
 * Main class to run the app
 * 
 * @author Petr Zemanek
 *
 */
public class MainApp {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
