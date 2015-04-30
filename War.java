//~ Sam Rowell
//~ CS110 - Project
//~ War class - replicates a game of the card game war

import java.util.ArrayList;
/* This War class represents a card game of War with the logical methods
 * necessary to play the game */
public class War
{
		// initialize instance variables
		Deck masterDeck, deck1, deck2;
		Card player1, player2;
		final int PLAYER_DECK_SIZE = 26;
		 
		CardPile pile;
/* This constrctor takes no arguements and creates an instance of the War game
 * by creating a deck of 52 cards, shuffling them, and then dividing them
 * between two players. */		
		public War()
		{
			// create new master deck
			masterDeck = new Deck();
			masterDeck.shuffle();
		
			// create empty 26 card decks for each player
			deck1 = new Deck(PLAYER_DECK_SIZE);
			deck2 = new Deck(PLAYER_DECK_SIZE);
		
			// create pile for cards in play
			pile = new CardPile();
		
			// split deck between players
			while(!masterDeck.isEmpty())
			{
				deck1.add(masterDeck.getCard());
				deck2.add(masterDeck.getCard());
			}
			
			// shuffle players decks
			deck1.shuffle();
			deck2.shuffle();
		}

/* The getPlayer1 method takes no arguments and returns the deck created for Player 1
 * @return The deck created for Player 1*/
		public Deck getPlayer1()
		{
			return deck1;
		}
		
/* The getPlayer2 method takes no arguments and returns the deck created for Player 2
 * @return The deck created for Player 2*/		
		public Deck getPlayer2()
		{
			return deck2;
		}

/* The flip method takes a Deck object as an argument and returns the top card off
 * of the deck.
 * @param d A Deck object with at least 1 card in it
 * @return The top card from the deck */
		public Card flip(Deck d)
		{
			return d.dealCard();
		}
		
		
		
	}
		
			
			
		
		
		
		
		
		
		
		
				
		
		
		
		
		
		//~ // while both players have cards left...
		//~ while(!deck1.isEmpty() && !deck2.isEmpty())
		//~ {
			//~ 
			//~ player1 = deck1.dealCard();
			//~ pile.add(player1);
			//~ player2 = deck2.dealCard();
			//~ pile.add(player2);
			//~ 
			//~ Card high = pile.highCard(pile.getCard(),pile.getCard());
			//~ // if war
			//~ if(player1.getRank() == player2.getRank())
			//~ {
				//~ // flip card face down
				//~ Card facedown1 = deck1.dealCard();
				//~ pile.add(facedown1);
				//~ Card facedown2 = deck2.dealCard();
				//~ pile.add(facedown2);
			//~ }	
			//~ // else, if player one wins	
			//~ 
			//~ 
			//~ else if(player1.getRank() == high.getRank())
			//~ {
				//~ System.out.println("Player 1 win");
			//~ 
				//~ while(!pile.isEmpty())
				//~ {
					//~ deck1.add(pile.getCard());
				//~ }
			//~ }
			//~ // else, if player two wins
			//~ else if(player2.getRank() == pile.highCard(player1,player2).getRank())
			//~ {
				//~ System.out.println("Player 2 win");
				//~ while(!pile.isEmpty())
				//~ {
					//~ deck2.add(pile.getCard());
				//~ }
			//~ }
		//~ 
		//~ }
		//~ 
		//~ 
	//~ }
//~ }
//~ 
//~ /* Basic outline of game of War */
//~ 
//~ //// split deck between 2 players, shuffle those
//~ //// while cards left
	//~ /// each player flips a card
	//~ /// check rank
	//~ /// if same rank (war!)
		//~ // flip card face down
		
	
