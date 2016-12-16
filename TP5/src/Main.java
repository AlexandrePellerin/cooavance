
public class Main {

	public static void main(String[] args) {
		Garage garage = new Garage(2);
		Voiture voit = new Voiture(Etat.PANNE_LEGERE, "pigeot");
		garage.add(voit);
		garage.add(new Voiture("citroen"));
		garage.add(new Voiture(Etat.PANNE_SERIEUSE, "ducatti"));

		Atelier atelierLeg = new AtelierLeger();
		Atelier atelierSev = new AtelierSevere();

		MyIterateur iter = garage.creerIterateur();
		while (iter.hasNext()) {
			Voiture temp = (Voiture) iter.next();
			System.out.println(temp.toString());
			if (temp.getEtat().equals(Etat.PANNE_LEGERE)) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						atelierLeg.reparer(temp);
					}
				});
			} else if (temp.getEtat().equals(Etat.PANNE_SERIEUSE)) {
				// atelierSev.reparer(temp);
				new Thread(new Runnable() {

					@Override
					public void run() {
						atelierSev.reparer(temp);
					}
				});
			}
		}
		iter = garage.creerIterateur();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
