package com.polytech.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.polytech.app.DataInit;
import com.polytech.controller.SessionController;
import com.polytech.model.Bourse;

public class BourseView extends JPanel {

	private JFrame frame;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public BourseView() {
		super();
		setBounds(100, 100, 450, 300); 
		String[] columnNames = {"destination","nombrePoste"}; 
		
		List<Bourse> list= new ArrayList<Bourse>(); 
		list = SessionController.getBourseController().selectAll();
		Object[][] obj = new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++)  
        {  
            for (int j = 0; j < 3; j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[i][j] = list.get(i).getDestination();
                    break;  
                case 1:  
                    obj[i][j] = list.get(i).getNumbrePoste(); 
                    break;   
                }  
            }  
        }  
//		// 定义表格数据数组
//		String[][] tableValues = {};
//		for(int i=0;i<list.size();i++){
//			tableValues[0][0] = list.get(0).getCredits();
//			tableValues[0][1] = list.get(1).getNom();
//			int vol = list.get(2).getVolumeHoraire();
//			tableValues[0][2] = String.valueOf(vol);
//		}
		// 创建指定列名和数据的表格 
		JTable table = new JTable(obj,columnNames); 
		// 创建显示表格的滚动面板 
		JScrollPane scrollPane = new JScrollPane(table);
		// 将滚动面板添加到边界布局的中间
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public static void start() {
		BourseView table = new BourseView();
		table.setVisible(true);
		}

}
