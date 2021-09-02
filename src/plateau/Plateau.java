package plateau;

import java.util.Random;

import pokehmon.ListePokehmon;
import pokehmon.ModeCapture;
import pokehmon.Pokehmon;

public class Plateau {
	private char[][] niveau;
	private Joueur joueur;
	private int nbPasMax;
	public static int score = 0;
	public static int nbPokehball = 20;
	
	private static Runnable myrunnable = new Runnable() {
	    public void run() {
	    	MidiPlayer.play("title-screen.mid");
	    	}
	};
	
	public static Thread wildThread = new Thread(myrunnable);
	
	public Plateau(char[][] niveau, Joueur joueur, int nbPas) {
		this.niveau = niveau;
		this.joueur = joueur;
		this.nbPasMax = nbPas;
	}
	public Plateau(Couple<char[][], Joueur> couple) {
		this(couple.getFirst(),couple.getSecond(),50);
	}
	
	public int getNbPasMax() {
		return nbPasMax;
	}
	
	public void affichagePlateau() {
		AffichagePlateau.afficherPlateau(this);
	}
	
	public void changerPlateau(char pos) {
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
		} else if(pos == 'P') {
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
		if(case_apres_mouvement==' ') {
			joueur.setX(j_col); joueur.setY(j_lig);
			joueur.augmenterPas();
		}else if(case_apres_mouvement=='H'){
			joueur.setX(j_col); joueur.setY(j_lig);
			joueur.augmenterPas();
			chance_apparition_pokemon();
		} else if(case_apres_mouvement=='D') {
			changerPlateau(case_apres_mouvement);
		} else if(case_apres_mouvement=='G') {
			changerPlateau(case_apres_mouvement);
		} else if(case_apres_mouvement=='L') {
			changerPlateau(case_apres_mouvement);
		} else if(case_apres_mouvement=='P') {
			changerPlateau(case_apres_mouvement);
		}
	}
	
	private void chance_apparition_pokemon() {
		Random r = new Random();
		if(r.nextDouble()>0.5) {
			wildThread.interrupt();
			ListePokehmon poke = ListePokehmon.values()[r.nextInt(ListePokehmon.values().length)];
			Pokehmon p = new Pokehmon(poke);
			ModeCapture mc = new ModeCapture(p);
			mc.startCapture();
			wildThread = new Thread(myrunnable);
			wildThread.start();
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
		wildThread.start();
		
		while(joueur.getNbPas() != p.nbPasMax && nbPokehball>0) {
			Deplacement.entree_deplacement_joueur(p);
			p.affichagePlateau();
		}
		if(nbPokehball==0) {
			System.out.println("Vous n'avez plus de pokehball !");
			System.out.println("Votre score est de "+Plateau.score+" points !");
		} else {
			System.out.println("Nombre de pas écouler !");
			System.out.println("Votre score est de "+Plateau.score+" points !");
		}
	}
}