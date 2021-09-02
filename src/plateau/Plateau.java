package plateau;

public class Plateau {
	private char[][] niveau;
	private Joueur joueur;
	private int nbPasMax;
	private String nomPlateau;
	
	public Plateau(char[][] niveau, Joueur joueur, int nbPas, String nomPlateau) {
		this.niveau = niveau;
		this.joueur = joueur;
		this.nbPasMax = nbPas;
		this.nomPlateau = nomPlateau;
	}
	public Plateau(Couple<char[][], Joueur, String> couple) {
		this(couple.getFirst(),couple.getSecond(),10,couple.getThird());
	}
	
	public int getNbPasMax() {
		return nbPasMax;
	}
	
	public void affichagePlateau() {
		AffichagePlateau.afficherPlateau(this);
	}
	
	public void changerPlateau() {
		Couple<char[][], Joueur, String> couple = ChargerPlateau.charger("niveau_5_6");
		this.niveau = couple.getFirst();
		int x = couple.getSecond().getX();
		int y = couple.getSecond().getY();
		this.joueur.setX(x);this.joueur.setY(y);
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
		}
	}
	
	public char[][] getNiveau() {
		return niveau;
	}
	
	public Joueur getJoueur() {
		return joueur;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Plateau p = new Plateau(ChargerPlateau.charger("niveau_5_5"));
		p.affichagePlateau();
		Joueur joueur = p.getJoueur();
		while(joueur.getNbPas() != p.nbPasMax) {
			Deplacement.entree_deplacement_joueur(p);
			p.affichagePlateau();
		}
		System.out.println("Nombres de pas écouler !");
	}
}
