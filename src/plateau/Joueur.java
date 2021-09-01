package plateau;

public class Joueur {
	private int x,y;
	private int nbPas;
	private int score;
	
	public Joueur(int x, int y) {
		this.x = x;
		this.y = y;
		this.nbPas = 0;
		this.score = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNbPas() {
		return nbPas;
	}

	public void setNbPas(int nbPas) {
		this.nbPas = nbPas;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
