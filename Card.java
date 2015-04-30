//~ Sam Rowell
//~ CS110 - Project
//~ Card class


/* Represents a playing card */
public class Card
{
	// instance variables
	public static final int DIAMONDS = 15, HEARTS = 16, SPADES = 17, CLUBS = 18,   
							JACK = 11, QUEEN = 12, KING = 13, ACE = 14;
	private int rank, suit;
	private String image;

/**
This constructor creates a card with a suit, rank, and image
* @param rank A card's rank
* @param suit A card's suit
* @param image A card's front image
*/
	public Card(int rank, int suit, String image)
	{
		//rank
		if (rank == 11)
		{
			this.rank = Card.JACK; 
		}
		else if (rank == 12)
		{
			this.rank = Card.QUEEN;
		}
		else if (rank == 13)
		{
			this.rank = Card.KING;
		}
		else if (rank == 14)
		{
			this.rank = Card.ACE;
		}
		else
		{
			this.rank = rank;
		}

		// suit
		if (suit == 15)
		{
			this.suit = Card.DIAMONDS; 
		}
		else if (suit == 16)
		{
			this.suit = Card.HEARTS;
		}
		else if (suit == 17)
		{
			this.suit = Card.SPADES;
		}
		else if (suit == 18)
		{
			this.suit = Card.CLUBS;
		}
		
		// image
		this.image = image;
	}
/**
The getSuit method returns the suit of the card object as an integer
@return The card's suit value [15-18]
*/
	public int getSuit()
	{
		return this.suit;
	}
/**
The getRank method returns the rank of the card object as an integer
@return The card's rank value [1-13]
*/
	public int getRank()
	{
		return this.rank;
	}
	
/**
The getImage method returns the file name of the image
* @return The cards image
*/
	public String getImage()
	{
		return image;
	}

 
/** The rankToString method returns the card's rank as a string
 * @return The card's rank */
	public String rankToString()
	{
		switch ( rank ) 
		{
           case 14:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default:  return "??";
        }
	}
/** The suitToString method returns the card's suit as a string
 * @return The card's suit */
	public String suitToString()
	{
        switch ( suit ) 
        {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "??";
        }
	}
/* The toString method returns the full name of the card
 * @return The card's full name as a string */	
	public String toString()
	{
		return this.rankToString() + " of " + this.suitToString();
	}
/**
The equals method returns a boolean value as to whether two card objects are of equal rank
@return Whether the two cards are of equal rank or not (T/F)
*/
	public boolean equals(Card otherCard)
	{
		boolean sameRank;
		if (rank == otherCard.rank)
		{
			sameRank = true;
		}
		else
		{
			sameRank = false;
		}
		return sameRank;
	}
}
