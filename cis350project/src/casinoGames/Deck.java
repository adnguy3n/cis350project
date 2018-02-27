package casinoGames;

import java.util.ArrayList;

// Commenting this out for a bit as I don't have it on my computer.
//import javax.smartcardio.Card;

/**
 * Deck Object, representing a deck of play cards used for games.
 */
public class Deck
{
	/* Array list used to hold the cards in the deck */
    private ArrayList<Card> playDeck = new ArrayList<Card>();
    
    /* Array to hold the possible enum values for a Card */
    private CardValue values[] = {CardValue.ACE, CardValue.TWO, 
    		CardValue.THREE, CardValue.FOUR, CardValue.FIVE, 
    		CardValue.SIX, CardValue.SEVEN, CardValue.EIGHT, 
    		CardValue.NINE, CardValue.TEN, CardValue.JACK, 
    		CardValue.QUEEN, CardValue.KING};
    
    /* Array to hold the posible enum suits for a Card */
    private Suit suits[] = {Suit.CLUBS, Suit.DIAMONDS, 
    		Suit.HEARTS, Suit.SPADES};
    
    /**
     * Default constructor to generate a standard deck.
     */
    public Deck() 
    {
    	Card Card; 
    	
    	for (int i = 0; i < 4; i++)
    	{
    		for (int j = 0; j < 13; j++)
    		{
    			Card = new Card(values[j], suits[i]);
    			playDeck.add(Card);
    		}
    	}
    }
    
    /**
     * Copy a deck.
     * 
     * @param otherDeck
     */
    public Deck(Deck otherDeck)
    {
    	for (int i = 0; i < otherDeck.getSize(); i++)
    	{
    		playDeck.add(otherDeck.getCard(i));
    	}
    }
    
    /**
     * Generate an empty deck.
     */
    public Deck(int i)
    {
    	if (i != 0)
    	{
    		System.err.println("Only 0 should be passed.");
    		System.exit(1);
    	}
    }
    
    /**
     * Get Method for a specific Card.
     * 
     * @param i
     */
    public Card getCard(int i)
    {
    	return playDeck.get(i);
    }
    
    /**
     * Draw a Card from the deck.
     */
    public Card draw()
    {
    	Card Card = playDeck.get(0);
    	playDeck.remove(0);
    	return Card;
    }
    
    /**
     * Adds a Card to the deck.
     * 
     * @param Card
     */
    public void addCard(Card Card)
    {
    	playDeck.add(Card);
    }
    
    /**
     * Remove a Card from the deck.
     * 
     * @param i
     */
    public void removeCard(int i)
    {
    	playDeck.remove(i);
    }
    
    /**
     * Empty the deck.
     */
    public void clearDeck()
    {
    	playDeck.clear();
    }
    
    /**
     * Return the number of cards in the deck.
     */
    public int getSize()
    {
    	return playDeck.size();
    }
}
