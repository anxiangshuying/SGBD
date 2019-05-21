package com.polytech.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.polytech.controller.SessionController;

public class CandidatureView extends JPanel{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the application.
	 */
	public CandidatureView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nom");
		lblNewLabel.setBounds(86, 35, 80, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("prenom");
		lblNewLabel_1.setBounds(86, 80, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("numero");
		lblNewLabel_2.setBounds(86, 135, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("avarageNote");
		lblNewLabel_3.setBounds(86, 197, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(199, 32, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 77, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 132, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(199, 194, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("s'inscrire");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textField.getText();
				String prenom = textField_1.getText();
				String numero = textField_2.getText();
				String average = textField_3.getText();
				Double noteMoyenne = Double.parseDouble(average);
				SessionController.getCandidatureController().insertCandidature(nom, prenom, noteMoyenne, numero);
			}
		});
		btnNewButton_1.setBounds(275, 239, 89, 23);
		contentPane.add(btnNewButton_1);
		
		setLayout(new BorderLayout());
		add(contentPane,BorderLayout.CENTER);
		 
		
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new CandidatureView(),"Center");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		jf.setSize(400,400);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);  
	}
}
