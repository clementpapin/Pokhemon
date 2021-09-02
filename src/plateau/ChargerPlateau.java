package plateau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChargerPlateau {

	public static Couple<char[][], Joueur, String> charger(String nom_fichier) {
		ArrayList<String> al = new ArrayList<String>();
		int j_x = 0;
		int j_y = 0;
		try (BufferedReader bf = new BufferedReader(
				new FileReader("src/niveaux/"+nom_fichier))){
			String f;
			while((f = bf.readLine()) != null) {
				al.add(f+'\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int nbcol = 0;
		for (int i = 0; i < al.size(); i++) {
			if(nbcol<al.get(i).length()-1) {
				nbcol = al.get(i).length()-1;
			}
		}
		char[][] niveau = new char[nbcol][al.size()];

		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < nbcol; j++) {
				niveau[j][i]=' ';

				if(al.get(i).length()-1 > nbcol) {
					niveau[j][i] = ' ';
				}else if(al.get(i).charAt(j)=='J') {
					j_x = j;
					j_y = i;
					niveau[j][i] = ' ';
				}else {
					niveau[j][i] = al.get(i).charAt(j);	
				}
			}
		}
		return new Couple<char[][], Joueur, String>(niveau, new Joueur(j_x, j_y), nom_fichier);
	}
}
