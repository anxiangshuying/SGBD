package com.polytech.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class EnseignantLayout extends JFrame implements ActionListener{
	private JMenuItem i1, i2, i3, i5;
	private JPanel panel;
	
	public EnseignantLayout () {
		super("Enseignant");
		setSize(500, 600);// 400 width and 500 height
//		setLayout(null);// using no layout managers
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("Bourse");
		i1=new JMenuItem("Voir les bourses");  
        i2=new JMenuItem("Évaluer les canditatures");
        i1.addActionListener(this);
        i2.addActionListener(this);
        menu1.add(i1); menu1.add(i2);
        
        JMenu menu2 = new JMenu("Mon compte");
        i3=new JMenuItem("Informations personnelles");
        i5=new JMenuItem("Se déconnecter");
        i3.addActionListener(this);
        i5.addActionListener(this);
        menu2.add(i3);menu2.add(i5);
        
		mb.add(menu1);mb.add(menu2);
		setJMenuBar(mb);
		
		panel = new JPanel();
		panel.add(new CMainView());
		add(panel,"Center");
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {    
		if(e.getSource() == i2) {
			System.out.println("change panel to evaluate candidates");
			EvaluateCandidate sc = new EvaluateCandidate();
			panel.removeAll();
			panel.add("new" , sc);
			panel.validate();
			repaint();
		}
		
		setVisible(true);
	} 
	
	public static void main(String[] args) {
		EnseignantLayout el = new EnseignantLayout();
	}

}
