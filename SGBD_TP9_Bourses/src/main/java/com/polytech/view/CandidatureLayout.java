package com.polytech.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CandidatureLayout extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem i1, i2, i3, i4, i5,i6;
	private JPanel panel;

	public CandidatureLayout() {
		super("Candidature");
		setSize(500, 600);// 400 width and 500 height
//		setLayout(null);// using no layout managers
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("Bourse");
		i1=new JMenuItem("Améliorer les informations du candidat");  
        i2=new JMenuItem("Interroger ma scores");
        i6=new JMenuItem("Voir et demander des bourses");
        i1.addActionListener(this);
        i2.addActionListener(this);
        i6.addActionListener(this);
//        menu1.add(i1);
        menu1.add(i2);menu1.add(i6);
        
        JMenu menu2 = new JMenu("Mon compte");
        i3=new JMenuItem("Informations personnelles");  
        i4=new JMenuItem("Plans d'enseignements");
        i5=new JMenuItem("Se deconnecter");
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        menu2.add(i3); 
        menu2.add(i4);
        menu2.add(i5);
        
		mb.add(menu1);mb.add(menu2);
		setJMenuBar(mb);
		
		panel = new JPanel();
		panel.add(new CMainView());
		add(panel,"Center");
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {    
		if(e.getSource() == i1) {
			System.out.println("change panel to soumettre");
			CandidatureView sv = new CandidatureView();
			panel.removeAll();
			panel.add("new" , sv);
			panel.validate();
			repaint();
		}else if (e.getSource() == i2){
			System.out.println("change panel to see scores");
			Scores score = new Scores();
			panel.removeAll();
			panel.add("new" , score);
			panel.validate();
			repaint();
		}else if (e.getSource() == i3){
			System.out.println("change panel to see personal infomation");
			Information info = new Information();
			panel.removeAll();
			panel.add("new" , info);
			panel.validate();
			repaint();
		}else if(e.getSource()  == i4){
			System.out.println("change panel to see the teaching plan");
			PlanView plan = new PlanView();
			panel.removeAll();
			panel.add("new" , plan);
			panel.validate();
			repaint();
		}else if(e.getSource() == i5){
			System.exit(0);
		}else if(e.getSource() == i6){
			System.out.println("change panel to select a bourse");
			SelectBourse sb = new SelectBourse("1");
			panel.removeAll();
			panel.add("new" , sb);
			panel.validate();
			repaint();
		}
		
		setVisible(true);
	} 
	public static void main(String[] args) {
		CandidatureLayout ml = new CandidatureLayout();
	}
}
