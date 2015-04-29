// GUI for War
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WarGui extends JFrame
{
    private War game; // the guts
    private Deck player1, player2;
    private CardPile pile = new CardPile();
    private boolean war = false;
    private String warFlag,flag;
    
    private JPanel topPanel,bottomPanel;  // break up regions
    
    private JButton next;   // buttons
    
    private JLabel status; // game status
    private JLabel title;   // static title
    private JLabel player1Hand;
    private JLabel player1Deck;
    private JLabel player2Hand;
    private JLabel player2Deck;
    
    private ImageIcon cardBack; 
   
	
	
	// build the GUI
    public WarGui()
    {
		setLayout(new GridLayout(2,1));
	    // create game instance
	    game = new War();
	    player1 = game.deck1;
	    player2 = game.deck2;
	    // setup containers and components
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,4));
		
		//~ topPanel.setBackground(Color.green);
		//~ bottomPanel.setBackground(Color.green);
		
		cardBack = new ImageIcon("Cards/back.png");
		
		player1Deck = new JLabel(cardBack);
		player2Deck = new JLabel(cardBack);
		player1Hand = new JLabel();
		player2Hand = new JLabel();
		
		topPanel.add(player2Deck); 
        topPanel.add(player2Hand);  
        topPanel.add(player1Hand);    
        topPanel.add(player1Deck);     
        
        bottomPanel = new JPanel(new GridLayout(2,1));
        status = new JLabel("Let's play WAR!",SwingConstants.CENTER);
        next = new JButton("Begin");
        next.addActionListener(new ButtonListener());   
		
		bottomPanel.add(status);
		bottomPanel.add(next);   
		
		this.add(topPanel);
		this.add(bottomPanel);
				
		bottomPanel.add(next);
		
		add(topPanel);
		add(bottomPanel);
	}
	
	//update player1 hand image
	private void updateImageP1(Card c)
	{
		player1Hand.setIcon(new ImageIcon("Cards/"+ c.getImage()));
	}
	
	private void updateImageP2(Card c)
	{
		player2Hand.setIcon(new ImageIcon("Cards/"+ c.getImage()));
	}
			
		
   // handle button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
			
			next.setText("Draw");
			Card p1Card = game.flip(player1);
			Card p2Card = game.flip(player2);
			updateImageP1(p1Card);
			updateImageP2(p2Card);

			pile.add(p1Card);
			pile.add(p2Card);  

			
			Card high = pile.highCard(p1Card,p2Card);
			// if war
			if(p1Card.getRank() == p2Card.getRank())
			{
				next.setText("WAR");
				status.setText("War has been declared!");
				// flip card face down
				Card facedown1 = game.flip(player1);
				pile.add(facedown1);
				Card facedown2 = game.flip(player2);
				pile.add(facedown2);
				war = true;
			}	
			// else, if player one wins	


			else if(p1Card.getRank() == high.getRank())
			{
				
				while(!pile.isEmpty())
				{
					player1.add(pile.getCard());
				}
				warFlag = "Player 1 won the war!";
				flag = "Player 1 won this round!";
				if(war)
				{
					flag = warFlag;
				}
				
				String updatedMsg = "<html><br>" + flag + "<br>Player 1's cards remaining: " + player1.cardsRemaining() + "<br>Player 2's cards remaining: " + player2.cardsRemaining() + "</html>";
				status.setText(updatedMsg);
				war = false;
               
				
			}
			// else, if player two wins
			else if(p2Card.getRank() == high.getRank())
			{
				while(!pile.isEmpty())
				{
					player2.add(pile.getCard());
				}
				warFlag = "Player 2 won the war!";
				flag = "Player 2 won this round!";
				if(war)
				{
					flag = warFlag;
				}
				String updatedMsg = "<html><br>" + flag + "<br>Player 1's cards remaining: " + player1.cardsRemaining() + "<br>Player 2's cards remaining: " + player2.cardsRemaining() + "</html>";
				status.setText(updatedMsg);
				war = false;
				
			}
		}
	}
	
	//~ private class WarButtonListener implements ActionListener
	//~ {
    //~ 
   //~ 
		//~ public void actionPerformed(ActionEvent e)
		//~ {
		//~ // disable all buttons
		//~ // private method of TicTacToe class
		//~ // not static because it accesses instance variables
	private void disableAll()
	{
		next.setEnabled(false);
	} 
}
	

 
