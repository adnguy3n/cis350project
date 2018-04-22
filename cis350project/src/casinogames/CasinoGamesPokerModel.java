package casinogames;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Logic Model for Poker game.
 */
public class CasinoGamesPokerModel {
	/** The player. */
	private Player player = new Player();
	/** Number of standard decks that comprises the deck in use. */
	private Deck standardDeck = new Deck();
	/** Deck being used. */
	private Deck mainDeck = new Deck(0);
	/** Bet placed at the beginning of the game. */
	private int wager = 0;
	/** Boolean for determining which cards are kept. */
	private final boolean[] keep = new boolean[5];
	/** Number of standard decks being used. */
	private final int numOfDecks;
	
	/**
	 * Constructor for Poker Game.
	 * @param decks The number of decks being used.
	 */
	public CasinoGamesPokerModel(final int decks) {
		numOfDecks = decks;
		for (int i = 0; i < 5; i++) {
			keep[i] = false;
		}
		generateDeck(numOfDecks);
	}
	
	/**
	 * Getting method for player.
	 * @return player The player.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Public method for starting the game.
	 */
	public void startGame() {
		if (mainDeck.getSize() < 10) {
			System.out.println("Shuffling Deck");
			generateDeck(numOfDecks);
		}
		draw(5);
	}
	
	/**
	 * Method for drawing cards to hand.
	 * @param draws The number of cards being drawn.
	 */
	private void draw(final int draws) {
		for (int i = 0; i < draws; i++) {
			player.addToHand(mainDeck.draw());
		}
	}
	
	/**
	 * Method for discarding unwanted cards and drawing new cards.
	 * @param slot The placement in hand of the cards being redrawn.
	 */
	public void redraw(final int slot) {
		player.getHand().remove(slot);
		player.addToHand(mainDeck.draw(), slot);
	}
	
	/**
	 * Method for generating a standard deck.
	 * @param decks The number of decks to be generated.
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
	 * Setter method for booleans determining which cards to
	 * keep when re-drawing.
	 * @param cardSlot The card slot in hand to keep.
	 */
	public void setKeep(final int cardSlot) {
		if (keep[cardSlot]) {
			keep[cardSlot] = false;
		} else {
			keep[cardSlot] = true;
		}
	}
	
	/**
	 * Getter method for booleans determining which cards to
	 * keep when redrawing.
	 * @param cardSlot The card slot in hand to keep.
	 * @return true If the card is being kept or false if
	 * the card is being discarded.
	 */
	public boolean getKeep(final int cardSlot) {
		return keep[cardSlot];
	}
	
	/**
	 * Method for resetting keep status at the end of a hand.
	 */
	public void resetKeep() {
		for (int i = 0; i < 5; i++) {
			keep[i] = false;
		}
	}
	
	/**
	 * Gets the result of a hand and returns it.
	 * @return The result of the current hand.
	 */
	public PokerResult getResult() {
		if (isRoyalFlush()) {
			player.addBalance(wager * 250);
			return PokerResult.ROYAL_FLUSH;
		}
		
		if (isStraightFlush()) {
			player.addBalance(wager * 50);
			return PokerResult.STRAIGHT_FLUSH;
		}
		
		if (isFourOfAKind()) {
			player.addBalance(wager * 25);
			return PokerResult.FOUR_OF_A_KIND;
		}
		
		if (isFullHouse()) {
			player.addBalance(wager * 9);
			return PokerResult.FULLHOUSE;
		}
		
		if (isFlush()) {
			player.addBalance(wager * 6);
			return PokerResult.FLUSH;
		}
		
		if (isStraight()) {
			player.addBalance(wager * 5);
			return PokerResult.STRAIGHT;
		}
		
		if (isThreeOfAKind()) {
			player.addBalance(wager * 3);
			return PokerResult.THREE_OF_A_KIND;
		}
		
		if (isTwoPair()) {
			player.addBalance(wager * 2);
			return PokerResult.TWO_PAIR;
		}
		
		if (isRoyalPair()) {
			player.addBalance(wager * 1);
			return PokerResult.ROYAL_PAIR;
		}
		
		player.subBalance(wager);
		return PokerResult.NONE;
	}
	
	/**
	 * Counts the number of times a value appears in the hand.
	 * @param value The card value being checked.
	 * @return alike The number of cards the player has the same of..
	 */
	private int isOfAKind(final CardValue value) {
		//Counter for number of times the specified value appears.
		int sameValue = 0;
		//Counts the number of times the specified value appears.
		for (int i = 0; i < player.getHandSize(); i++) {
			if (player.getCard(i).getValue() == value) {
				sameValue++;
			}
		}
		return sameValue;
	}
	
