package casinogames;

import java.util.ArrayList;
/**
 * Object representing a player in a game.
 */
public class Player {
	/** Array List representing the player's hand.*/
	private ArrayList<Card> hand;
	/** integer representing the player's cash. */
	private int balance;
	
	/**
	 * Default Constructor, creates a player with an empty hand.
	 */
	public Player() {
		hand = new ArrayList<Card>();
		balance = 5000;
	}
	
	/**
	 * Add Card to hand.
	 * 
	 * @param card The card to be added to the player's hand.
	 */
	public void addToHand(final Card card) {
		hand.add(card);
	}
	
	/**get held cards method */
	public ArrayList<Boolean> getHolding(){
		return holding;
	}
	
	/**
	 * Add Card to hand at index.
	 * 
	 * @param card The card to be added to the player's hand.
	 * @param index The index at which the card is added to the
	 * player's hand.
	 */
	public void addToHand(final Card card, final int index) {
		hand.add(index, card);
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
	 * Get method for the player's current balance.
	 * @return balance the current amount of money the player has.
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Method for adding to a player's balance.
	 * @param winnings the amount of money the player won.
	 */
	public void addBalance(final int winnings) {
		balance += winnings;
	}
	
	/**
	 * Method for subtracting from a player's balance.
	 * @param loss the amount of money the player lost.
	 */
	public void subBalance(final int loss) {
		balance -= loss;
	}
}
