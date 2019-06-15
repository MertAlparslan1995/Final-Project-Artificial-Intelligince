import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
public class Game {
	private Player player1;
	private Player player2;
	private int numberOfTilesRemaining;
    private Tile[] tilesArray = new Tile[26];
    private char[][] currentBoard = new char[15][15];
    private Stack<String> commandStack = new Stack<String>();
    private  List<Move> currentWord = new ArrayList<Move>(); 
    private  List<Move> bestComputerMove = null;
    private  int bestComputerScore =0;
	private Dictionary english = new Dictionary();
	

	
	

	public boolean hasNeighborOccupied(int i, int j) {
		
		
		if (i<14)
			if (currentBoard[i+1][j]!='-')
				return true;
		
		if (i>0)
			if (currentBoard[i-1][j]!='-')
				return true;
		
		if (j<14)
			if (currentBoard[i][j+1]!='-')
				return true;
		
		if (j>0)
			if (currentBoard[i][j-1]!='-')
				return true;
		
		return false;
	}
	
	private int getBoardCount() {
		int count=0;
		for (int i=0; i<15; i++) {
			for (int j=0; j<15; j++) {
				if(currentBoard[i][j]!='-' )
					count++;
			}
		}
		return count-currentWord.size();
	}
	
	private List<Move> findPlayableTiles(int i, int j, int direction, int numberOfTiles) {
		
		List<Move> possibleMoves = new ArrayList<Move>();
		boolean hasNeighbor=false;
		int count=0;
		while (count<numberOfTiles) {
			
			if(currentBoard[i][j]!='-') {
				if (direction==1) {
					i++;
					if (i==15)
						return null;
				} else {
					j++;
					if (j==15)
						return null;
				}
				continue;
			}
	
			Move m = new Move('-',i,j);
			possibleMoves.add(m);
			count++;			
			
			if (hasNeighborOccupied(i,j)==true) {
				hasNeighbor=true;
			}
			
			if (direction==1) {
				// 1 for vertical, 2 for horizontal
				i++;
				if (i==15)
					return null;
			} else {
				j++;
				if (j==15)
					return null;
			}
			
		}
		
		if (hasNeighbor)
			return possibleMoves;
		else if(getBoardCount()==0 )
		{
			for (Move mn:possibleMoves) {
				if (mn.getX()==7 && mn.getY()==7)
				{
					System.out.println(possibleMoves);
					return possibleMoves;
				}
						
			}

			return null;
		}
		
		else
			return null;
		
	}

	public void computerPermutations(List<Move> possibleMoves) {

		Subsequence.reset();
		Subsequence.subsequence(new String(player2.getTiles()));
		for (String s:Subsequence.getSt() ) {
			//System.out.println(s);
			if (s.length()==possibleMoves.size()) {
				for (String p:Subsequence.permutationFinder(s)) {
					for(int i=0; i<p.length();i++) {
						possibleMoves.get(i).setLetter(p.charAt(i));
						currentBoard[possibleMoves.get(i).getX()][possibleMoves.get(i).getY()]=p.charAt(i);				
					}
					int score=getScore(possibleMoves);
					for(int i=0; i<p.length();i++) {
						currentBoard[possibleMoves.get(i).getX()][possibleMoves.get(i).getY()]='-';				
					}
					if (score>bestComputerScore) {
						bestComputerMove =  new ArrayList<Move>();
						for (Move m:possibleMoves)
							bestComputerMove.add(new Move(m.getLetter(),m.getX(),m.getY()));
						
						bestComputerScore  = score;
						System.out.println(possibleMoves+" score:"+score);
					}

				}
			}
		}
	}

		
	
