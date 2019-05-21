package com.polytech.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.polytech.app.DataInit;
import com.polytech.controller.SessionController;

public class Login extends JFrame implements ActionListener{
	private static int count = 0;
	private static boolean error = false;
	private static JButton bt1;// Login
	private static JTextField jtext1;// Username
	private static JPasswordField jtext2;// Password
	private static JLabel jl_admin;
	private static JLabel jl_password;
	private static JLabel jl_identity;
	private static JLabel jl_prompt;
	private static JRadioButton r1, r2, r3;

	public Login() {// init
		super("Login Eramus");
		setSize(400, 250);

		addUsernamePassword();
		addButtonGroup();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}

	private void addButtonGroup() {
		jl_identity = new JLabel("Veuillez choisir votre identity:");
		jl_identity.setBounds(20, 10, 300, 20);
		
		r1=new JRadioButton("Candidature");
		r2=new JRadioButton("Enseignant");
		r3=new JRadioButton("Administrateur");
		r1.setBounds(20,35,100,20);    
		r2.setBounds(120,35,100,20);    
		r3.setBounds(220,35,110,20);
		ButtonGroup bg=new ButtonGroup();
		r1.setSelected(true);
		bg.add(r1);bg.add(r2);bg.add(r3);
		
		jl_prompt = new JLabel("Welcom to Erasmus");
		jl_prompt.setForeground(Color.orange);
		jl_prompt.setBounds(20, 60, 380, 20);
		
		add(r1);
		add(r2);
		add(r3);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		add(jl_identity);
		add(jl_prompt);
	}
	
	private void addUsernamePassword() {
		jl_admin = new JLabel("Username");
		jl_admin.setBounds(90, 90, 60, 20);// x axis, y axis, width, height

		jl_password = new JLabel("Password");
		jl_password.setBounds(90, 120, 60, 20);
				
		jtext1 = new JTextField("erasmus");
		jtext1.setBounds(190, 90, 150, 20);

		jtext2 = new JPasswordField("123456");
		jtext2.setBounds(190, 120, 150, 20);
		
		bt1 = new JButton("Login");
		bt1.setBounds(90, 170, 100, 20);
		
		add(jtext1);
		add(jtext2);

		add(jl_admin);
		add(jl_password);
		bt1.addActionListener(this);
		add(bt1);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == r1) {
			jl_prompt.setText("Les candidatures");
			repaint();
		}else if(e.getSource() == r2) {
			jl_prompt.setText("Evaluer les Candidatures");
			repaint();
		}else if(e.getSource() == r3) {
			jl_prompt.setText("Le responsable local de la convention Eramus");
			repaint();
		}else if(e.getSource() == bt1) {
			String username = jtext1.getText();
			String password = jtext2.getText();
			System.out.println("username: " + username);
			System.out.println("Password: " + password);

			if(r1.isSelected()) {//login as a candidate
				if (SessionController.getUserController().verifyUserPsd(username, password)) {
					error = false;
					CandidatureLayout ml = new CandidatureLayout();// change fram
					dispose();// Destroy the interface
				} else {
					error = true;
				}
			}else if(r2.isSelected()){//login as a teacher
				if (SessionController.getUserController().verifyUserPsd(username, password)) {
					error = false;
					CandidatureLayout ml = new CandidatureLayout();// change fram
					dispose();// Destroy the interface
				} else {
					error = true;
				}
			}else {//login as the admin
				
			}

			if(error) {
				count++;
				System.out.println("error");
				JOptionPane.showMessageDialog(this,"Votre nom d'utilisateur ou mot de passe est incorrect.");
			}
			
			if (count == 3) {
				JOptionPane.showMessageDialog(this,"Vous avez commis une erreur trois fois.");
				dispose();
			}

		}
	}
	public static void main(String[] args) {
		DataInit.init();
		Login login = new Login();
	}
}
