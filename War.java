import java.util.ArrayList;

public class War
{
	
		Deck masterDeck, deck1, deck2;
		Card player1, player2;
		final int PLAYER_DECK_SIZE = 26;
		 
		CardPile pile;
		
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
		
		public Deck getPlayer1()
		{
			return deck1;
		}
		public Deck getPlayer2()
		{
			return deck2;
		}
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
		
	
