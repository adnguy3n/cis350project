package casinogames;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

/**
 * Logic Model for Black Jack. Contains all of the
 * necessary rules to play the game.
 */
public class CasinoGamesBlackJackModel {
	/** Dealer Object.*/
	private Player theDealer = new Player();
	/** player 1 Object.*/
	private Player player1 = new Player();
	/** Array List of players, including the dealer.*/
	private ArrayList<Player> playerList = new ArrayList<Player>();
	/** Standard Non-Shuffled Play Deck.*/
	private Deck standardDeck = new Deck();
	/** Number of Standard Decks that comprises the deck in use.*/
	private int numOfDeck;
	/** Deck being used. */
	private Deck mainDeck = new Deck(0);
	/** Current player Turn Flag: 1 for player 1, 0 for Dealer.*/
	private int turn;
	/** The current wager. */
	private int wager;
	
	
	/**
	 * Default Constructor for Blackjack.
	 * 
	 * @param n The number of decks used to form the main deck.
	 */
	public CasinoGamesBlackJackModel(final int n) {
		numOfDeck = n;
		generateDeck(numOfDeck);
		playerList.add(theDealer);
		playerList.add(player1);
	}
	
	/**
	 * Sets the turn to player 1 and deals everyone 2 cards.
	 */
	public void startGame() {
		turn = 1;
		deal();
	}
	
	/**
	 * Generates a shuffled deck to be played with.
	 * 
	 * @param decks The number of standard playing decks 
	 * being used to form the main deck.
	 */
	private void generateDeck(final int decks) {
		int numOfCards = 52 * decks;
		Deck deck = new Deck(standardDeck);
		int randCard;
		mainDeck.clearDeck();
		
		for (int i = 0; i < numOfCards; i++) {
			randCard = ThreadLocalRandom.current().
					nextInt(0, deck.getSize());
			mainDeck.addCard(deck.getCard(randCard));
			deck.removeCard(randCard);
			if (deck.getSize() == 0) {
				deck = new Deck(standardDeck);
			}
		}
	}
	
	
	/**
	 * Deal starting hand.
	 */
	private void deal() {
		if (mainDeck.getSize() < 34) {
			System.out.println("Shuffling Deck.");
			generateDeck(numOfDeck);
		}
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		theDealer.addToHand(mainDeck.draw());
		theDealer.addToHand(mainDeck.draw());
	}
	
	/**
	 * Method for when a player hits. Draws them a card.
	 */
	public void hit() {
		switch (turn) {
			case 0:
				theDealer.addToHand(mainDeck.draw());
				break;
			
			case 1:
				player1.addToHand(mainDeck.draw());
				break;
			
			default:
				break;
		}
	}
	
	/**
	 * Method for when a player stands. Changes the turn player.
	 */
	public void stand() {
		switch (turn) {
		case 0:
			turn = 1;
			break;
		
		case 1:
			turn = 0;
			break;
			
		default:
			break;
		}
	}
	
	/**
	 * Gets whose turn it is.
	 * 
	 * @return Integer value that is index of the turn player in playerList.
	 */
	public int getTurnPlayer() {
		return turn;
	}
	
	/**
	 * Returns the numerical value of a player's hand.
	 * 
	 * @param player The player whose hand is being checked.
	 * @return Returns the value of the player's hand.
	 */
	public int getHandValue(final Player player) {
		int cardValue = 0;
		boolean hasAce = false;
		for (int i = 0; i < player.getHandSize(); i++) {
			switch (player.getHand().get(i).getValue()) {
			
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
	
	/**
	 * Checks if the player has a BlackJack and returns a boolean.
	 * 
	 * @param player The player (dealer included) whose hand is being
	 * checked for a blackjack.
	 * 
	 * @return true if the player has a black jack;
	 * false if the player does not have a black jack.
	 */
	public boolean isBlackJack(final Player player) {
		boolean face = false;
		if (player.getHandSize() == 2 && getHandValue(player) == 21) {
			for (int i = 0; i < player.getHandSize(); i++) {
				switch (player.getCard(i).getValue()) {
					case JACK:
						face = true;
						break;
						
					case QUEEN:
						face = true;
						break;
						
					case KING:
						face = true;
						break;
						
					case ACE:
						break;
						
					default:
						break;
				}
			}
		}
		
		return face;
	}
	
	/**
	 * Checks if the current player's (dealer included) hand is a bust.
	 * 
	 * @param player The player's whose hand is being checked.
	 * @return True of the player's hand is a bust.
	 * False otherwise.
	 */
	public boolean isBust(final Player player) {
		if (getHandValue(player) > 21) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if the dealer won.
	 * 
	 * @param player The player going against the dealer.
	 * @param dealer The dealer.
	 * @return True if the Dealer Won, False otherwise.
	 */
	public boolean dealerWon(final Player player, final Player dealer) {
		if (isBust(player)) {
			return true;
		}
		if (getHandValue(dealer) > getHandValue(player) 
				&& !isBust(dealer)) {
			return true;
		} else if (getHandValue(dealer) == getHandValue(player)) {
			if (isBlackJack(dealer) && !isDraw(player, dealer)) {
				return true;
			}
			
			return false;
		}
		
		return false;
	}
	
	/**
	 * Check if the current hand ended in a draw.
	 * 
	 * @param player The player whose hand is being compared to the dealer.
	 * @param dealer The Dealer.
	 * @return True if the hand is a tie; false otherwise.
	 */
	public boolean isDraw(final Player player, final Player dealer) {
		if (getHandValue(dealer) == getHandValue(player)) {
			return !((isBlackJack(dealer) && !isBlackJack(player)) 
					|| (!isBlackJack(dealer) 
							&& 
							isBlackJack(player)));
		}
		
		return false;
	}
	
	/**
	 * Get Method for a particular player so the GUI can access
	 * things such as the player's hand.
	 * 
	 * @param i The index of the player in playerList.
	 * The dealer is at index 0.
	 * @return The player at index i.
	 */
	public Player getPlayer(final int i) {
		return playerList.get(i);
	}
	
	/**
	 * Empties both the player's and dealer's hands.
	 */
	public void gameReset() {
		player1.clearHand();
		theDealer.clearHand();
	}
	
	/**
	 * Sets the wager of the current hand.
	 * @param bet The amount of money waged.
	 */
	public void setWager(final int bet) {
		wager = bet;
	}
	
	/**
	 * Get method for the wager of the current hand.
	 * @return wager The current wager.
	 */
	public int getWager() {
		return wager;
	}
	
}
