package pokehmon;

public class Pokehmon {
	private String nom, apparence;
	private double tauxcapture, tauxfuite;
	private int points = 1000;
	
	public Pokehmon() {
		nom = "Pikahchu";
		apparence = "       ,___          .-;'\n" + 
				"       `\"-.`\\_...._/`.`\n" + 
				"    ,      \\        /\n" + 
				" .-' ',    / ()   ()\\\n" + 
				"`'._   \\  /()    .  (|\n" + 
				"    > .' ;,     -'-  /\n" + 
				"   / <   |;,     __.;\n" + 
				"   '-.'-.|  , \\    , \\\n" + 
				"      `>.|;, \\_)    \\_)\n" + 
				"       `-;     ,    /\n" + 
				"          \\    /   <\n" + 
				"           '. <`'-,_)\n" + 
				"            '._)";
		tauxcapture = 50.0;
		tauxfuite = 2.0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getApparence() {
		return apparence;
	}

	public double getTauxcapture() {
		return tauxcapture;
	}

	public void setTauxcapture(double tauxcapture) {
		this.tauxcapture = tauxcapture;
	}

	public double getTauxfuite() {
		return tauxfuite;
	}

	public void setTauxfuite(double tauxfuite) {
		this.tauxfuite = tauxfuite;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "\""+nom+"\"";
	}
	
}
