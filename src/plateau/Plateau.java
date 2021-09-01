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
}