	/**
	 * Determines if the player has a royal pair.
	 * A royal pair is a pair that consists of 
	 * face cards or aces.
	 * @return true if the player has a royal pair.
	 * false otherwise.
	 */
	private boolean isRoyalPair() {
		for (int i = 0; i < player.getHandSize(); i++) {
			//Checks if the user has a pair.
			if (isOfAKind(player.getCard(i).getValue()) == 2) {
				//Checks if the pair is of Ace or Face Cards.
				switch (player.getCard(i).getValue()) {
					case ACE:
						return true;
					case KING:
						return true;
					case QUEEN:
						return true;
					case JACK:
						return true;
					default:
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Determines if the player has two pairs.
	 * @return true if player has two pairs.
	 * false otherwise.
	 */
	private boolean isTwoPair() {
		
		//Number of pairs.
		int pairs = 0;
		
		//Array List for card values that where already checked.
		ArrayList<CardValue> checked = new ArrayList<CardValue>();
		
		for (int i = 0; i < player.getHandSize(); i++) {
			//Boolean flag for whether 
			//a value has already been checked.
			boolean alreadyChecked = false;
			
			for (int j = 0; j < checked.size(); j++) {
				if (player.getCard(i).getValue() 
						== checked.get(j)) {
					alreadyChecked = true;
				}
			}
			//Increments pairs if there 
			//is a pair of the card's value.
			if (!alreadyChecked) {
				if (isOfAKind(player.getCard(i).getValue())
						== 2) {
					pairs++;
					checked.add(player.getCard(i).
							getValue());
				}
			}
		}
		
		return pairs == 2;
	}
	
	/**
	 * Determines if the player has a three of a kind.
	 * @return true If the player has three of a kind.
	 * False otherwise.
	 */
	private boolean isThreeOfAKind() {
		for (int i = 0; i < 3; i++) {
			if (isOfAKind(player.getCard(i).getValue()) == 3) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Determines if a player has a full house.
	 * @return true if the player has a full house.
	 * False otherwise.
	 */
	private boolean isFullHouse() {
		
		//A Full House always has a three of a kind.
		if (!isThreeOfAKind()) {
			return false;
		}
		
		//Array List for card values that where already checked.
		ArrayList<CardValue> checked = new ArrayList<CardValue>();
				
			for (int i = 0; i < player.getHandSize(); i++) {
				//Boolean flag for whether 
				//a value has already been checked.
				boolean alreadyChecked = false;
					
				for (int j = 0; j < checked.size(); j++) {
					if (player.getCard(i).getValue() 
							== checked.get(j)) {
						alreadyChecked = true;
					}
				}
					
				if (!alreadyChecked) {
					if (isOfAKind(player.getCard(i).
							getValue()) == 2) {
						return true;
					}
				}
			}
		return false;
	}
	
	/**
	 * Determines if the player has a four of a kind.
	 * @return true If the player has four of a kind.
	 * False otherwise.
	 */
	private boolean isFourOfAKind() {
		for (int i = 0; i < 2; i++) {
			if (isOfAKind(player.getCard(i).getValue()) == 4) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines if a hand is a straight.
	 * @return true if the  player has a straight.
	 * false otherwise.
	 */
	private boolean isStraight() {
		
		ArrayList<Integer> sortedRank = toInt(player);
		
		for (int i = 1; i < 5; i++) {
			if (sortedRank.get(i) != sortedRank.get(i - 1) + 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determines if the player has a flush.
	 * @return true if the player has a flush.
	 * false otherwise.
	 */
	private boolean isFlush() {
		Suit flushSuit = player.getCard(0).getsuit();
		for (Card c : player.getHand()) {
			if (c.getsuit() != flushSuit) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if the player has a straight flush.
	 * @return true if the player has a straight flush.
	 * false otherwise.
	 */
	private boolean isStraightFlush() {
		//A Straight Flush is both a Flush and a Straight.
		if (isFlush() && isStraight()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Determines if the player has a royal flush.
	 * @return true if the player has a royal flush.
	 * false otherwise.
	 */
	private boolean isRoyalFlush() {
		//A Royal Flush is a Straight Flush.
		if (isFlush() && isStraight()) {
			//A Royal Flush consists of:
			//Ten, Jack, Queen, King, Ace of the same suit.
			
			//Assigns integer values to cards.
			ArrayList<Integer> sortedRank = toInt(player);
			
			int sum = 0;
			
			//Sums up the integer values.
			for (int i = 0; i < 5; i++) {
				sum += sortedRank.get(i);
			}
			
			//Checks if the sum is the largest possible
			//as it is the only combination possible for
			//a Royal Flush.
			if (sum == 10 + 11 + 12 + 13 + 14) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Getter method for the waged amount.
	 * @return wager The amount of money being waged.
	 */
	public int getWager() {
		return wager;
	}
	
	/**
	 * Updates the waged amount.
	 * @param bet The amount being waged.
	 */
	public void setWager(final int bet) {
		wager = bet;
	}
	
	/**
	 * Converts hand value to array list of integers.
	 * @param player The player.
	 * @return The converted Array List.
	 */
	public ArrayList<Integer> toInt(final Player player) {
		ArrayList<Integer> converted = new ArrayList<Integer>();
		for (int i = 0; i < player.getHandSize(); i++) {
			switch (player.getCard(i).getValue()) {
				case TWO:
					converted.add(2);
					break;
				case THREE:
					converted.add(3);
					break;
				case FOUR:
					converted.add(4);
					break;
				case FIVE:
					converted.add(5);
					break;
				case SIX:
					converted.add(6);
					break;
				case SEVEN:
					converted.add(7);
					break;
				case EIGHT:
					converted.add(8);
					break;
				case NINE:
					converted.add(9);
					break;
				case TEN:
					converted.add(10);
					break;
				case JACK:
					converted.add(11);
					break;
				case QUEEN:
					converted.add(12);
					break;
				case KING:
					converted.add(13);
					break;
				case ACE:
					converted.add(14);
					break;
				default:
					break;
			}
		}
		Collections.sort(converted);
		return converted;
	}
	
}
