package pokehmon;

public class NormalBall extends Choix implements Ball {

	protected NormalBall() {
		super(0,10);
		
	}

	@Override
	public Type estEfficaceContre() {
		return Type.NORMAL;
	}
	
	public String toString() {
		return "Vous tentez d'attraper le pokehmon avec une Ball";
	}
	
	

}
