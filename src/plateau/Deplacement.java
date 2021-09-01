package plateau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deplacement {
	 
	public static void entree_deplacement_joueur(Plateau plateau) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			plateau.deplacementJoueur((char) br.read());
		} catch (IOException e) {
		}
	}
}
