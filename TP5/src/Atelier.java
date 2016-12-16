
public abstract class Atelier {

	private boolean occuper;

	public Atelier(){
		super();
		this.occuper = false;
	}
	
	public boolean estOccuper(){
		return this.occuper;
	}
	
	public void setOccuper(){
		this.occuper = true;
	}
	
	public void setLibre(){
		this.occuper = false;
	}
	
	public abstract void reparer(Voiture voiture);
}
