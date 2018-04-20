package casinogames;
/**
 * Card Object used to represent the various cards in a playing deck.
 */
public class Card {
	/** The value of a card (e.g. King, Ace, Two, Nine, etc.) */
	private CardValue value;
	/** The suit of a card: Hearts, Spades, Diamonds, or Clubs. */
	private Suit suit;
	/** Boolean for whether the player holds this card or not. */ 
	private boolean hold = false;
	
	/**
	 * Constructor, initializes the card with its value and suite.
	 * 
	 * @param cardValue value of the card (e.g. ACE, KING, QUEEN, etc.).
	 * 
	 * @param cardSuit the suit of the card (e.g. SPADES, CLUBS, etc.).
	 */
	public Card(final CardValue cardValue, final Suit cardSuit) {
		value = cardValue;
		suit = cardSuit;
	}
	
	/**
	 * Get method for value, returns value when called.
	 * 
	 * @return The value of this card.
	 */
	public CardValue getValue() {
		return value;
	}
	
	/**
	 * Get method for suite, returns suite when called.
	 * 
	 * @return Returns the suit of this card.
	 */
	public Suit getsuit() {
		return suit;
	}
	
	/**
	 * Get method for hold status.
	 * 
	 * @return hold boolean for hold status
	 */
	public boolean gethold() {
		return hold;
	}
	
	/**
	 * Flip method for hold status.
	 * 
	 * @return opposite of previous hold status
	 */
	public void fliphold(){
		hold=!hold;
	}
	
	/**
	 * Get Method for the value and suit of a card as a string.
	 * Example: "KING OF HEARTS."
	 * 
	 * @return THe value and suit of the card in one string.
	 */
	public String getCardString() {
		return (value + " OF " + suit);
	}
}
