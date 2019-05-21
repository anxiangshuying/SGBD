package com.polytech.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import com.polytech.controller.BourseController;
import com.polytech.controller.SessionController;
import com.polytech.model.Bourse;  

public class SelectBourse extends JPanel implements ActionListener{

	JTextField jtf;  
	JTextArea jta;  
	JButton appliquer;  
	JTable jtb;
	JScrollPane jspTable;
	List<Bourse> bourses;
	  
	/////////////////////////////////  
	public SelectBourse(String path){

		jtf = new JTextField();
		jtf.setText("Toutes les bourses:");
		jtf.setEditable(false);
		jta = new JTextArea(5,30);
		
		appliquer = new JButton("Appliquer pour la bourse sélectionnée");
		appliquer.addActionListener(this); 
	  
		showFiles();
	  
		setLayout(new BorderLayout());  
		add(jtf,BorderLayout.NORTH);
		add(jspTable,BorderLayout.CENTER);  
		add(appliquer,BorderLayout.SOUTH);  
	  
		jtf.addActionListener(this);
	}  
	///////////////////////////////  
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == appliquer) {
			String idBourse = (String) jtb.getValueAt(jtb.getSelectedRow(), 0);
			//用户已经点了申请按钮，在这里应该加入插入数据库的函数，他选择的奖学金id是idBourse
			JOptionPane.showMessageDialog(this,"Vous avez postulé pour la bourse ID " + idBourse);
		}
	}  

	////////////////////////////////  
	public void showFiles(){ 
		bourses = SessionController.getBourseController().selectAll();
	  
		if(bourses.isEmpty()) {
			System.out.println("Empty bourses.");
			return;
		}
	  
		System.out.println("Number of bourses: " + bourses.size());
		int fileCounter = 0;
		
		jtb = new JTable(new MyTableModel(bourses.size()));
		for(Bourse b : bourses) {
			jtb.setValueAt(Integer.toString(b.getId()), fileCounter, 0);
			jtb.setValueAt(b.getDestination(), fileCounter, 1);
			jtb.setValueAt(Integer.toString(b.getNumbrePoste()), fileCounter, 2);
			jtb.setValueAt(false, fileCounter, 3);
			fileCounter++;
		}
		
		jtb.getSelectionModel().addListSelectionListener(new RowListener());
		jtb.setRowSelectionAllowed(true);
		jtb.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);
		jspTable = new JScrollPane(jtb);  
		setVisible(false);  
		add(jspTable,BorderLayout.CENTER);  
		setVisible(true);  
	}

	private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            System.out.println("Row selection");
            for(int row = 0; row < jtb.getRowCount(); row++) {
            	if(row != jtb.getSelectedRow())
            		jtb.setValueAt(false, row, 3);
            }
        }
    }

	//以下内部类是为了控制表格的显示格式
	class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Id",
                                        "Destination",
                                        "NumbrePoste",
                                        "Appliquer"};
        private Object[][]data = new Object[1][4];
        
        public MyTableModel(int Rows) {
        	data = new Object[Rows][4];
        }
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 3) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }

    }
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new SelectBourse("1"),"Center");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		jf.setSize(500,600);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);  
	}
}
