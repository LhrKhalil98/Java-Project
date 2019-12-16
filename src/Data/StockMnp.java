package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import models.*;

public class StockMnp implements stock{
	int idCategorie ; 

	public List <Product> getAllProduct(){
		 Connection cx =  (Connection) SingleConnection.getConnection(); 
	     List <Product> liste = new ArrayList<>();
	     try {
	    	 
 			String query = "SELECT * FROM Produit" ;  
 			PreparedStatement ps =  (PreparedStatement) cx.prepareStatement(query);
 			ResultSet rs = ps.executeQuery(); 
 			while(rs.next()) { 
 				Product p = new Product();
 				p.setIdProduct(rs.getInt(1));
 				p.setNameProduct(rs.getString(2));
 				p.setPrice(rs.getDouble(3));
 				p.setQuantity(rs.getInt(4));
 				idCategorie = rs.getInt(5);
 				String query1 = "SELECT * FROM Categorie WHERE idCategorie=?" ;  
 	 			PreparedStatement ps1 =  (PreparedStatement) cx.prepareStatement(query1);
 	 			ps1.setInt(1, idCategorie);
 	 			ResultSet rs1 = ps1.executeQuery(); 
 	 			while(rs1.next()) {
 	 				Categorie C = new Categorie();
 	 				C.setidCategorie(idCategorie);
 	 				C.setNameCat(rs1.getString(2));
 	 	 			p.setCategorie(C);
 	 			}
 				liste.add(p); 

 			}
	     }
	     catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	     return liste ; 
	     }
	public List <Product> getAllProductByCat(int cat ){
		 Connection cx =  (Connection) SingleConnection.getConnection(); 
	     List <Product> liste = new ArrayList<>();
	     try {
	    	 
			String query = "SELECT * FROM Produit WHERE idCategorie=? " ;  
			PreparedStatement ps =  (PreparedStatement) cx.prepareStatement(query);
 			ps.setInt(1, cat);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) { 
				Product p = new Product();
				p.setIdProduct(rs.getInt(1));
				p.setNameProduct(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setQuantity(rs.getInt(4));
				
				String query1 = "SELECT * FROM Categorie WHERE idCategorie=?" ;  
	 			PreparedStatement ps1 =  (PreparedStatement) cx.prepareStatement(query1);
	 			ps1.setInt(1, cat);
	 			ResultSet rs1 = ps1.executeQuery(); 
	 			while(rs1.next()) {
	 				Categorie C = new Categorie();
	 				C.setidCategorie(cat);
	 				C.setNameCat(rs1.getString(1));
	 	 			p.setCategorie(C);
	 			}
				liste.add(p); 

			}
	     }
	     catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	     return liste ; 
	     }
	public List <Product> getAllProductPMC(String mc ){
		 Connection cx =  (Connection) SingleConnection.getConnection(); 
	     List <Product> liste = new ArrayList<>();
	     try {
	    	 
			String query = "SELECT * FROM Produit WHERE nameProduit  like ?  " ;  
			PreparedStatement ps =  (PreparedStatement) cx.prepareStatement(query);
			ps.setString(1, "%"+mc+"%" );
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) { 
				Product p = new Product();
				p.setIdProduct(rs.getInt(1));
				p.setNameProduct(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setQuantity(rs.getInt(4));
 				idCategorie = rs.getInt(5);

				String query1 = "SELECT * FROM Categorie WHERE idCategorie=?" ;  
	 			PreparedStatement ps1 =  (PreparedStatement) cx.prepareStatement(query1);
	 			ps1.setInt(1, idCategorie);
	 			ResultSet rs1 = ps1.executeQuery(); 
	 			while(rs1.next()) {
	 				Categorie C = new Categorie();
	 				C.setidCategorie(idCategorie);
	 				C.setNameCat(rs1.getString(1));
	 	 			p.setCategorie(C);
	 			}
				liste.add(p); 

			}
	     }
	     catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	     return liste ; 
	}
	public void addProduit(Product p) {
		 Connection cx =  (Connection) SingleConnection.getConnection(); 
		 try {
			 String query1 = "insert into produit(nameProduit,price,quantity,idCategorie) values (?,?,?,?)" ;
			 PreparedStatement ps1 =  (PreparedStatement) cx.prepareStatement(query1);
			 ps1.setString(1, p.getNameProduct());
			 ps1.setDouble(2, p.getPrice());
			 ps1.setInt(3, p.getQuantity());
			 ps1.setInt(4, p.getCategorie().getIdCategorie());
	 		 ps1.executeUpdate(); 
		 }
	     catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	}
	public void changeProduct (Product p) {
		 Connection cx =  (Connection) SingleConnection.getConnection(); 
		 try {
			 String query1 = "update produit set nameProduit=?,price=?,quantity=? where idProduit=?" ;
			 PreparedStatement ps1 =  (PreparedStatement) cx.prepareStatement(query1);
			 ps1.setString(1, p.getNameProduct());
			 ps1.setDouble(2, p.getPrice());
			 ps1.setInt(3, p.getQuantity());
			 ps1.setInt(4, p.getIdProduct());
	 		 ps1.executeUpdate(); 
		 }
	     catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	}
	public void deleteProduct(int id) {
		 Connection cx =  (Connection) SingleConnection.getConnection(); 
		 try {
			 String query1 = "delete from produit where idProduit=?" ;
			 PreparedStatement ps1 =  (PreparedStatement) cx.prepareStatement(query1);
			 ps1.setInt(1, id);

		 }
		 catch(SQLException e) {
			    	 e.printStackTrace();
	     }
	}
	public List <Product> SortByPriceLowToHigh (){
		List <Product> liste = new ArrayList<>();
		liste = getAllProduct() ; 
		Collections.sort(liste , new Comparator<Product>() {

			@Override
			public int compare(Product produit1, Product produit2) {
				// TODO Auto-generated method stub
				return (int) (produit1.getPrice()-produit2.getPrice())   ;
			}
			
		});
		return liste;
		
	}
	public List <Product> SortByPriceHighToLow (){
		List <Product> liste = new ArrayList<>();
		liste = getAllProduct() ; 
		Collections.sort(liste , new Comparator<Product>() {

			@Override
			public int compare(Product produit1, Product produit2) {
				// TODO Auto-generated method stub
				return (int) (produit2.getPrice()-produit1.getPrice())   ;
			}
			
		});
		return liste;
		
	}
	public List Categorie () {
		List <String> liste = new ArrayList<>();
		Connection cx =  (Connection) SingleConnection.getConnection(); 
		try {
	 			String query = "SELECT nameCat FROM Categorie " ;  
	 			PreparedStatement ps =  (PreparedStatement) cx.prepareStatement(query);
	 			ResultSet rs = ps.executeQuery();
	 			while (rs.next()) 
	 			{
		 			Categorie c = new Categorie();
	 				c.setNameCat(rs.getString(1));
	 				liste.add(c.getNameCat()); 
 				}
		}
		catch(SQLException e) {
			    	 e.printStackTrace();
	     }
	 			
		return liste;
		
	}
}
