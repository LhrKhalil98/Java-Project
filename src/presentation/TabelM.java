package presentation;
import javax.swing.* ;
import javax.swing.table.AbstractTableModel;
import models.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List ;
public class TabelM  extends AbstractTableModel{
	private List<Product> produits = new ArrayList<>(); 
	private String titre[]= {"id","Produit","Price" ,"Quantity","Categorie"} ; 
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titre.length;
	}
	@Override
	public String getColumnName(int column) {
		return titre[column];
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return produits.size();
	}

	public Object getValueAt(int l, int c) {
		// TODO Auto-generated method stub
		switch(c) {
		case 0:
			return produits.get(l).getIdProduct();
		case 1: 
			return produits.get(l).getNameProduct();
		case 2: 
			return produits.get(l).getPrice(); 
		case 3: 
			return produits.get(l).getPrice();
		case 4: 
			return produits.get(l).getCategorie().getNameCat()	;
		}
		return null;
	}
	
	public void chargerTable(List<Product> liste) {
		produits = liste ; 
		fireTableDataChanged(); 
	}


}
	