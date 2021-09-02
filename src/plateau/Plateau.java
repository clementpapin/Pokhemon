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
		this(couple.getFirst(),couple.getSecond(),5);
	}
	
	public int getNbPasMax() {
		return nbPasMax;
	}
	
	public void affichagePlateau() {
		AffichagePlateau.afficherPlateau(this);
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
		}
	}
	
	public char[][] getNiveau() {
		return niveau;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public static void main(String[] args) throws InterruptedException {
		Plateau p = new Plateau(ChargerPlateau.charger("test"));
		p.affichagePlateau();
		Joueur joueur = p.getJoueur();
		while(joueur.getNbPas() != p.nbPasMax) {
			Deplacement.entree_deplacement_joueur(p);
			p.affichagePlateau();
		}
		System.out.println("Nombres de pas écouler !");
	}
}
