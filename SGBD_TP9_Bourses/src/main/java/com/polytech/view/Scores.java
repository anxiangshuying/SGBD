package com.polytech.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.polytech.app.DataInit;
import com.polytech.controller.SessionController;
import com.polytech.model.Plan;

public class Scores extends JPanel {
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField jtf;

	/**
	 * Create the frame.
	 */
	public Scores() {
		super();
		
		String[] columnNames = {"ScoreLocal","ScoreEcole","AverageScore"};// 定义表格列名数组 
		List<Double> list1 = new ArrayList<Double>();
//		list1 = SessionController.getScoreController().getNotes(SessionController.getActuelUserId());
		list1 = SessionController.getScoreController().getNotes(2);
		for(double l:list1){
			System.out.println(l);
		}
		double average = 0d;
//		average = SessionController.getCandidatureController().getNoteMoyenne(SessionController.getActuelUserId());
		average = SessionController.getCandidatureController().getNoteMoyenne(2);
		System.out.println(average);
		Object[][] obj = new Object[1][3];
		for (int i = 0; i < 1; i++)  
        {  
            for (int j = 0; j < 3; j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[i][j] = list1.get(0);  
                    break;  
                case 1:  
                    obj[i][j] = list1.get(1); 
                    break;  
                case 2:  
                	obj[i][j] = average;
                    break;  
                }  
            }  
        }
		JTable table = new JTable(obj,columnNames); 
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane, BorderLayout.CENTER);
		
		
	}
	
	public static void start() {
		Scores table = new Scores();
		table.setVisible(true);
		}
}
