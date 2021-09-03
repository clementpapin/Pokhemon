package pokehmon;

import java.io.InputStream;
import java.io.InputStreamReader;
import plateau.ChargerPlateau;

public class MenuCapture {
	static Pokehmon pok = new Pokehmon();

	public static void afficherPokemon(Pokehmon p) {
		System.out.println(p.getApparence() + '\n' + "Un " + p.getNom() + " sauvage apparait !");
		pok = p;
	}

	public static void afficherChoix() {
		System.out.println("Que voulez vous faire ?" + '\n'
				+ '\t' + "1. Lancer une ball" + '\n'
				+ '\t' + "2. Donner un cookie" + '\n'
				+ '\t' + "3. Lancer un caillou" + '\n'
				+ '\t' + "4. Fuir");
	}

	public static void afficherResChoix(int nb) {
		String res = "";
		
		switch(nb) {
		case 1:
			System.out.println(Ball.MESSAGE);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println('\t' + "2...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t\t" + "3...");
			try {
				Thread.sleep(1600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			res = Cookie.MESSAGE;
			break;
		case 3:
			res = Caillou.MESSAGE;
			break;
		case 4:
			res = "Vous prenez la fuite";
			break;

		}
		System.out.println(res);
	}

	public static void afficherCapture(Pokehmon p ) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MenuCapture.afficherDessin();
		System.out.print("\u001b[38;5;255m");
		System.out.println("\n" +"    "+ p.getNom() + " attrapé !");
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void afficherCaptureFail(Pokehmon p) {
		System.out.println(p.getNom() + " s'échappe de la ball !");
	}

	public static void afficherDessin() {
		char c;
		System.out.print("\u001b[48;38;5;0m");
		InputStream in = ChargerPlateau.class.getResourceAsStream("/artwork/Ball"); 
		try (InputStreamReader f = new InputStreamReader(in);){
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

		} catch (Exception e) {}
	}
}