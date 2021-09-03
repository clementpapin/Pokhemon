package pokehmon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import menu.Pokehdex;
import plateau.MidiPlayer;
import plateau.Plateau;

public class ModeCapture {
	private Pokehmon pokehmon;
	private static Choix ball = new Ball();
	private static Choix caillou = new Caillou();
	private static Choix cookie = new Cookie();
	
	public ModeCapture(Pokehmon pokehmon) {
		this.pokehmon = pokehmon;
		ModeCapture.ball = new Ball();
	}
	
	/**
	 * Démarre la capture du pokehmon jusqu'à la fuite du pokehmon ou du joueur ou la capture du pokehmon
	 *
	 * @return Le pokehmon si capturé ou null si le joueur ou le pokehmon a fui
	 */
	public Pokehmon startCapture() {
		Runnable myrunnable = new Runnable() {
		    public void run() {
		    	MidiPlayer.playloop("wild-pokemon-battle.mid");
		    	}
		};
		Thread wildThread = new Thread(myrunnable);
		wildThread.start();
		
		Runnable caught = new Runnable() {
		    public void run() {
		    	MidiPlayer.playonce("wild-pokemon-caught.mid");
		    	}
		};
		Thread caughtThread = new Thread(caught);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		boolean captured = false, fuitejoueur = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int entree = -1;
		MenuCapture.afficherPokemon(pokehmon);
		boolean hasPokehball = true;
		while(this.pokehmon != null && !captured && hasPokehball) {
			do {
				try {
					MenuCapture.afficherChoix();
					entree = Integer.parseInt(br.readLine());
				} catch (Exception e) {	
				}
			} while(!isValidChoice(entree));
			
			MenuCapture.afficherResChoix(entree);
			switch(entree) {
				case 1 :
					Plateau.nbPokehball--;
					modify_pokehmon_stats(ball);
					captured = capturePokehmon();
					if(!captured) {
						MenuCapture.afficherCaptureFail(pokehmon);
						System.out.println("Nombre de pokehball restantes : "+Plateau.nbPokehball);
					}
					remove_pokehmon_stats(ball);
					break;
					
				case 2 :
					modify_pokehmon_stats(cookie);
					break;
					
				case 3 :
					modify_pokehmon_stats(caillou);
					break;
					
				case 4 :
					fuite();
					fuitejoueur = true;
					break;
			}

			if(!captured && this.pokehmon != null && essaifuitePokehmon()) fuite();
			if(Plateau.nbPokehball <= 0) {
				hasPokehball = false;
			}
			entree = 0;
		}
		
		if(captured) {
			Pokehdex.sendToPokehdex(this.pokehmon.getNom());
			wildThread.interrupt();
			caughtThread.start();
			MenuCapture.afficherCapture(this.pokehmon);
			Plateau.score+=this.pokehmon.getPoints();
			return pokehmon;
		}
		else if (this.pokehmon == null && !fuitejoueur) System.out.println("Le pokehmon a fuit.");
		wildThread.interrupt();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n\n");
		return null;
	}
	
	/**
	 * Vérifie la validité du choix de l'utilisateur
	 * @param choice - Le choix utilisateur
	 * @return True si le choix est valide, false dans le cas contraire
	 */
	private boolean isValidChoice(int choice) {
		return choice > 0 && choice <= 4; 
	}
	
	/**
	 * Tente la capture du pokehmon selon son taux de capture
	 * @return true si la capture a réussi, false dans la cas contraire
	 */
	private boolean capturePokehmon() {
		Random rdm = new Random();
		return rdm.nextDouble()*100 <= this.pokehmon.getTauxcapture();
	}
	
	/**
	 * Le Pokehmon tente de fuir selon son taux de fuite
	 * @return true si la fuite a réussi, false dans le cas contraire
	 */
	private boolean essaifuitePokehmon() {
		Random rdm = new Random();
		return rdm.nextDouble()*100 <= this.pokehmon.getTauxfuite();
	}
	
	/**
	 * Fait fuir le joueur
	 */
	private void fuite() {
		this.pokehmon = null;
	}
	private void modify_pokehmon_stats(Choix choix) {
		this.pokehmon.augmenter_taux_capture(choix.AUGMENTATION_TAUX_CAPTURE);
		this.pokehmon.augmenter_taux_fuite(choix.AUGMENTATION_TAUX_FUITE);
	}
	
	private void remove_pokehmon_stats(Choix choix) {
		this.pokehmon.augmenter_taux_capture(-choix.AUGMENTATION_TAUX_CAPTURE);
		this.pokehmon.augmenter_taux_fuite(-choix.AUGMENTATION_TAUX_FUITE);
	}
}