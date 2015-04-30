//~ Sam Rowell
//~ CS110 - Project
//~ Deck class


import java.util.Random;
import java.util.ArrayList;

/**
 * Representation of a Deck of cards. */
public class Deck extends CardPile
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   final int CARDS_IN_DECK = 52;
    // image names
   private int imageNameNum = 1;

   /** The collection of Cards */
   
   
  /* This constructor creates a deck of a user provided number of cards and calls
   * the superclass constructor* 
   * @param numOfCards The number of cards to be alloted for in the Deck */ 
   public Deck(int numOfCards)
   {
		super(numOfCards);
	}
	
/* This constructor creates a deck of cards by calling the no-arg superclass 
 * constructor and then setting the appropriate image values
 * */
  
	public Deck()
	{
		super();
		for (int r = 2; r<=Card.ACE; r++)
		{
			for (int s=Card.DIAMONDS; s<=Card.CLUBS;s++)
			{	
				String imageName = String.valueOf(imageNameNum) + ".png";
				super.add(new Card(r,s,imageName));
				imageNameNum++;
			}
		}	
   }
   /** 
     * Remove and return the top Card on the Deck
     * @return A reference to a Card that was top on the Deck
     */
   public Card dealCard()
   {
      return getCard();
   }
  
  
   
   /** 
     * Randomize the order of Cards in cardPile
     */

   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < cardPile.size(); i++)
      {
         randNum = r.nextInt(cardPile.size());
         temp = cardPile.get(i);
         cardPile.set(i,cardPile.get(randNum));
         cardPile.set(randNum,temp);
      }      
   }
  /* Return the number of cards left in the deck.
   * @return The number of cards remaining
   */ 
   public int cardsRemaining()
   {
	   return super.cardsRemaining();
   }
} 
  
