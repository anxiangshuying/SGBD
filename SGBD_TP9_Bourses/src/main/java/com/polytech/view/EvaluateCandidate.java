package com.polytech.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;


public class EvaluateCandidate extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl_info;
	private JTable jtb;
	private JScrollPane jspTable;
	private JButton jb_soumettre;
	
	public EvaluateCandidate() {
		jl_info = new JLabel("Vous avez n étudiants qui ont besoin de marquer:");
		
		jb_soumettre = new JButton("Soumettre les résultats");
		jb_soumettre.addActionListener(this);
		
		showCandidates();
		
		setLayout(new BorderLayout());
		add(jl_info,BorderLayout.NORTH);
		add(jspTable,BorderLayout.CENTER);  
		add(jb_soumettre,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private void showCandidates() {
		//在这里需要查询所有需要这个老师打分的学生,以及申请的哪个奖学金.我没有在controller里找到这个功能
		//然后类似SoummettreCandidature类中，填满jtb
		jtb = new JTable(new MyTableModel(2));
		jspTable = new JScrollPane(jtb);
		add(jspTable,BorderLayout.CENTER);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb_soumettre) {
			
			for(int row = 0; row < jtb.getRowCount(); row++) {
            	System.out.println("Score "+ row + " = " + jtb.getValueAt(row, 3));
            }

			//用户已经点了提交按钮，在这里应该加入插入score数据库的函数
			JOptionPane.showMessageDialog(this,"Vous avez soumis les scores");
		}
	}

	class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Bourse",
                                        "Candidature",
                                        "Numéro d'étudiant",
                                        "Score(Veuillez remplir)"};
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
		jf.add(new EvaluateCandidate(),"Center");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		jf.setSize(500,600);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
}
