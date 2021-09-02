package plateau;

public class Plateau {
	private char[][] niveau;
	private Joueur joueur;
	
	public Plateau(char[][] niveau, Joueur joueur) {
		this.niveau = niveau;
		this.joueur = joueur;
	}
	public Plateau(Couple<char[][], Joueur> couple) {
		this.niveau = couple.getFirst();
		this.joueur = couple.getSecond();
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
		for (int i = 0; i < 100; i++) {
			Deplacement.entree_deplacement_joueur(p);
			p.affichagePlateau();
		}
	}
}
