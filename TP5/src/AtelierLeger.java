import java.util.Random;

public class AtelierLeger extends Atelier{

	@Override
	public void reparer(Voiture voiture) {
		this.setOccuper();
		System.out.println("Debut Reparation: " + voiture);
		Random alea = new Random();
		for(int i = 0 ; i<alea.nextInt(3)+1;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin Reparation: "+voiture);
		voiture.setEtat(Etat.MARCHE);
		this.setLibre();
	}

}
