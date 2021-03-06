package casinogames;
/**
 * Card Object used to represent the various cards in a playing deck.
 */
public class Card {
	/** The value of a card (e.g. King, Ace, Two, Nine, etc.) */
	private CardValue value;
	/** The suit of a card: Hearts, Spades, Diamonds, or Clubs. */
	private Suit suit;
	
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

}
