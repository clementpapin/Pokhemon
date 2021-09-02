package pokehmon;

public enum Choix {
	
	BALL("Vous tentez d'attraper le pokehmon"), COOKIE("Le pokehmon devient joyeux !"), CAILLOU("Le pokehmon s'énerve !"), FUITE("Vous prenez la fuite");
	

	
	private String res;
	
	private Choix(String r) {
		this.res = r;
	}
	
	public String getRes() {
		return this.res;
	}
	

}
