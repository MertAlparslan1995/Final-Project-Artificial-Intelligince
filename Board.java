import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Board {
	private Game game ;
	private JFrame board = new JFrame();
	private JPanel boardPanel ;
	private JPanel tilePanel ;
	private JPanel statusPanel ;
	
	
	
	public static Color getColor(int x,int y) {
		//Baþlangýç noktasý
		if (x==7 && y==7) {
			return Color.PINK;
		}
		// kýrmýzý hücrelerin koordinatlarý
		if ((x==0 && (y==0 || y==7 || y==14)) || (x==7 && (y==0 || y==14)) || (x==14 && (y==0 || y==7 || y==14))) {
			return Color.RED;
		}
		
		// Pembe hücrelerin koordinatlarý
		if ((x>0 && x==y && x<5)) {
			return Color.PINK;	
		} else if ((x>0 && x==14-y && x<5)) {
			return Color.PINK;	
		} else if ((x>9 && x==y && x<14)) {
			return Color.PINK;	
		} else if ((x>9 && x==14-y && x<14)) {
			return Color.PINK;	
		}
		
		// Mavi hücrelerin koordinatlarý
		if ((x==1 && (y==5 || y==9 )) || (x==5 && (y==1 || y==5 || y==9 || y==13)) || (x==9 && (y==1 || y==5 || y==9 || y==13)) || (x==13 && (y==5 || y==9 ))) {
			return Color.BLUE;
		}

		// Açýk Mavi hücrelerin koordinatlarý
		if ((x==0 && (y==3 || y==11 )) || (x==7 && (y==3 || y==11 )) || (x==14 && (y==3 || y==11 ))) {
			return Color.CYAN;
		}
		if ((x==2 && (y==6 || y==8 )) || (x==12 && (y==6 || y==8 ))) {
			return Color.CYAN;
		}
		if ((x==3 && (y==0 || y==7 || y==14 )) || (x==11 && (y==0 || y==7 || y==14 ))) {
			return Color.CYAN;
		}
		
		if ((x==6 && (y==2 || y==6 || y==8 || y==12 )) || (x==8 && (y==2 || y==6 || y==8 || y==12 ))) {
			return Color.CYAN;
		}
				
		
		return Color.GRAY;
		
	}
	
	public static int getScore(int x,int y) {
		//Baþlangýç noktasý
		if (x==7 && y==7) {
			return 3;
		}
		// kýrmýzý hücrelerin koordinatlarý
		if ((x==0 && (y==0 || y==7 || y==14)) || (x==7 && (y==0 || y==14)) || (x==14 && (y==0 || y==7 || y==14))) {
			return 5;
		}
		
		// Pembe hücrelerin koordinatlarý
		if ((x>0 && x==y && x<5)) {
			return 3;	
		} else if ((x>0 && x==14-y && x<5)) {
			return 3;	
		} else if ((x>9 && x==y && x<14)) {
			return 3;	
		} else if ((x>9 && x==14-y && x<14)) {
			return 3;	
		}
		
		// Mavi hücrelerin koordinatlarý
		if ((x==1 && (y==5 || y==9 )) || (x==5 && (y==1 || y==5 || y==9 || y==13)) || (x==9 && (y==1 || y==5 || y==9 || y==13)) || (x==13 && (y==5 || y==9 ))) {
			return 4;
		}

		// Açýk Mavi hücrelerin koordinatlarý
		if ((x==0 && (y==3 || y==11 )) || (x==7 && (y==3 || y==11 )) || (x==14 && (y==3 || y==11 ))) {
			return 2;
		}
		if ((x==2 && (y==6 || y==8 )) || (x==12 && (y==6 || y==8 ))) {
			return 2;
		}
		if ((x==3 && (y==0 || y==7 || y==14 )) || (x==11 && (y==0 || y==7 || y==14 ))) {
			return 2;
		}
		
		if ((x==6 && (y==2 || y==6 || y==8 || y==12 )) || (x==8 && (y==2 || y==6 || y==8 || y==12 ))) {
			return 2;
		}
				
		
		return 1;
		
	}
	
	public Board(Game g) {
		
		game = g;


		board.setSize(800, 600);
		
		setTilePanel();
		setBoardPanel();
		setStatusPanel();
		
		board.add(boardPanel,BorderLayout.CENTER);
		board.add(statusPanel,BorderLayout.NORTH);
		board.add(tilePanel,BorderLayout.EAST);

		
		board.setVisible(true);
	}
	public void setTilePanel() {
		tilePanel = new JPanel();
		tilePanel.setPreferredSize(new Dimension(100, 600));
		tilePanel.setLayout(new GridLayout(7, 1, 0, 0));
		for(int i = 0; i < 7; i++)
		{
			JButton temp = new JButton();
			char c = game.getPlayer1().getTile(i);
			temp.setText(Character.toString(c));
			temp.setFont(new Font("Courier", Font.BOLD,24));
			temp.setActionCommand("Tile:"+c);
			temp.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
				  game.addCommand(e.getActionCommand());
			  }
			});
			
			tilePanel.add(temp);
		}
		tilePanel.repaint();
	}
	
	public void setStatusPanel() {
		statusPanel = new JPanel();
		statusPanel.setPreferredSize(new Dimension(800, 50));
		statusPanel.add(new JLabel("Player :"));
		JLabel labelPlayer1Score = new JLabel(Integer.toString(game.getPlayer1().getScore()));
		JLabel labelPlayer2Score = new JLabel(Integer.toString(game.getPlayer2().getScore()));
		statusPanel.add(labelPlayer1Score );
		statusPanel.add(new JLabel(" /  Computer :"));
		statusPanel.add(labelPlayer2Score );
		
		statusPanel.add(new JButton(new AbstractAction("Try") {
		    public void actionPerformed(ActionEvent e) {
		    	if (game.checkMove() ) {
		    		labelPlayer1Score.setText(Integer.toString(game.getPlayer1().getScore()));
		    		labelPlayer2Score.setText(Integer.toString(game.getPlayer2().getScore()));
		    		
		    	}
			  	board.remove(boardPanel);
				board.remove(tilePanel);
				setTilePanel();
				setBoardPanel();
		  		
				
				board.add(boardPanel,BorderLayout.CENTER);
				board.add(tilePanel,BorderLayout.EAST);
				board.repaint();
				board.revalidate();
		    	
		    }
		}));
		statusPanel.add(new JButton(new AbstractAction("Undo") {
		    public void actionPerformed(ActionEvent e) {
		    	game.undo();	
		    	
			  	board.remove(boardPanel);
				board.remove(tilePanel);
				setTilePanel();
				setBoardPanel();
		  		
				
				board.add(boardPanel,BorderLayout.CENTER);
				board.add(tilePanel,BorderLayout.EAST);
				board.repaint();
				board.revalidate();
		    	
		    }
		}));
		statusPanel.add(new JButton(new AbstractAction("Pass") {
		    public void actionPerformed(ActionEvent e) {
		    	game.undo();	
		    	
		    	game.computerAutoPlay();
		    	labelPlayer1Score.setText(Integer.toString(game.getPlayer1().getScore()));
	    		labelPlayer2Score.setText(Integer.toString(game.getPlayer2().getScore()));
		    	
			  	board.remove(boardPanel);
				board.remove(tilePanel);
				setTilePanel();
				setBoardPanel();
		  		
				
				board.add(boardPanel,BorderLayout.CENTER);
				board.add(tilePanel,BorderLayout.EAST);
				board.repaint();
				board.revalidate();
		    	
		    }
		}));
		statusPanel.repaint();
	}
	public void setBoardPanel() {
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(15, 15, 0, 0));
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				JButton temp = new JButton();
				temp.setBackground(getColor(i,j));
				if (game.getCurrentBoard()[i][j]=='-') {
					temp.setActionCommand("Cell:"+i+","+j);
					temp.addActionListener(new ActionListener()
					{
					  public void actionPerformed(ActionEvent e)
					  {
						  System.out.println(e.getActionCommand());
						  	if (game.addCommand(e.getActionCommand())) {
							  	board.remove(boardPanel);
								board.remove(tilePanel);
								setTilePanel();
								setBoardPanel();
						  		
//						  		tilePanel = new JPanel();
//						  		tilePanel.repaint();
								
								board.add(boardPanel,BorderLayout.CENTER);
								board.add(tilePanel,BorderLayout.EAST);
								board.repaint();
								board.revalidate();
						  	}
					  }
					});
			

				} else {
					temp.setText(Character.toString(game.getCurrentBoard()[i][j]));
				}
				boardPanel.add(temp);	
				
			}	
		}
		boardPanel.setBackground(Color.BLACK);
		boardPanel.repaint();
	}
	
	
	
	public static void main(String[] args) {
		
		Game g = new Game();
		Board b= new Board(g);
		
		Dictionary d = new Dictionary ();
		d.fillDictionary();
		//System.out.println(Subsequence.permutationFinder("AREA"));
		


	}
	
}

