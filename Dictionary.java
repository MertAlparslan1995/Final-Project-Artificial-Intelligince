import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
	private DawgNode head;
	private HashSet<String> dict=new HashSet<String>(); 

	public Dictionary() {
		super();
		this.head = null;
	}

	public void printDictionary() {
		if (head==null)
			System.out.println("Empty");
		else
			printDictionary(head);
	}
	
	public void printDictionary(DawgNode n) {
		System.out.println(n.getC());
		if (n.isEow())
			System.out.println("(eow)");	
		if (n.getChild()!=null){
			System.out.println("->");
			printDictionary(n.getChild());
		} 
		if (n.getNext()!=null) {
			System.out.println("|");
			printDictionary(n.getNext());
		
		}
	}
	
	public void addWord(String word) {
		word = word.toLowerCase();
		dict.add(word);
		

//		int index=0;
//		
//		if (head == null) {
//			DawgNode n = new DawgNode (word.charAt(0));
//			head = n;
//		}
//		
//		DawgNode currentNode = head;
//		DawgNode takipci = null;
//		while (currentNode != null && index<(word.length()-1)) {
//			if (word.charAt(index)==currentNode.getC()) {
//				takipci = currentNode; 
//				currentNode = currentNode.getChild();
//				index++;
//			} else {
//				takipci = currentNode; 
//				currentNode = currentNode.getNext();
//			}
//		}
//		
//		if (index==(word.length()-1) && currentNode!=null) {
//
//			if (currentNode.isEow()) {
//				//word found
//				return;
//			} else {
//				currentNode.setEow(true);
//				return;
//			}
//			
//		}
//		if(index==0) {
//			DawgNode n = new DawgNode (word.charAt(index));
//			takipci.setNext(n);
//			takipci=n;
//			index++;			
//			
//		}
//		else if(takipci.getC()!=word.charAt(index-1)) {
//			DawgNode n = new DawgNode (word.charAt(index));
//			takipci.setNext(n);
//			takipci=n;
//			index++;			
//		}
//		
//
//		while (index<=(word.length()-1)) {
//			DawgNode n = new DawgNode (word.charAt(index));
//			takipci.setChild(n);
//			takipci=n;
//			index++;
//		}
//		
//		takipci.setEow(true);
		
	}
	
	public boolean checkWord(String word) {
		word = word.toLowerCase();
		
		return dict.contains(word);

//		int index=0;
//		
//		if (head == null) {
//			DawgNode n = new DawgNode (word.charAt(0));
//			head = n;
//		}
//		
//		DawgNode currentNode = head;
//		DawgNode takipci = null;
//		while (currentNode != null && index<(word.length()-1)) {
//			if (word.charAt(index)==currentNode.getC()) {
//				takipci = currentNode; 
//				currentNode = currentNode.getChild();
//				index++;
//			} else {
//				currentNode = currentNode.getNext();
//			}
//		}
//		
//		if (index==(word.length()-1)) {
//			if (currentNode==null)
//				return false;
//			if (currentNode.isEow()) {
//				//word found
//				return true;
//			}
//		
//		}
//		return false;
		
	}
	
	public void fillDictionary()  {
		Path filePath = Paths.get("english.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(filePath);
			while (scanner.hasNext()) {
			    //System.out.println(scanner.next());
				addWord(scanner.next());
			    
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
