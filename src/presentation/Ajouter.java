package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Data.StockMnp;
import Data.stock;
import models.Categorie;
import models.Product;

public class Ajouter extends JFrame{ 
	JPanel panel1 = new JPanel(new FlowLayout()) ;
	JLabel label1 = new JLabel("Product Name") ;
	JTextField tlabel1 = new JTextField(5) ; 
	JButton Retour = new JButton("Retour");	

	JLabel label2 = new JLabel("Price") ;
	JTextField tlabel2 = new JTextField(5) ; 

	JLabel label3 = new JLabel("Qunatity") ;
	JTextField tlabel3 = new JTextField(5) ; 
	JLabel label4 = new JLabel("Categorie") ;
	JComboBox <String> combo1 = new JComboBox<>(new String[] {"Citadine","Berline","Monospace","Coupe"}) ;
    JButton ajouter = new JButton ("Ajouter") ; 
    JButton reset   = new JButton ("Reset") ; 

    TabelM me = new TabelM() ; 
	JTable tabel = new JTable (me) ; 
	JScrollPane jsp = new JScrollPane(tabel) ; 
	
	JPanel panel2 = new JPanel(new GridLayout(1,5,5,5)) ; 
	JButton quit = new JButton("Quit");	
	
	public Ajouter() {
		stock  s = new StockMnp () ; 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setSize(800, 300);
		
		panel1.add(label1) ; 
		panel1.add(tlabel1); 
		panel1.add(label2) ; 
		panel1.add(tlabel2) ;
		panel1.add(label3) ; 
		panel1.add(tlabel3) ; 
		panel1.add(label4) ; 
		panel1.add(combo1); 
		panel1.add(ajouter); 
		panel1.add(reset); 
		this.add(panel1,BorderLayout.NORTH ) ; 
		me.chargerTable(s.getAllProduct()) ; 
		this.add(jsp ,BorderLayout.CENTER);
		panel2.add(quit) ;
		panel2.add(Retour); 

		this.add(panel2,BorderLayout.SOUTH) ; 
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("im here");

				if(tlabel1.getText().equals("")|| tlabel2.getText().equals("") ||  tlabel3.getText().equals("")) {
				JOptionPane.showMessageDialog(Ajouter.this, "Erreur De Saisie");
				System.out.println("im here");
				}
				else { 
				String cat = (String)combo1.getSelectedItem(); 
				int idCat ; 
				Categorie c = null ; 
				switch (cat) {
				case "Citadine" :{
					 c = new Categorie (1 ,"Citadine" ) ; break ; 
				}
				case "Berline" :{
					 c = new Categorie (2 ,"Berline" ); break ; 
				}
				case "Monospace" :{
					 c = new Categorie (3 ,"Monospace" ) ;  break ; 
				}
				case "Coupe" :{
					 c = new Categorie (4 ,"Coupe" ) ;break ; 
				}}
			
				s.addProduit(new Product(tlabel1.getText() , Double.parseDouble(tlabel2.getText()), Integer.parseInt(tlabel3.getText()) , c ));
				me.chargerTable(s.getAllProduct());
				}}});
	   	Retour.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Home () ; 
					dispose () ; 
				}}); 
	   	quit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						 
						dispose () ; 
					}});

	}
}
