package pokehmon;

public class MenuCapture {

	public void AfficherPokemon(Pokehmon p) {
		System.out.println(p.getApparence() + "Un " + p.getNom() + " sauvage apparait !");
	}
	
	public void AfficherChoix() {
		System.out.println("Que voulez vous faire ?" + '\n'
						    + '\t' + "1. Lancer une ball" + '\n'
							+ '\t' + "2. Donner un cookie" + '\n'
							+ '\t' + "3. Lancer un caillou" + '\n'
							+ '\t' + "4. Fuir");
	}
	
	public static void AfficherResChoix(int nb) {
		
		System.out.println(Choix.values()[nb-1].getRes());
	}
	
	
	
	public static void main(String[] args) {
	
		MenuCapture.AfficherResChoix(2);
	}
}
