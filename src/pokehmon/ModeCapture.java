package pokehmon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ModeCapture {
	private Pokehmon pokehmon;
	private static final double AUGMENTATIONFUITE = 5.0;
	private static final double DIMINUTIONFUITECAILLOU = 20.0;
	private static final double AUGMENTATIONFUITECOOKIE = 20.0;
	private static final double DIMINUTIONCAPTURECAILLOU = 20.0;
	private static final double AUGMENTATIONCAPTURECOOKIE = 20.0;
	
	public ModeCapture(Pokehmon pokehmon) {
		this.pokehmon = pokehmon;
	}
	
	/**
	 * Démarre la capture du pokehmon jusqu'à la fuite du pokehmon ou du joueur ou la capture du pokehmon
	 * TODO Gérer la fuite du pokehmon
	 * @return Le pokehmon si capturé ou null si le joueur ou le pokehmon a fuit
	 */
	public Pokehmon startCapture() {
		boolean captured = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entree = null;
		
		while(this.pokehmon != null && captured == false) {
			do {
				try {
					entree = br.readLine();
				} catch (Exception e) {	
				}
			} while(!isValidChoice(entree));
			
			switch(Choix.valueOf(entree.toUpperCase())) {
				case BALL : 
					captured = capturePokehmon();
					
				case CAILLOU :
					lanceCaillou();
					
				case COOKIE :
					donneCookie();
					
				case FUITE :
					fuite();
			}
			
			if(!captured && this.pokehmon != null) 
			pokehmon.setTauxfuite(pokehmon.getTauxfuite()+AUGMENTATIONFUITE);
		}
		
		return pokehmon;
	}
	
	/**
	 * Vérifie la validité du choix de l'utilisateur
	 * @param choice - Le choix utilisateur
	 * @return True si le choix est valide, false dans le cas contraire
	 */
	private boolean isValidChoice(String choice) {
		return Choix.valueOf(choice.toUpperCase()) != null;
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
		this.pokehmon.setTauxfuite(this.pokehmon.getTauxfuite()-DIMINUTIONFUITECAILLOU);
		this.pokehmon.setTauxcapture(this.pokehmon.getTauxcapture()-DIMINUTIONCAPTURECAILLOU);
	}
	
	/**
	 * Donne un cookie au pokehmon, augmentant son taux de capture mais aussi son taux de fuite
	 */
	private void donneCookie() {
		this.pokehmon.setTauxfuite(this.pokehmon.getTauxfuite()+AUGMENTATIONFUITECOOKIE);
		this.pokehmon.setTauxcapture(this.pokehmon.getTauxcapture()+AUGMENTATIONCAPTURECOOKIE);
	}
}
