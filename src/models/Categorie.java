package models;

public class Categorie {
	private int idCategorie ; 
	private String nameCat ;
	public Categorie(int idCategorie, String nameCat) {
		super();
		this.idCategorie = idCategorie;
		this.nameCat = nameCat;
	}
	public Categorie () {
		
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setidCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nameCat=" + nameCat + "]";
	}

	

}
