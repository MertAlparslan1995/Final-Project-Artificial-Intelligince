
public class DawgNode {

	private char c;
	private DawgNode next;
	private DawgNode child;
	private boolean eow;
	
	public DawgNode(char c, DawgNode next, DawgNode child, boolean eow) {
		super();
		this.c = c;
		this.next = next;
		this.child = child;
		this.eow = eow;
	}
	public DawgNode(char c ) {
		super();
		this.c = c;
		this.next = null;
		this.child = null;
		this.eow = false;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public DawgNode getNext() {
		return next;
	}
	public void setNext(DawgNode next) {
		this.next = next;
	}
	public DawgNode getChild() {
		return child;
	}
	public void setChild(DawgNode child) {
		this.child = child;
	}
	public boolean isEow() {
		return eow;
	}
	public void setEow(boolean eow) {
		this.eow = eow;
	}
	
}
