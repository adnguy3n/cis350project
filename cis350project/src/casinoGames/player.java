package casinoGames;

import java.util.ArrayList;

public class player {
	private ArrayList<card> hand = new ArrayList<card>();
	
	/*
	 * Default Constructor, creates a player with an empty hand.
	 */
	public player()
	{
		
	}
	
	/*
	 * Add card to hand.
	 */
	public void addToHand(card card)
	{
		hand.add(card);
	}
	
	/*
	 * Discard hand.
	 */
	public void clearHand()
	{
		hand.clear();
	}
	
	/*
	 * Get number of cards in hand.
	 */
	public int getHandSize()
	{
		return hand.size();
	}
	
	/*
	 * Get specific card in hand.
	 */
	public card getCard(int i)
	{
		return hand.get(i);
	}
	
	/*
	 * 
	 */
	public int getHandValue()
	{
		int cardValue = 0;
		boolean hasAce = false;
		for (int i = 0; i < hand.size(); i++)
		{
			switch(hand.get(i).getValue())
			{
				case ACE:
					cardValue += 1;
					hasAce = true;
					break;
				
				case TWO:
					cardValue += 2;
					break;
					
				case THREE:
					cardValue += 3;
					break;
					
				case FOUR:
					cardValue += 4;
					break;
					
				case FIVE:
					cardValue += 5;
					break;
					
				case SIX:
					cardValue += 6;
					break;
					
				case SEVEN:
					cardValue += 7;
					break;
					
				case EIGHT:
					cardValue += 8;
					break;
					
				case NINE:
					cardValue += 9;
					break;
					
				case TEN:
					cardValue += 10;
					break;
					
				case JACK:
					cardValue += 10;
					break;
					
				case QUEEN:
					cardValue += 10;
					break;
					
				case KING:
					cardValue += 10;
					break;
			}
		}
		
		if (hasAce == true && cardValue < 12)
		{
			cardValue += 10;
		}
		
		return cardValue;
	}
}
