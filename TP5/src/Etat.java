
public enum Etat {
	MARCHE("marche"), PANNE_LEGERE("panne legere"), PANNE_SERIEUSE("panne serieuse");

	private String nom;

	private Etat() {
		this.nom = this.toString();
	}

	private Etat(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return this.nom;
	}
}
