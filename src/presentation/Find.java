package presentation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Data.* ;
import models.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
public class Find extends JFrame {
	JPanel panel1 = new JPanel() ; 
	JPanel panel11 = new JPanel(new GridLayout(3,4,20,20)) ;
	
	JTextField rech = new JTextField(10) ; 
	JButton recch = new JButton("Recherche");	
	
	JLabel label4 = new JLabel("Categorie") ;
	JComboBox <String> combo1 = new JComboBox<>(new String[] {"ALL","Citadine","Berline","Monospace","Coupe"}) ;
    
	JLabel label7 = new JLabel("Sort By Price ") ;
	JComboBox <String> combo2  = new JComboBox<>(new String[] {"Default" , "LowToHigh" , "HighToLow"}) ; 
	JLabel label8 = new JLabel() ; 

	JPanel panel2 = new JPanel() ; 
	JPanel panel22 = new JPanel(new GridLayout(1,5,5,5)) ; 
	JButton delete = new JButton("delete");	
	JButton Retour = new JButton("Retour");	
	JButton quit = new JButton("Quit");	
	 
	TabelM me = new TabelM() ; 
	JTable tabel = new JTable (me) ; 
	JScrollPane jsp = new JScrollPane(tabel) ; 
	
	JPanel label111 = new JPanel() ;
	JPanel label222 = new JPanel() ;
	JPanel label333 = new JPanel() ;
	JPanel label444 = new JPanel() ;

public Find () {
	stock  s = new StockMnp () ; 
	this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
	this.setSize(800, 300);

	panel1.add(rech) ; 
	panel1.add(recch) ; 
	panel1.add(label4) ;
	panel1.add(combo1) ; 
	panel1.add(label7) ; 
	panel1.add(combo2) ; 
	panel1.add(label8) ; 
	this.add(panel1,BorderLayout.NORTH ) ; 
	me.chargerTable(s.getAllProduct()) ; 
	this.add(jsp ,BorderLayout.CENTER);
	panel2.add(delete) ; 
	panel2.add(Retour); 
	panel2.add(quit) ;
	this.add(panel2,BorderLayout.SOUTH) ; 
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setVisible(true);
	
	
	recch.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			List<Product> liste = s.getAllProductPMC(rech.getText()) ;
			me.chargerTable(liste);
		}
		
	});
	combo1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cat = (String)combo1.getSelectedItem(); 
			switch (cat) {
			case "Citadine" :{
				List<Product> liste = s.getAllProductByCat(1) ;
				me.chargerTable(liste); break ; 
			}
			case "Berline" :{
				List<Product> liste = s.getAllProductByCat(2)  ;
				me.chargerTable(liste); break ; 
			}
			case "Monospace" :{
				List<Product> liste = s.getAllProductByCat(3)  ;
				me.chargerTable(liste); break ; 
			}
			case "Coupe" :{
				List<Product> liste = s.getAllProductByCat(4) ;
				me.chargerTable(liste);break ; 
			}
			case"ALL":{
				List<Product> liste = s.getAllProduct() ;
				me.chargerTable(liste);break ; 
			}
			}
			
		}});
	combo2.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sort = (String)combo2.getSelectedItem(); 
					switch (sort) {
					case "LowToHigh" :{
						List<Product> liste = s.SortByPriceLowToHigh () ;
						me.chargerTable(liste);break ; 
					}
					case"HighToLow":{
						List<Product> liste = s.SortByPriceHighToLow () ;
						me.chargerTable(liste);break ; 
					}
					case"Default":{
						List<Product> liste = s.getAllProduct() ;
						me.chargerTable(liste);break ; 
					}
					}
				}
		
			});
   	Retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Home () ; 
				dispose () ; 
			}}); 
  
	
}}

