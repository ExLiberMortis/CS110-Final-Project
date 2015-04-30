//~ Sam Rowell
//~ CS110 - Project
//~ GUI for War


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/* This class is used to create the GUI for the war game */
public class WarGui extends JFrame
{
	// initialize instance variables
    private War game; // the guts
    private Deck player1, player2;
    private CardPile pile = new CardPile();
    private boolean war = false;
    private String warFlag,flag;
    
    // create some of the GUI components
    private JPanel topPanel,bottomPanel;  
    
    private JButton next;   
    
    private JLabel status; 
    private JLabel title;   
    private JLabel player1Hand;
    private JLabel player1Deck;
    private JLabel player2Hand;
    private JLabel player2Deck;
    
    private ImageIcon cardBack; 
   
	
/* This constructor creates the framwork and layout for the GUI,
 *  and takes no arguments */ 	
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
        
        topPanel.setBackground(Color.green);  
        
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
/* The updateImageP1 method takes an argument for a card, and changes 
 * the image being displayed in the GUI to that card's image
 * @param c A Card object with an image tied to it
 */
	//update player1 hand image
	private void updateImageP1(Card c)
	{
		player1Hand.setIcon(new ImageIcon("Cards/"+ c.getImage()));
	}
/* The updateImageP2 method takes an argument for a card, and changes 
 * the image being displayed in the GUI to that card's image
 * @param c A Card object with an image tied to it
 */
	private void updateImageP2(Card c)
	{
		player2Hand.setIcon(new ImageIcon("Cards/"+ c.getImage()));
	}
			
/* The ButtonListener class reacts to button presses in the GUI */		
   // handle button events
   private class ButtonListener implements ActionListener
   {
/* The actionPerformed method reacts to the button being pressed 
 * during each round of play */	   
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
}
	

 
