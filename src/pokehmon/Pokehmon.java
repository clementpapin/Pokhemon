package pokehmon;

public class Pokehmon {
	private String nom, apparence;
	private double tauxcapture, tauxfuite;
	private int points;
	private Type type = Type.NORMAL;

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

	public void augmenter_taux_fuite(double taux) {
		if(tauxfuite+taux>0 && tauxfuite+taux<100)	tauxfuite+=taux;
	}

	public void augmenter_taux_capture(double taux) {
		if(tauxcapture+taux>0 && tauxcapture+taux<100)	tauxcapture+=taux;
	}

	public void modify_pokehmon_stats(Choix choix) {
		if(choix instanceof Ball) {
			Ball b = (Ball) choix;
			if(this.type == b.estEfficaceContre() ) {
				this.augmenter_taux_capture(choix.AUGMENTATION_TAUX_CAPTURE);
			}

		}else {
			this.augmenter_taux_capture(choix.AUGMENTATION_TAUX_CAPTURE);
			this.augmenter_taux_fuite(choix.AUGMENTATION_TAUX_FUITE);
		}
	}

	public void remove_pokehmon_stats(Choix choix) {

		if(choix instanceof Ball) {
			Ball b = (Ball) choix;
			if(this.type == b.estEfficaceContre() ) {
				this.augmenter_taux_capture(-choix.AUGMENTATION_TAUX_CAPTURE);
			}

		}else {
			this.augmenter_taux_capture(-choix.AUGMENTATION_TAUX_CAPTURE);
			this.augmenter_taux_fuite(-choix.AUGMENTATION_TAUX_FUITE);
		}
	}
}
