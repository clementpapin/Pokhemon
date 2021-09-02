package pokehmon;

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
		System.out.println( "        ▄███████████▄        " + '\n' +
							"     ▄███▓▓▓▓▓▓▓▓▓▓▓███▄     " + '\n' +
							"    ███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███    " + '\n' +
							"   ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██   " + '\n' +
							"  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██  " + '\n' +
							" ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██ " + '\n' +
							"██▓▓▓▓▓▓▓▓▓███████▓▓▓▓▓▓▓▓▓██" + '\n' +
							"██▓▓▓▓▓▓▓▓██░░░░░██▓▓▓▓▓▓▓▓██" + '\n' +
							"██▓▓▓▓▓▓▓██░░███░░██▓▓▓▓▓▓▓██" + '\n' +
							"███████████░░███░░███████████" + '\n' +
							"██░░░░░░░██░░███░░██░░░░░░░██" + '\n' +
							"██░░░░░░░░██░░░░░██░░░░░░░░██" + '\n' +
							"██░░░░░░░░░███████░░░░░░░░░██" + '\n' +
							" ██░░░░░░░░░░░░░░░░░░░░░░░██ " + '\n' +
							"  ██░░░░░░░░░░░░░░░░░░░░░██  " + '\n' +
							"   ██░░░░░░░░░░░░░░░░░░░██   " + '\n' +
							"    ███░░░░░░░░░░░░░░░███    " + '\n' +
							"     ▀███░░░░░░░░░░░███▀     " + '\n' +
							"        ▀███████████▀        " + '\n' +
															+ '\n' +
							p.getNom() + "attrapé !");
	}
	
	public static void AfficherCaptureFail(Pokehmon p) {
		System.out.println(p.getNom() + "s'échappe de la ball !");
	}
	
	
	
	
	
	public static void main(String[] args) {
	
		//MenuCapture.AfficherResChoix(2);
	}
}
