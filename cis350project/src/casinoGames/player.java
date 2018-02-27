package casinoGames;

import java.util.ArrayList;
/**
 * Object representing a player in a game.
 */
public class player {
	private ArrayList<Card> hand;
	
	/**
	 * Default Constructor, creates a player with an empty hand.
	 */
	public player()
	{
		hand = new ArrayList<Card>();
	}
	
	/**
	 * Add Card to hand.
	 */
	public void addToHand(Card Card)
	{
		hand.add(Card);
	}
	
	/**
	 * DisCard hand.
	 */
	public void clearHand()
	{
		hand.clear();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	/**
	 * Get number of Cards in hand.
	 */
	public int getHandSize()
	{
		return hand.size();
	}
	
	/**
	 * Get specific Card in hand.
	 */
	public Card getCard(int i)
	{
		return hand.get(i);
	}
	
	/**
	 * get method for the value of 
	 */
	public int getHandValue()
	{
		int CardValue = 0;
		boolean hasAce = false;
		for (int i = 0; i < hand.size(); i++)
		{
			switch(hand.get(i).getValue())
			{
				case ACE:
					CardValue += 1;
					hasAce = true;
					break;
				
				case TWO:
					CardValue += 2;
					break;
					
				case THREE:
					CardValue += 3;
					break;
					
				case FOUR:
					CardValue += 4;
					break;
					
				case FIVE:
					CardValue += 5;
					break;
					
				case SIX:
					CardValue += 6;
					break;
					
				case SEVEN:
					CardValue += 7;
					break;
					
				case EIGHT:
					CardValue += 8;
					break;
					
				case NINE:
					CardValue += 9;
					break;
					
				case TEN:
					CardValue += 10;
					break;
					
				case JACK:
					CardValue += 10;
					break;
					
				case QUEEN:
					CardValue += 10;
					break;
					
				case KING:
					CardValue += 10;
					break;
			}
		}
		
		if (hasAce == true && CardValue < 12)
		{
			CardValue += 10;
		}
		
		return CardValue;
	}
}
