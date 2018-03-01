package casinogames;
/*
 * Card Object used to represent the various cards in a playing deck.
 */
public class Card 
{
	/* The value of a card (e.g. King, Ace, Two, Nine, etc.) */
	private CardValue value;
	/* The suit of a card: Hearts, Spades, Diamonds, or Clubs */
	private Suit suit;
	
	/**
	 * Constructor, initializes the card with its value and suite.
	 * 
	 * @param value
	 * @param suit
	 */
	public Card(CardValue value, Suit suit) 
	{
		this.value = value;
		this.suit = suit;
	}
	
	/**
	 * Get method for value, returns value when called.
	 */
	public CardValue getValue()
	{
		return value;
	}
	
	/**
	 * Get method for suite, returns suite when called.
	 */
	public Suit getsuit()
	{
		return suit;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCardString()
	{
		return (value + " OF " + suit);
	}
}
