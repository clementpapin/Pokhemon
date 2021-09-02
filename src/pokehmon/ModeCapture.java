package pokehmon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import plateau.MidiPlayer;
import plateau.Plateau;

public class ModeCapture {
	private Pokehmon pokehmon;
	private static final double AUGMENTATIONFUITE = 2.0;
	private static final double AUGMENTATIONFUITECAILLOU = 20.0;
	private static final double DIMINUTIONFUITECOOKIE = 20.0;
	private static final double AUGMENTATIONCAPTURECAILLOU = 20.0;
	private static final double DIMINUTIONCAPTURECOOKIE = 20.0;
	
	public ModeCapture(Pokehmon pokehmon) {
		this.pokehmon = pokehmon;
	}
	
	/**
	 * Démarre la capture du pokehmon jusqu'à la fuite du pokehmon ou du joueur ou la capture du pokehmon
	 *
	 * @return Le pokehmon si capturé ou null si le joueur ou le pokehmon a fui
	 */
	public Pokehmon startCapture() {
		Runnable myrunnable = new Runnable() {
		    public void run() {
		    	MidiPlayer.play("src/plateau/wild-pokemon-battle.mid");
		    	}
		};
		
		Thread wildThread = new Thread(myrunnable);
		wildThread.start();
		Runnable caught = new Runnable() {
		    public void run() {
		    	MidiPlayer.play("src/plateau/wild-pokemon-caught.mid");
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

		while(this.pokehmon != null && !captured) {
			do {
				try {
					MenuCapture.afficherChoix();
					entree = Integer.parseInt(br.readLine());
				} catch (Exception e) {	
				}
			} while(!isValidChoice(entree));
			
			MenuCapture.afficherResChoix(entree);
			switch(Choix.values()[entree-1]) {
				case BALL :
					if(Plateau.nbPokehball>0) {
						Plateau.nbPokehball--;
						captured = capturePokehmon();
						if(!captured) MenuCapture.afficherCaptureFail(pokehmon);
					} else {
						System.out.println("Vous n'avez plus de pokehball !");
						fuite();
					}
					
					break;
					
				case CAILLOU :
					lanceCaillou();
					break;
					
				case COOKIE :
					donneCookie();
					break;
					
				case FUITE :
					fuite();
					fuitejoueur = true;
					break;
			}

			if(!captured && this.pokehmon != null && essaifuitePokehmon()) fuite();
			if(this.pokehmon != null) pokehmon.setTauxfuite(pokehmon.getTauxfuite()+AUGMENTATIONFUITE);
			
			entree = 0;
		}
		
		if(captured) {
			wildThread.interrupt();
			caughtThread.start();
			MenuCapture.afficherCapture(this.pokehmon);
			Plateau.score+=this.pokehmon.getPoints();
			return pokehmon;
		}
		else if (this.pokehmon == null && !fuitejoueur) System.out.println("Le pokehmon a fui");
		wildThread.interrupt();
		return null;
	}
	
	/**
	 * Vérifie la validité du choix de l'utilisateur
	 * @param choice - Le choix utilisateur
	 * @return True si le choix est valide, false dans le cas contraire
	 */
	private boolean isValidChoice(int choice) {
		return choice > 0 && choice <= Choix.values().length; 
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
	 * Le Pokehmon tente de fuire selon son taux de fuite
	 * @return true si la fuite a réussi, false dans le cas contraire
	 */
	private boolean essaifuitePokehmon() {
		Random rdm = new Random();
		return rdm.nextDouble()*100 <= this.pokehmon.getTauxfuite();
	}
	
	/**
	 * Fait fuire le joueur
	 */
	private void fuite() {
		this.pokehmon = null;
	}
	
	/**
	 * Lance un caillou sur le pokehmon, diminuant son taux de fuite mais aussi son taux de capture
	 */
	private void lanceCaillou() {
		this.pokehmon.setTauxfuite(this.pokehmon.getTauxfuite()+AUGMENTATIONFUITECAILLOU);
		this.pokehmon.setTauxcapture(this.pokehmon.getTauxcapture()+AUGMENTATIONCAPTURECAILLOU);
	}
	
	/**
	 * Donne un cookie au pokehmon, augmentant son taux de capture mais aussi son taux de fuite
	 */
	private void donneCookie() {
		if(this.pokehmon.getTauxfuite()-DIMINUTIONFUITECOOKIE > 0) this.pokehmon.setTauxfuite(this.pokehmon.getTauxfuite()-DIMINUTIONFUITECOOKIE);
		else this.pokehmon.setTauxfuite(0);
		
		if(this.pokehmon.getTauxcapture()-DIMINUTIONCAPTURECOOKIE > 0) this.pokehmon.setTauxcapture(this.pokehmon.getTauxcapture()-DIMINUTIONCAPTURECOOKIE);
		else this.pokehmon.setTauxcapture(0);
	}
}