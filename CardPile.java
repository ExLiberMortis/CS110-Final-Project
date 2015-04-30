//~ Sam Rowell
//~ CS110 - Project
//~ CardPile class


import java.util.Random;
import java.util.ArrayList;

/* Represents a generic pile of cards */

public class CardPile
{
	public ArrayList<Card> cardPile;
	private final int CARDS_IN_DECK = 52;
	
/* This default no-arg constructor creates empty array list for 52 card objects
 */
	public CardPile()
	{
		cardPile = new ArrayList<Card>(CARDS_IN_DECK);
	}
	
/* This constructor creates empty array list for specified number of card objects
 * @param numOfCards A specific number of cards to create a CardPile of
 */
	public CardPile(int numOfCards)
	{
		cardPile = new ArrayList<Card>(numOfCards);
	}
	
/* Returns top card in pile
 * @return Top card of CardPile
 */ 
	public Card getCard()
   {
		Card c = cardPile.remove(0);  //  remove it (returns removed object)
		return c;
   }
   
/* Return number of cards left in pile
 * @return number of cards left in pile */
   public int cardsRemaining()
   {  
      return cardPile.size();
   }
   
   /** 
     * Determine if cardPile is empty
     * @return true if there are no more cards, false otherwise
     */
   
   public boolean isEmpty()
   {
      return (cardPile.size() == 0);
   }

/* Add card object to CardPile   
 * @pparam c Card object */
   public void add(Card c)
   {
	   cardPile.add(c);
   }
/* Add all cards of an array list to pile
 * @param pile An ArrayList of card objects */
   public void addAll(ArrayList<Card> pile)
   {
	   cardPile.addAll(pile);
   }
/* Returns the high card in a collection of cards
 * @param c1,c2 Card objects
 * @return The high card in the collection */   
    public static Card highCard(Card c1, Card c2)
   {
		Card[] cards = new Card[2];
		cards[0] = c1;
		cards[1] = c2;
		
      Card high = cards[0];
      for (int i=1;i<cards.length;i++)
      {
         if (cards[i].getRank() > high.getRank())
         {
         
            high = cards[i];
         }
      }
      return high;
   
   }
}

