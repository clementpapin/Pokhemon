package plateau;

public class AffichagePlateau {
	public static void afficherPlateau(Plateau p) {
		System.out.print("\u001b[48;38;5;0m");
		char[][] niveau = p.getNiveau();
		Joueur joueur = p.getJoueur();
		System.out.println(p.getNbPasMax()-joueur.getNbPas());
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

					System.out.print("\u001b[48;38;5;0m");
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
			case 'D':
				System.out.print("░░");
				break;
			case 'G':
				System.out.print("░░");
				break;
			default:
				System.out.print(niveau[c][l]);
				System.out.print(niveau[c][l]);
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
		case 'D':
			System.out.print("\u001b[48;5;208m");
			break;
		case 'G':
			System.out.print("\u001b[48;5;208m");
			break;
		default:
			break;
		}
	}
}
