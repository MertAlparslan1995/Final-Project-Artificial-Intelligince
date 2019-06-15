
public class Tile {
	private char letter;
	private int point;
	private int available;
	public Tile(char letter, int point, int available) {
		super();
		this.letter = letter;
		this.point = point;
		this.available = available;
	}
	public char getLetter() {
		return letter;
	}

	public int getPoint() {
		return point;
	}

	public int getAvailable() {
		return available;
	}

}
