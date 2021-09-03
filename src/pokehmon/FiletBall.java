package pokehmon;

public class FiletBall extends Choix implements Ball{
	
	public FiletBall() {
		super(0,10);
	}
	
	public String toString() {
		return "Vous tentez d'attraper le pokehmon avec une FiletBall";
	}
	
	public Type estEfficaceContre() {
		return Type.EAU;
	}
}
