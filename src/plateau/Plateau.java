package plateau;

public class Plateau {
	private char[][] niveau;
	private Joueur joueur;
	
	public Plateau(char[][] niveau, Joueur joueur) {
		this.niveau = niveau;
		this.joueur = joueur;
	}
	
	public void affichagePlateau() {
		for (int l = 0; l < niveau.length; l++) {
			for (int c = 0; c < niveau.length; c++) {
				System.out.print(niveau[l][c]);
			}
		}
	}
	
	public void deplacementJoueur(char entree) {
		if(entree == 'z') {
			if(niveau[joueur.getY()+1][joueur.getX()] == '/')
			joueur.setY(joueur.getY()+1);
		}else if(entree == 's') {
			joueur.setY(joueur.getY()-1);
		} else if(entree == 'd') {
			joueur.setX(joueur.getX()+1);
		}else {
			joueur.setX(joueur.getX()-1);
		}
	}
	public static void main(String[] args) {
		String s = "///////////////////////////////\n" + 
				"/  H                          /\n" + 
				"/  HH                         /\n" + 
				"/   EEE                       /\n" + 
				"/   EEE   H                   /\n" + 
				"/   EEE                       /\n" + 
				"/              HH             /\n" + 
				"/            H                /\n" + 
				"/                             /\n" + 
				"/               J             /\n" + 
				"/                             /\n" + 
				"/                             /\n" + 
				"/   H        H                /\n" + 
				"/       H                     /\n" + 
				"///////////////////////////////";
		System.out.println(s);
	}
}