	public void computerAutoPlay() {
		for (int i=0;i<7;i++) {
			System.out.println(player2.getTile(i));
		}
		
		bestComputerMove = null;
		bestComputerScore = 0;
 
    	for (int i=1; i<14; i++) {
    		for (int j=1; j<14; j++) {
    			
    				List<Move> possibleMoves ;
    			
    			
    				possibleMoves = findPlayableTiles(i,j,1,2);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
    			
        			possibleMoves = findPlayableTiles(i,j,2,2);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			
    				possibleMoves = findPlayableTiles(i,j,1,3);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
    			
        			possibleMoves = findPlayableTiles(i,j,2,3);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,1,4);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,2,4);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,1,5);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,2,5);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,1,6);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,2,6);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,1,7);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
        			
        			possibleMoves = findPlayableTiles(i,j,2,7);
        			if (possibleMoves !=null)
        			{
        				computerPermutations(possibleMoves);
        			}
    						   	    	
    	    	
    			//player2.addScore(bestScore);   			
 			
    		}
    	}
    	if (bestComputerScore>0) {
    		//System.out.println(bestComputerMove);
    		player2.addScore(bestComputerScore);
    		for (Move m : bestComputerMove) {
    			currentBoard[m.getX()][m.getY()]=m.getLetter();
    			player2.removeTile(m.getLetter());
    		}
    	}
    	
    	fillEmptyTiles();	
	}
	
	public int getTileValue(char c) {
		for (int i=0;i<26;i++) {
			if (tilesArray[i].getLetter()==c )
				return tilesArray[i].getPoint(); 
		}
		return 0;
	}
	
    public void undo() {
    	for (Move m: currentWord) {
    		player1.addTile(m.getLetter());
    		currentBoard[m.getX()][m.getY()] ='-'; 
    		
    	}
    	currentWord.clear();
    }
    
    public boolean checkMove() {
    	
    	
    	if (currentWord.size()<2) 
    	{
    		undo();
    		return false;
    	}
    	
    	System.out.println(getBoardCount());
    	if(getBoardCount()==0) {
    		boolean firstmove=false;
        	for (Move m: currentWord) {
        		if (m.getX()==7 && m.getY()==7 )
        			firstmove=true;
        	}
        	if (!firstmove) {
        		undo();
        		return false;
        	}
    	}
    	
    	// check vertical and horizontal
    	boolean vertical = true;
    	boolean horizontal = true;
    	
    	int v= currentWord.get(0).getX();
    	int h=currentWord.get(0).getY();
    	for (Move m: currentWord) {
    		if (m.getX()!=v)
    			vertical=false;
    		if (m.getY()!=h)
    			horizontal=false;
    	}
    	
    	if (!vertical && !horizontal) {
    		undo();
    		return false;
    		
    	}
    	
    	
    	int score=getScore(currentWord);
    	if (score==0) {
    		undo();
    		return false;
    	}
    	
    	
    	// calculate points 
    	currentWord.clear();
    	commandStack.clear();
		player1.addScore(score);
		
		computerAutoPlay();
		fillEmptyTiles();		
    	return true;
    	
    }
    
    private int getScore(List<Move> currentWord) {
    	
    	//System.out.println("Word to be checked : "+currentWord);
    	List<String> wordsMade = new ArrayList<String>();
    	int score=0;
    	for (int i=0; i<15; i++) {
    		String newWord="";
    		boolean isNew=false;
    		for (int j=0; j<15; j++) {
    			
    			if (currentBoard[i][j]!='-') {
    				newWord+=currentBoard[i][j];
    		    	for (Move m: currentWord) {
    		    		if (m.getX()==i && m.getY()==j) {
    		    			isNew=true;
    		    			score+= getTileValue(m.getLetter())*Board.getScore(m.getX(), m.getY());
    		    		}
  		    			
    		    			
    		    	}
    			} else {
    				if (newWord.length()>=2) {
    					if (isNew) {
    						wordsMade.add(newWord);
    					}
    				} 
					newWord="";
					isNew=false;
				
    			}
    			
    		}
    	}
    	
    	for (int j=0; j<15; j++) {
    		String newWord="";
    		boolean isNew=false;
    		for (int i=0; i<15; i++) {
    			
    			if (currentBoard[i][j]!='-') {
    				newWord+=currentBoard[i][j];
    		    	for (Move m: currentWord) {
    		    		if (m.getX()==i)
    		    			isNew=true;
    		    		if (m.getY()==j)
    		    			isNew=true;
    		    	}
    			} else {
    				if (newWord.length()>=2) {
    					if (isNew ) {
    						wordsMade.add(newWord);
    					}
    				}
					newWord="";
					isNew=false;

    			}
    			
    		}
    	}
    	
    	if (wordsMade.size()==0) {
    		//undo();
    		return 0;
    	}
    	// check if all words are in dictionary
    	for(String word : wordsMade) {
    		
//    		System.out.println(word);
//    		System.out.println(english.checkWord(word));
    		
    		if (!english.checkWord(word)) {
    			//undo();
    			return 0;
    		}
    	}
    	return score;
    }
    
    
	private void createTiles() {
    	
    	tilesArray[0]=new Tile('A',1,9);
    	tilesArray[1]=new Tile('B',1,2);
    	tilesArray[2]=new Tile('C',1,2);
    	tilesArray[3]=new Tile('D',1,4);
    	tilesArray[4]=new Tile('E',1,12);
    	tilesArray[5]=new Tile('F',1,2);
    	tilesArray[6]=new Tile('G',1,3);
    	tilesArray[7]=new Tile('H',1,2);
    	tilesArray[8]=new Tile('I',1,9);
    	tilesArray[9]=new Tile('J',1,1);
    	tilesArray[10]=new Tile('K',1,1);
    	tilesArray[11]=new Tile('L',1,4);
    	tilesArray[12]=new Tile('M',1,2);
    	tilesArray[13]=new Tile('N',1,6);
    	tilesArray[14]=new Tile('O',1,8);
    	tilesArray[15]=new Tile('P',1,2);
    	tilesArray[16]=new Tile('Q',1,1);
    	tilesArray[17]=new Tile('R',1,6);
    	tilesArray[18]=new Tile('S',1,4);
    	tilesArray[19]=new Tile('T',1,6);
    	tilesArray[20]=new Tile('U',1,4);
    	tilesArray[21]=new Tile('V',1,2);
    	tilesArray[22]=new Tile('W',1,2);
    	tilesArray[23]=new Tile('X',1,1);
    	tilesArray[24]=new Tile('Y',1,2);
    	tilesArray[25]=new Tile('Z',1,1);
    	
    	numberOfTilesRemaining = 0;
    	for (int i=0; i<26; i++) {
    		numberOfTilesRemaining += tilesArray[i].getAvailable();  
    	}
    	
    }
    
    public char drawRandomTile() {
    	Random r = new Random();

    	int randomNumber = r.nextInt(numberOfTilesRemaining-1) + 1;
    	int tilesCount=0;
    	for (int i=0; i<26; i++) {
    		tilesCount += tilesArray[i].getAvailable();
    		if (tilesCount>=randomNumber) {
    			numberOfTilesRemaining--;
    			return tilesArray[i].getLetter();
    		}
    	}
    	
    	numberOfTilesRemaining--;
		return 0;

    }
    
    public void fillEmptyTiles() {
		for (int i=0; i<7; i++) {
				if (player1.getTile(i)=='-')
					player1.addTile(drawRandomTile());

				if (player2.getTile(i)=='-')
					player2.addTile(drawRandomTile());
		}	
    }
    
    public Game() {
   	 	english.fillDictionary();
    	player1 = new Player("Player 1");
    	player2 = new Player("Computer");
    	createTiles();
		for (int i=0; i<7; i++) {
			player1.addTile(drawRandomTile());
			player2.addTile(drawRandomTile()); 
		}	
		
//    	player1.addTile('A');
//    	player1.addTile('R');
//    	player1.addTile('E');
//    	player1.addTile('A');
//    	player1.addTile('R');
//    	player1.addTile('E');
//    	player1.addTile('I');
//    	
//    	player2.addTile('C');
//    	player2.addTile('O');
//    	player2.addTile('E');
//    	player2.addTile('M');
//    	player2.addTile('Z');
//    	player2.addTile('Z');
//    	player2.addTile('Z');
    	
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				currentBoard[i][j]='-';
			}
		}
    	
    	
    }
    
    public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getNumberOfTilesRemaining() {
		return numberOfTilesRemaining;
	}

	public Tile[] getTilesArray() {
		return tilesArray;
	}

	public char[][] getCurrentBoard() {
		return currentBoard;
	}


	public boolean addCommand(String command) {
		if (command.startsWith("Tile:")) {
			commandStack.add(command);
			return false;
		}
		if (command.startsWith("Cell:")) {
			if (commandStack.isEmpty()) {
				return false;
			}
			String lastCommand = commandStack.pop();
			if (!lastCommand.startsWith("Tile:")) {
				return false;
			}
			char letter;
			int x,y;
			letter = lastCommand.split(":")[1].charAt(0);
			x=Integer.parseInt(command.split(":")[1].split(",")[0]);
			y=Integer.parseInt(command.split(":")[1].split(",")[1]);
			
//			System.out.println(letter);
//			System.out.println(x);
//			System.out.println(y);
			
			currentBoard[x][y]=letter;
			player1.removeTile(letter);
			commandStack.clear();
			currentWord.add(new Move(letter,x,y));
			
			return true;
			
		}
		return false;
	}
}
