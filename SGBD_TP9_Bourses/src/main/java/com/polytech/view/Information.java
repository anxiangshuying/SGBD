package com.polytech.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.polytech.app.DataInit;
import com.polytech.controller.SessionController;
import com.polytech.model.Candidature;
import com.polytech.model.Plan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Information extends JPanel {
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField jtf;

	/**
	 * Create the frame.
	 */
	public Information() {
		super(); 		
		String[] columnNames = {"nom","prenom","numero","noteFinale"}; 
		Candidature candidature = SessionController.getCandidatureController().selectById(2);
		double noteFinale = SessionController.getScoreController().getSumScore(2);
		Object[][] obj = new Object[1][4];
		for (int i = 0; i < 1; i++)  
        {  
            for (int j = 0; j < 4; j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[i][j] = candidature.getNom();  
                    break;  
                case 1:  
                    obj[i][j] = candidature.getPrenom();  
                    break;  
                case 2:  
                	obj[i][j] = candidature.getNumero();
                    break;
                case 3:  
                	obj[i][j] = noteFinale;
                    break;
                }  
            }  
        }  
		JTable table = new JTable(obj,columnNames); 
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public static void start() {
		Information table = new Information();
		table.setVisible(true);
		}
}
