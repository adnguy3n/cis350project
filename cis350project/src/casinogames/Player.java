package casinogames;

import java.util.ArrayList;
/**
 * Object representing a player in a game.
 */
public class Player {
	/** Array List representing the player's hand.*/
	private ArrayList<Card> hand;
	/** integer representing the player's cash. */
	private static final int balance = 5000;
	
	/**
	 * Default Constructor, creates a player with an empty hand.
	 */
	public Player() {
		hand = new ArrayList<Card>();
	}
	
	/**
	 * Add Card to hand.
	 * 
	 * @param card The card to be added to the player's hand.
	 */
	public void addToHand(final Card card) {
		hand.add(card);
	}
	
	/**
	 * Discard hand.
	 */
	public void clearHand() {
		hand.clear();
	}
	
	/**
	 * Get Method for the player's hand.
	 * 
	 * @return The player's hand.
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public int getBalance(){
		return balance;
	}
	
	/**
	 * Get number of Cards in hand.
	 * 
	 * @return The number of cards in the player's hand.
	 */
	public int getHandSize() {
		return hand.size();
	}
	
	/**
	 * Get specific Card in hand.
	 * 
	 * @param i The index of the card being returned.
	 * 
	 * @return The card at index i.
	 */
	public Card getCard(final int i) {
		return hand.get(i);
	}
	
	/**
	 * Get method for the value of the player's hand.
	 * 
	 * @return The value of the player's hand.
	 */
	public int getHandValue() {
		int cardValue = 0;
		boolean hasAce = false;
		for (int i = 0; i < hand.size(); i++) {
			switch (hand.get(i).getValue()) {
			
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
			default:
				break;
			}
		}
		
		if (hasAce && cardValue < 12) {
			cardValue += 10;
		}
		
		return cardValue;
	}
}
