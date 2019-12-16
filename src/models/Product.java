package models;

public class Product {
	private int idProduct ; 
	private String nameProduct ; 
	private double price ; 
	private int quantity ; 
	private Categorie Categorie ;
	public Product( String nameProduct, double price, int quantity, Categorie Categorie) {
		super();
		
		this.nameProduct = nameProduct;
		this.price = price;
		this.quantity = quantity;
		this.Categorie = Categorie;
	}
	public Product () {
		
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Categorie getCategorie() {
		return Categorie;
	}
	public void setCategorie(Categorie Categorie) {
		this.Categorie = Categorie;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", price=" + price + ", quantity="
				+ quantity + ", Categorie=" + Categorie + "]";
	}


	

}
