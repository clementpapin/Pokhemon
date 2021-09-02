package pokehmon;

public class Pokehmon {
	private String nom, apparence;
	private double tauxcapture, tauxfuite;
	private int points;
	
	public Pokehmon() {
		this(ListePokehmon.PIKAHCHU.getNom(),ListePokehmon.PIKAHCHU.getApparence(), ListePokehmon.PIKAHCHU.getTauxcapture(), ListePokehmon.PIKAHCHU.getTauxfuite(), ListePokehmon.PIKAHCHU.getPoints());
	}
	
	public Pokehmon(ListePokehmon poke) {
		this(poke.getNom(),poke.getApparence(),poke.getTauxcapture(),poke.getTauxfuite(),poke.getPoints());
	}
	
	public Pokehmon(String nom, String apparence, double tauxcapture, double tauxfuite, int points) {
		this.nom = nom;
		this.apparence = apparence;
		this.tauxcapture = tauxcapture;
		this.tauxfuite = tauxfuite;
		this.points = points;
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
