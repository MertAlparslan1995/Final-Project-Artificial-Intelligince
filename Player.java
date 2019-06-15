
public class Player {
	private int score;
	private String name;
	private char[] tiles = new char[7];
	public int getScore() {
		return score;
	}
	public void addScore(int s) {
		score+=s;
	}

	public String getName() {
		return name;
	}

	public char[] getTiles() {
		return tiles;
	}
	public char getTile(int i) {
		return tiles[i];
	}

	public Player(String name) {
		this.name = name;
		score = 0;
		for (int i=0; i<7; i++) {
			tiles[i] ='-'; 
		}
	}
	
	// ilk boþ bulduðu yere ekle
	public void addTile(char t) {
		for (int i=0; i<7; i++) {
			if (tiles[i] =='-') {
				tiles[i] =t;
				break;
			}; 
		}		
	}
	
	public void removeTile(char t) {
		for (int i=0; i<7; i++) {
			if (tiles[i] ==t) {
				tiles[i] ='-';
				break;
			}; 
		}		
	}
	

}
