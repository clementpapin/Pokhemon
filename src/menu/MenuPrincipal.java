package menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuPrincipal {
	
	
	
	
	public static void main(String[] args) {
		boolean end = false;
		int entree = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (!end) {
			do {
				displayChoices();
				try {
					entree = Integer.parseInt(br.readLine());
				} catch (Exception e) {
				}
			} while (!isValidChoice(entree));
			entree = -1;
		}
	}

	private static boolean isValidChoice(int entree) {
		return entree > 0 && entree <= 3;
	}
	
	private static void displayChoices() {
		System.out.println("" + '\n'
				+ "1. Jouer" + '\n'
				+ "2. Comment jouer ?" + '\n'
				+ "3. Quitter");
	}

}
