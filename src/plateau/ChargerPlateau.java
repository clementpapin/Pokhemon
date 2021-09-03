package plateau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChargerPlateau {

	public static Couple<char[][], Joueur> charger(String nom_fichier) {
		ArrayList<String> al = new ArrayList<String>();
		int j_x = 0;
		int j_y = 0;
		InputStream in = ChargerPlateau.class.getResourceAsStream("/niveaux/"+nom_fichier); 

		try (BufferedReader bf = new BufferedReader(
				new InputStreamReader(in))){
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
		return new Couple<char[][], Joueur>(niveau, new Joueur(j_x, j_y));
	}
}