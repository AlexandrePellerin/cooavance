
public class Voiture {

	private Etat etat;
	private String model;
	private Atelier atelier;

	public Voiture() {
		this.etat = Etat.MARCHE;
		this.model = "reno";
	}

	public Voiture(Etat etat, String model) {
		super();
		this.etat = etat;
		this.model = model;
	}

	public Voiture(String model) {
		super();
		this.etat = Etat.MARCHE;
		this.model = model;
	}
	
	public boolean estEnMarche(){
		return this.etat.equals(Etat.MARCHE);
	}
	
	

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}
	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getModel() {
		return model;
	}

	public String toString() {
		return model + ": " + etat.getNom();
	}
}
