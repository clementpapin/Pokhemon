package plateau;

public class Plateau {
	private char[][] niveau;
	private Joueur joueur;
	private int nbPasMax;
	
	public Plateau(char[][] niveau, Joueur joueur, int nbPas) {
		this.niveau = niveau;
		this.joueur = joueur;
		this.nbPasMax = nbPas;
	}
	public Plateau(Couple<char[][], Joueur> couple) {
		this(couple.getFirst(),couple.getSecond(),20);
	}
	
	public int getNbPasMax() {
		return nbPasMax;
	}
	
	public void affichagePlateau() {
		AffichagePlateau.afficherPlateau(this);
	}
	
	public void changerPlateau() {
		char pos = niveau[joueur.getX()][joueur.getY()];
		if(pos == 'D') {
			Couple<char[][], Joueur> couple = ChargerPlateau.charger("niveau2");
			this.niveau = couple.getFirst();
			int x = couple.getSecond().getX();
			int y = couple.getSecond().getY();
			this.joueur.setX(x);this.joueur.setY(y);
		} else if(pos == 'G') {
			Couple<char[][], Joueur> couple = ChargerPlateau.charger("niveau1");
			this.niveau = couple.getFirst();
			int x = couple.getSecond().getX();
			int y = couple.getSecond().getY();
			this.joueur.setX(x);this.joueur.setY(y);
		} else if(pos == 'L') {
			Couple<char[][], Joueur> couple = ChargerPlateau.charger("niveau01");
			this.niveau = couple.getFirst();
			int x = couple.getSecond().getX();
			int y = couple.getSecond().getY();
			this.joueur.setX(x);this.joueur.setY(y);
		} else if(pos == 'D') {
			Couple<char[][], Joueur> couple = ChargerPlateau.charger("niveau02");
			this.niveau = couple.getFirst();
			int x = couple.getSecond().getX();
			int y = couple.getSecond().getY();
			this.joueur.setX(x);this.joueur.setY(y);
		}
	}
	
	public void deplacementJoueur(char entree) {
		int j_col = joueur.getX();
		int j_lig = joueur.getY();
		
		switch (entree) {
		case 'z':
			j_lig--;
			break;
		case 's':
			j_lig++;
			break;
		case 'q':
			j_col--;
			break;
		case 'd':
			j_col++;
			break;
		default:
			break;
		}
		char case_apres_mouvement = niveau[j_col][j_lig];
		if(case_apres_mouvement==' ' || case_apres_mouvement=='H') {
			joueur.setX(j_col); joueur.setY(j_lig);
			joueur.augmenterPas();
		} else if(case_apres_mouvement=='D') {
			changerPlateau();
		} else if(case_apres_mouvement=='G') {
			changerPlateau();
		} else if(case_apres_mouvement=='L') {
			changerPlateau();
		} else if(case_apres_mouvement=='P') {
			changerPlateau();
		}
	}
	
	public char[][] getNiveau() {
		return niveau;
	}
	
	public Joueur getJoueur() {
		return joueur;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Plateau p = new Plateau(ChargerPlateau.charger("niveau0"));
		p.affichagePlateau();
		Joueur joueur = p.getJoueur();
		while(joueur.getNbPas() != p.nbPasMax) {
			Deplacement.entree_deplacement_joueur(p);
			p.affichagePlateau();
		}
		System.out.println("Nombres de pas écouler !");
	}
}
