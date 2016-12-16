package bientotEnWE;

public abstract class Dessert {

	private String libelle;
	private double prix;
	protected Dessert dessert;
	
	public String getLibelle(){
		return this.libelle;
	}
	
	public double getPrix(){
		// TODO
		return prix;
	}
	
	protected void setLibelle(String libelle){
		this.libelle = libelle;
	}
	
	protected void setPrix(double prix){
		this.prix = prix;
	}
	
	public String toString(){
		//TODO
		return "";
	}
}
