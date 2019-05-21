package com.polytech.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CMainView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel text;
	
	public CMainView() {
		 text = new JLabel("Welcome to Erasmus");
		 add(text);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new CMainView());
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		jf.setSize(400,400);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
}
