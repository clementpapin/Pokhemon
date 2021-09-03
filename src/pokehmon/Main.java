package pokehmon;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rdm = new Random();
		ListePokehmon poke = ListePokehmon.values()[rdm.nextInt(ListePokehmon.values().length)];
		Pokehmon p = new Pokehmon(poke);
		ModeCapture mc = new ModeCapture(p);
		mc.startCapture();
		//TODO enlever quand on a plus besoin
	}
}
