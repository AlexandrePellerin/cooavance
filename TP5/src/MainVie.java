import java.util.Random;

public class MainVie {

	public static void main(String[] args) {
		Garage garage = new Garage(2);

		Atelier atelierLeg = new AtelierLeger();
		Atelier atelierSev = new AtelierSevere();

		Apparition app = new Apparition(garage);
		app.start();
		for (;;) {
			MyIterateur iter = garage.creerIterateur();
			boolean leg = atelierLeg.estOccuper(), sev = atelierSev.estOccuper();

			while (iter.hasNext() && (!leg || !sev)) {
				Voiture test = (Voiture) iter.next();
				// System.out.println(test);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!leg && test.getEtat().equals(Etat.PANNE_LEGERE)) {
					Thread t = new Thread(new Runnable() {

						@Override
						public void run() {
							atelierLeg.reparer(test);
							garage.delete(test);
						}
					});
					t.start();
					leg = true;
				}
				if (!sev && test.getEtat().equals(Etat.PANNE_SERIEUSE)) {
					Thread t = new Thread(new Runnable() {

						@Override
						public void run() {
							atelierSev.reparer(test);
							garage.delete(test);
						}
					});
					t.start();
					sev = true;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Apparition extends Thread {

	private Garage g;
	private int cpt;

	public Apparition(Garage g) {
		this.g = g;
		this.cpt = 0;
	}

	@Override
	public void run() {
		while (true) {
			Random alea = new Random();
			try {
				Thread.sleep(100 * alea.nextInt(10) + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int temp = alea.nextInt(2);
			cpt++;
			if (temp == 1) {
				g.add(new Voiture(Etat.PANNE_LEGERE, "voiture" + (cpt)));
			} else if (temp == 0) {
				g.add(new Voiture(Etat.PANNE_SERIEUSE, "voiture" + (cpt)));
			}
		}
	}
}