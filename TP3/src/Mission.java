public class Mission {
	protected int jDep;
	protected int hDep;
	protected int jRet;
	protected int hRet;
	protected int nbKm;

	public Mission(int jDep, int hDep, int jRet, int hRet, int nbKm) throws IllegalArgumentException {
		if (jDep < 1 || jDep > 31) {
			throw new IllegalArgumentException("Jour de depart errone");
		}
		if (jRet < jDep || jRet > 31) {
			throw new IllegalArgumentException("Jour de retour errone");
		}
		if (hDep < 0 || hDep > 23) {
			throw new IllegalArgumentException("Heure de depart erronee");
		}
		if (jRet != jDep) {//Modif
			if (hRet < 0 || hRet > 23) {
				throw new IllegalArgumentException("Heure de retour erronee");
			}
		}
		else {
			if (hRet <= hDep || hRet > 23) {
				throw new IllegalArgumentException("Heure de retour erronee");
			}
		}
		if (nbKm < 0) {
			throw new IllegalArgumentException("Nombre de kilometres parcourus errone");
		}
		this.jDep = jDep;
		this.hDep = hDep;
		this.jRet = jRet;
		this.hRet = hRet;
		this.nbKm = nbKm;
	}

	public int nbHeb() {
		int heb = 0;
		if (hDep >=0 && hDep <= 5) {
			heb++;
		}
		heb += jRet-jDep;
		return heb;
	}

	public int nbRepas() {
		int rep = 0;
		if (jDep == jRet) {
			if (hDep<=14 && hRet>=11) {//Modif
				rep++;
			}
			if (hDep<=21 && hRet>=18) {//Modif
				rep++;
			}
		}
		else {
			if (hDep<=14) {//Modif
				rep += 2 ;
			}
			else if  (hDep<=21) {//Modif
				rep++ ;
			}
			if (hRet>=18) {//Modif
				rep+=2;//Modif
			}
			else if (hRet>=11) {//Modif
				rep ++;
			}
			rep += 2*(jRet-jDep-1);//modif
		}
		return rep;
	}

	public int fraisMiss() {
		return nbHeb()*60+nbRepas()*15+nbKm;
	}

}