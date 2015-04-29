/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * @author Sam Rowell
 */

import java.util.Random;
import java.util.ArrayList;

public class Deck extends CardPile
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   final int CARDS_IN_DECK = 52;
    // image names
   private int imageNameNum = 1;

   /** The collection of Cards */
   // private CardPile deck;
   
  
   public Deck(int numOfCards)
   {
		super(numOfCards);
	}
	
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
   
   public int cardsRemaining()
   {
	   return super.cardsRemaining();
   }
} 
  
