package pokehmon;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Pokehmon p = new Pokehmon();
		Random rdm = new Random();
		ListePokehmon poke = ListePokehmon.values()[rdm.nextInt(ListePokehmon.values().length)];
		ModeCapture mc = new ModeCapture(p);
		mc.startCapture();
	}
}
