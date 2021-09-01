package plateau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChargerPlateau {

	public static char[][] charger(String nom_fichier) {
		ArrayList<String> al = new ArrayList<String>();
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
				niveau[j][i] = al.get(i).charAt(j);
			}
		}
		
		return niveau;
	}


		public static void main(String[] args) {
			ChargerPlateau.charger("test");
		}
	}