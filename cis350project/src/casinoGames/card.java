package casinoGames;
/*
 * Card Object used to represent the various cards in a playing deck.
 */
public class card {
	/* The value of a card (e.g. King, Ace, Two, Nine, etc.) */
	private String value;
	/* The suite of a card: Hearts, Spades, Diamonds, or Clubs */
	private String suit;
	
	/*
	 * Constructor, initializes the card with its value and suite.
	 * 
	 * @param value
	 * @param suite
	 */
	public card(String value, String suite) 
	{
		this.value = value;
		this.suit = suite;
	}
	
	/*
	 * Get method for value, returns value when called.
	 */
	public String getValue()
	{
		return value;
	}
	
	/*
	 * Get method for suite, returns suite when called.
	 */
	public String getsuit()
	{
		return suit;
	}
}
