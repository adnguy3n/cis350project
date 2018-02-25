package casinoGames;

import java.util.ArrayList;

// Commenting this out for a bit as I don't have it on my computer.
//import javax.smartcardio.Card;

public class deck 
{
	/* Array list used to hold the cards in the deck */
    private ArrayList<card> playDeck = new ArrayList<card>();
    
    /* Array to hold the possible enum values for a card */
    private CardValue values[] = {CardValue.ACE, CardValue.TWO, 
    		CardValue.THREE, CardValue.FOUR, CardValue.FIVE, 
    		CardValue.SIX, CardValue.SEVEN, CardValue.EIGHT, 
    		CardValue.NINE, CardValue.TEN, CardValue.JACK, 
    		CardValue.QUEEN, CardValue.KING};
    
    /* Array to hold the posible enum suits for a card */
    private Suit suits[] = {Suit.CLUBS, Suit.DIAMONDS, 
    		Suit.HEARTS, Suit.SPADES};
    
    /*
     * Default constructor to generate a standard deck.
     */
    public deck() 
    {
    	card card; 
    	
    	for (int i = 0; i < 4; i++)
    	{
    		for (int j = 0; j < 13; j++)
    		{
    			card = new card(values[j], suits[i]);
    			playDeck.add(card);
    		}
    	}
    }
    
    /*
     * Copy a deck.
     * 
     * @param otherDeck
     */
    public deck(deck otherDeck) 
    {
    	for (int i = 0; i < otherDeck.getSize(); i++)
    	{
    		playDeck.add(otherDeck.getCard(i));
    	}
    }
    
    /*
     * Generate an empty deck.
     */
    public deck(int i) 
    {
    	if (i != 0)
    	{
    		System.err.println("Only 0 should be passed.");
    		System.exit(1);
    	}
    }
    
    /*
     * Get Method for a specific card.
     */
    public card getCard(int i)
    {
    	return playDeck.get(i);
    }
    
    /*
     * Draw a card from the deck.
     */
    public card draw()
    {
    	card card = playDeck.get(0);
    	playDeck.remove(0);
    	return card;
    }
    
    /*
     * Adds a card to the deck.
     * 
     * @param card
     */
    public void addCard(card card)
    {
    	playDeck.add(card);
    }
    
    /*
     * Remove a card from the deck.
     * 
     * @param i
     */
    public void removeCard(int i)
    {
    	playDeck.remove(i);
    }
    
    /*
     * Return the number of cards in the deck.
     */
    public int getSize()
    {
    	return playDeck.size();
    }
}
