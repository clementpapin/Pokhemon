package plateau;

public class AffichagePlateau {
	public static void afficherPlateau(Plateau p) {
		System.out.print("\u001b[48;5;236m");
		System.out.print("\u001b[38;5;255m");
		char[][] niveau = p.getNiveau();
		Joueur joueur = p.getJoueur();
		System.out.println("Entrez 'e' pour revenir au menu");
		System.out.println("Entrez 'p' pour ouvrir le pokehdex");
		System.out.println("Nombre de pas restants : "+(p.getNbPasMax()-joueur.getNbPas()));
		System.out.println("Nombre de pokehball restantes : "+(Plateau.nbPokehball));
		System.out.println("Score : "+Plateau.score);
		int nblig = 0;
		for (int i = 0; i < niveau.length; i++) {
			if(nblig<niveau[i].length) {
				nblig = niveau[i].length;
			}
		}

		for (int l = 0; l < niveau[nblig].length; l++) {
			for (int i = 0; i < 2; i++) {
				for (int c = 0; c < niveau.length; c++) {
					modification_couleur(niveau, l, c);

					affichage_case(niveau, joueur, l, c, i);
					System.out.print("\u001b[48;5;236m");
					System.out.print("\u001b[38;5;255m");
				}
				System.out.println();
			}
		}
	}

	private static void affichage_case(char[][] niveau, Joueur joueur, int l, int c, int p) {
		if(joueur.getX()==c && joueur.getY()==l) {
			if(p==0) {
				System.out.print("\u001b[38;5;255m O");
			}else {
				System.out.print("\u001b[38;5;1m©\u001b[38;5;255m╣");
			}
		}else {
			switch (niveau[c][l]) {
			case '/':
				System.out.print("▓▓");
				break;
			case 'H':
				System.out.print("░░");
				break;
			case 'E':
				System.out.print("  ");
				break;
			case ' ':
				System.out.print("  ");
				break;
			case 'R':
				System.out.print("▓▓");
				break;
			case 'I':
				if(p==0) {
					System.out.print("╔╗");
				}else {
					System.out.print("╚╝");
				}
				break;
			default:
				System.out.print("\u001b[48;5;223m\u001b[38;5;208m");
				System.out.print("  ");
				break;
			}
		}
	}

	private static void modification_couleur(char[][] niveau, int l, int c) {
		switch (niveau[c][l]) {
		case '/':
			System.out.print("\u001b[38;5;88m\u001b[48;5;172m");
			break;
		case 'H':
			System.out.print("\u001b[38;5;28m\u001b[48;5;34m");
			break;
		case 'E':
			System.out.print("\u001b[48;5;21m");
			break;
		case ' ':
			System.out.print("\u001b[48;5;136m");
			break;
		case 'R':
			System.out.print("\u001b[38;5;94m\u001b[48;5;136m");
			break;
		case 'I':
			System.out.print("\u001b[48;5;136m");
			break;
		default:
			break;
		}
	}
}