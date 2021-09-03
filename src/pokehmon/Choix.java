package pokehmon;

public abstract class Choix {
	public final double AUGMENTATION_TAUX_FUITE;
	public final double AUGMENTATION_TAUX_CAPTURE;
	
	protected Choix(final double AUGMENTATION_TAUX_FUITE, final double AUGMENTATION_TAUX_CAPTURE) {
		this.AUGMENTATION_TAUX_FUITE = AUGMENTATION_TAUX_FUITE;
		this.AUGMENTATION_TAUX_CAPTURE = AUGMENTATION_TAUX_CAPTURE;
	}
}
