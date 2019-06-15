
public class Move {
	private char letter;
	private int x;
	private int y;
	public Move(char letter, int x, int y) {
		super();
		this.letter = letter;
		this.x = x;
		this.y = y;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return "x:" +x+",y:"+y+",lettter:"+letter;
	}
	
}
