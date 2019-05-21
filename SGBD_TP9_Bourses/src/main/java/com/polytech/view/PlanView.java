package com.polytech.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.controller.SessionController;
import com.polytech.model.Plan;

public class PlanView extends JPanel {
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public PlanView() {
		super();
		
		String[] columnNames = {"credits","nom","volume"};// 定义表格列名数组 
		List<Plan> list= new ArrayList<Plan>(); 
		list = SessionController.getPlanController().selectAll();
		Object[][] obj = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++)  
        {  
            for (int j = 0; j < 3; j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[i][j] = list.get(i).getCredits();  
                    break;  
                case 1:  
                    obj[i][j] = list.get(i).getNom();  
                    break;  
                case 2:  
                	obj[i][j] = list.get(i).getVolumeHoraire();
                    break;  
                }  
            }  
        }  
		JTable table = new JTable(obj,columnNames); 
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public static void start() {
		PlanView table = new PlanView();
		table.setVisible(true);
		}
}
