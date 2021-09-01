package plateau;

public class AffichagePlateau {
	public static void afficherPlateau(Plateau p) {
		char[][] niveau = p.getNiveau();
		Joueur joueur = p.getJoueur();
		int nblig = 0;
		for (int i = 0; i < niveau.length; i++) {
			if(nblig<niveau[i].length) {
				nblig = niveau[i].length;
			}
		}
		
		for (int l = 0; l < niveau[nblig].length; l++) {
			for (int c = 0; c < niveau.length; c++) {
				if(joueur.getX()==c && joueur.getY()==l) {
					System.out.print("J");
				}else {
					System.out.print(niveau[c][l]);
				}
			}
			System.out.println();
		}
	}
}
