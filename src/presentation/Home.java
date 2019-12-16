package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame{
	JButton recherche = new JButton("Find") ; 
	JButton ajouter = new JButton("Add") ; 
	JButton quitter = new JButton("Quit") ; 
    JPanel  panel1 = new JPanel (new GridLayout(1,3,50,50));
    JPanel  panel2 = new JPanel (); 
    JPanel  panel4 = new JPanel (); 
    JPanel  panel3 = new JPanel (); 
    JPanel  panel5 = new JPanel (); 

    public Home() {
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    	this.setSize(400,150);
    	panel1.add(recherche) ; 
    	panel1.add(ajouter) ;
    	panel1.add(quitter) ;
    	
    	this.add(panel1 , BorderLayout.CENTER);
    	this.add(panel2 , BorderLayout.SOUTH);
    	this.add(panel3 , BorderLayout.NORTH);
    	this.add(panel4 , BorderLayout.EAST);
    	this.add(panel5 , BorderLayout.WEST);
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
    	this.setVisible(true);
    	recherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Find () ; 
				dispose () ; 
			}}); 
       	ajouter.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				// TODO Auto-generated method stub
    				new Ajouter () ; 
    				dispose () ; 
    			}}); 
       quitter.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				// TODO Auto-generated method stub
    				 
    				dispose () ; 
    			}}); 
    }
    

}
