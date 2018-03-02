package casinogames;

import java.util.ArrayList;

// Commenting this out for a bit as I don't have it on my computer.
//import javax.smartcardio.Card;

/**
 * Deck Object, representing a deck of play cards used for games.
 */
public class Deck {
	/** Array list used to hold the cards in the deck. */
    private ArrayList<Card> playDeck = new ArrayList<Card>();
    
    /** Array to hold the possible enum values for a Card. */
    private CardValue[] values = {CardValue.ACE, CardValue.TWO, 
    		CardValue.THREE, CardValue.FOUR, CardValue.FIVE, 
    		CardValue.SIX, CardValue.SEVEN, CardValue.EIGHT, 
    		CardValue.NINE, CardValue.TEN, CardValue.JACK, 
    		CardValue.QUEEN, CardValue.KING};
    
    /** Array to hold the posible enum suits for a Card. */
    private Suit[] suits = {Suit.CLUBS, Suit.DIAMONDS, 
    		Suit.HEARTS, Suit.SPADES};
    
    /**
     * Default constructor to generate a standard deck.
     */
    public Deck() {
    	Card card; 
    	
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 13; j++) {
    			card = new Card(values[j], suits[i]);
    			playDeck.add(card);
    		}
    	}
    }
    
    /**
     * Copy a deck.
     * 
     * @param otherDeck The deck that this deck is copying.
     */
    public Deck(final Deck otherDeck) {
    	for (int i = 0; i < otherDeck.getSize(); i++) {
    		playDeck.add(otherDeck.getCard(i));
    	}
    }
    
    /**
     * Generate an empty deck.
     * 
     * @param i Integer that makes sure an empty deck is
     * generated when 0 is passed.
     */
    public Deck(final int i) {
    	if (i != 0) {
    		System.err.println("Only 0 should be passed.");
    		System.exit(1);
    	}
    }
    
    /**
     * Get Method for a specific Card.
     * 
     * @param i Index of the card in playDeck.
     * 
     * @return The Card at index i.
     */
    public Card getCard(final int i) {
    	return playDeck.get(i);
    }
    
    /**
     * Draw a Card from the deck.
     * 
     * @return The top card of the deck.
     */
    public Card draw() {
    	Card card = playDeck.get(0);
    	playDeck.remove(0);
    	return card;
    }
    
    /**
     * Adds a Card to the deck.
     * 
     * @param card The card being added to the deck.
     */
    public void addCard(final Card card) {
    	playDeck.add(card);
    }
    
    /**
     * Remove a Card from the deck.
     * 
     * @param i Index of the card being removed.
     */
    public void removeCard(final int i) {
    	playDeck.remove(i);
    }
    
    /**
     * Empty the deck.
     */
    public void clearDeck() {
    	playDeck.clear();
    }
    
    /**
     * Return the number of cards in the deck.
     * 
     * @return Returns the number of cards in the deck.
     */
    public int getSize() {
    	return playDeck.size();
    }
}
