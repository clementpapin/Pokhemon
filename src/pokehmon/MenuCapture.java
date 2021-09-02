package pokehmon;

import java.io.FileReader;
import java.io.InputStreamReader;

public class MenuCapture {

	public static void AfficherPokemon(Pokehmon p) {
		System.out.println(p.getApparence() + '\n' + "Un " + p.getNom() + " sauvage apparait !");
	}

	public static void AfficherChoix() {
		System.out.println("Que voulez vous faire ?" + '\n'
				+ '\t' + "1. Lancer une ball" + '\n'
				+ '\t' + "2. Donner un cookie" + '\n'
				+ '\t' + "3. Lancer un caillou" + '\n'
				+ '\t' + "4. Fuir");
	}

	public static void AfficherResChoix(int nb) {

		System.out.println(Choix.values()[nb-1].getRes());
	}

	public static void AfficherCapture(Pokehmon p ) {
		MenuCapture.AfficherDessin();
		System.out.println('\n' + p.getNom() + " attrapé !");
	}

	public static void AfficherCaptureFail(Pokehmon p) {
		System.out.println(p.getNom() + " s'échappe de la ball !");
	}



	public static void AfficherDessin() {
		char c;

		System.out.print("\u001b[48;38;5;0m");
		try (FileReader f = new FileReader("src/ArtWork/Ball");){
			int i = -1;
			do {
				i = f.read();
				c = (char) i;

				if(c == '▄' || c == '█') {
					System.out.print("\u001b[38;5;16m");
				}else if(c == '░') {
					System.out.print("\u001b[38;5;7m");
				}else if(c == '▓') {
					System.out.print("\u001b[38;5;1m");
				}else {
					System.out.print("\u001b[38;5;0m");
				}
				
				if(c != '▄' && c != '█' && c != '░' && c != '▓' && c !='\n') {
					System.out.print(" ");
				}else {
					System.out.print(c);
				}

			}while(i != -1);

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.print("\u001b[38;5;16m");

	}



}
