package menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import plateau.MidiPlayer;
import plateau.Plateau;

public class MenuPrincipal {




	public static void main(String[] args) {
		Runnable myrunnable = new Runnable() {
		    public void run() {
		    	MidiPlayer.play("title-screen.mid");
		    	}
		};
		
		
		boolean end = false;
		int entree = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (!end) {
			Thread wildThread = new Thread(myrunnable);
			wildThread.start();
			do {
				displayChoices();
				try {
					entree = Integer.parseInt(br.readLine());
				} catch (Exception e) {
				}

			} while (!isValidChoice(entree));
			switch (entree) {
			case 1:
				try {
					wildThread.interrupt();
					Plateau.main(new String[0]);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				afficherRegles();
				break;

			case 3:
				end = true;
				break;

			default:
				break;
			}
			entree = -1;
		}
	}

	private static boolean isValidChoice(int entree) {
		return entree > 0 && entree <= 3;
	}

	private static void displayChoices() {
		MenuPrincipal.afficherTitre();
		System.out.println("" + '\n' + '\n' 
				+ '\t' + '\t' + '\t' + "1. Jouer" + '\n'
				+ '\t' + '\t' + '\t' + "2. Comment jouer ?" + '\n'
				+ '\t' + '\t' + '\t' + "3. Quitter");
	}

	public static void afficherTitre() {
		char c;


		System.out.print("\u001b[48;5;11m");
		System.out.print("\u001b[38;5;20m");
		System.out.print("\u001b[1m");
		try (FileReader f = new FileReader("res/artwork/Titre");){
			int i = -1;
			do {
				i = f.read();
				c = (char) i;

				if(c != '/' && c != '\\' && c != '_' && c != '<' && c !='\n') {
					System.out.print(" ");
				} else {


					System.out.print(c);
				}



			}while(i != -1);


			System.out.print("\u001b[48;38;5;0m");
			System.out.print("\u001b[38;5;255m");	

		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public static void afficherRegles() {
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try (FileReader f = new FileReader("res/text/Regles");){
			int i = -1;
			i = f.read();
			
			while(i != -1) {
				c = (char) i;
				System.out.print(c);
				i = f.read();
			}
			System.out.print("\n\n" + "Appuyez sur entrée pour retourner au menu...");
			br.readLine();
			System.out.println("\n\n\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clear() {
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


