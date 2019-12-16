package Data;

import java.util.List;

import models.Product;

public interface stock {
	public List <Product> getAllProductPMC(String mc ) ; 
	public List <Product> getAllProductByCat(int cat ) ; 
	public List <Product> getAllProduct() ; 
	public void deleteProduct(int id)  ; 
	public void changeProduct (Product p) ; 
	public void addProduit(Product p) ; 
	public List <Product> SortByPriceHighToLow ();
	public List <Product> SortByPriceLowToHigh ();
	public List Categorie () ; 
}
