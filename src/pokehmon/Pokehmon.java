package pokehmon;

public class Pokehmon {
	private String nom = "Pikahchu";
	private double tauxcapture = 50.0, tauxfuite = 10.0;
	private int points = 1000;
	
	public Pokehmon() {
		
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
