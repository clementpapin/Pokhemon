package pokehmon;

import java.io.FileReader;

public class MenuCapture {

	public static void afficherPokemon(Pokehmon p) {
		System.out.println(p.getApparence() + '\n' + "Un " + p.getNom() + " sauvage apparait !");
	}

	public static void afficherChoix() {
		System.out.println("Que voulez vous faire ?" + '\n'
				+ '\t' + "1. Lancer une ball" + '\n'
				+ '\t' + "2. Donner un cookie" + '\n'
				+ '\t' + "3. Lancer un caillou" + '\n'
				+ '\t' + "4. Fuir");
	}

	public static void afficherResChoix(int nb) {

		System.out.println(Choix.values()[nb-1].getRes());
	}

	public static void afficherCapture(Pokehmon p ) {
		MenuCapture.afficherDessin();
		System.out.print("\u001b[38;5;16m");
		System.out.println('\n' + p.getNom() + " attrapé !");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void afficherCaptureFail(Pokehmon p) {
		System.out.println(p.getNom() + " s'échappe de la ball !");
	}



	public static void afficherDessin() {
		char c;

		System.out.print("\u001b[48;38;5;0m");
		try (FileReader f = new FileReader("res/artwork/Ball");){
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
		

	}



}
