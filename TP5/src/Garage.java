public class Garage implements MyConteneur {

	private Voiture[] voitures;
	int nbElements;

	public Garage() {
		this.voitures = new Voiture[16];
		this.nbElements = 0;
	}

	public Garage(int taille) {
		if (taille > 0) {
			this.voitures = new Voiture[taille];
		} else {
			this.voitures = new Voiture[1];
		}
		this.nbElements = 0;
	}

	public Garage(Voiture[] voitures) {
		this.voitures = voitures;
	}

	public void add(Voiture voiture) {
		if (this.voitures.length == this.nbElements) {
			Voiture[] temp = new Voiture[this.nbElements * 2];
			for (int i = 0; i < this.nbElements; i++) {
				temp[i] = this.voitures[i];
			}
			this.voitures = temp;
		}
		this.voitures[this.nbElements] = voiture;
		this.nbElements++;
	}

	public Voiture delete(int n) {
		if (n < this.nbElements && this.nbElements != 0) {
			this.nbElements--;
			Voiture temp = voitures[n];
			voitures[n] = voitures[this.nbElements];
			voitures[this.nbElements] = temp;
			return temp;
		}
		return null;
	}
	
	public void delete(Voiture voiture){
		for(int i=0;i<this.nbElements;i++){
			if(voiture == this.voitures[i]){
				this.nbElements--;
				Voiture temp = this.voitures[i];
				this.voitures[i] = this.voitures[nbElements];
				this.voitures[nbElements] = temp;
			}
		}
	}

	private class IterateurGarage implements MyIterateur {
		private int m_position;

		public boolean hasNext() {
			return (m_position < nbElements);
		}

		public Object next() {
			if (this.hasNext())
				return voitures[m_position++];
			return null;
		}
	}

	public MyIterateur creerIterateur() {
		return new IterateurGarage();
	}

	public boolean toutMarche() {
		for (int i = 0; i < this.nbElements; i++) {
			if (!this.voitures[i].getEtat().equals(Etat.MARCHE)) {
				return false;
			}
		}
		return true;
	}
}
