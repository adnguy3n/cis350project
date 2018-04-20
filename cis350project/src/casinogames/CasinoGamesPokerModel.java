package casinogames;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Logic Model for Poker game.
 * @author TypeL
 *
 */
public class CasinoGamesPokerModel {
	/** The player. */
	private Player player1 = new Player();
	/** Number of standard decks that comprises the deck in use. */
	private Deck standardDeck = new Deck();
	/** Deck being used. */
	private Deck mainDeck = new Deck(0);
	/** Turn in game. */
	private int turn;
	/** Number of hands dealt. */
	private int hands = 0;
	/** Bet placed at the beginning of the game. */
	private int wager = 0;
	/**Array of payout multipliers. */
	private static final int[] MULTIPLIERS = 
		{1, 2, 3, 5, 6, 9, 25, 50, 250};
	/** Array of winning hand types. */
	private static final String[] WINNINGHANDS = 
		{"Royal Pair", "Two Pairs", 
				"Three of a Kind", "Straight", 
				"Flush", "Full House", "Four of a Kind", 
				"Straight Flush", "Royal Flush"};
	
	/**
	 * Default Constructor for Poker Game.
	 * @param decks The number of decks being used.
	 */
	public CasinoGamesPokerModel(){
		generateDeck(1);
	}
	
	/**
	 * Constructor for Poker Game.
	 * @param decks The number of decks being used.
	 */
	public CasinoGamesPokerModel(int decks) {
		generateDeck(decks);
	}
	
	/**
	 * Getting method for player.
	 * @return player1 The player.
	 */
	public Player getPlayer() {
		return player1;
	}
	
	/**
	 * Public method for starting the game.
	 */
	public void startGame() {
		deal();
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
	 * Deals a hand to the player.
	 */
	private void deal(){
		System.out.println("Shuffling deck. ");
		generateDeck(1);
		hands = 0;
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		hands++;
	}
	
	/** 
	 * Replaces cards not held by the player.
	 */
	public void nextTurn() {
		for(int i = 0; i < player1.getHandSize(); i++) {
			if(player1.getCard(i).gethold() == false) {
				player1.getHand().remove(i);
				player1.addToHand(mainDeck.draw());
			}
			
		}
		turn++;
	}
	
	/**
	 * Determines if the player has a royal pair.
	 * @param player The player.
	 * @return true if the player has a royal pair.
	 * false otherwise.
	 */
	public boolean isRoyalPair(final Player player){
		Player temp = new Player();
		boolean royalPair = false;
		for (Card c : player.getHand()) {
			for (Card d : player.getHand()) {
				if ((d.getValue() == c.getValue()) 
						&& (d.getsuit() != c.getsuit())) {
					temp.addToHand(c);
				}
			}
		}
		switch (temp.getCard(0).getValue()) {
			case JACK:
				royalPair = true;
				break;
			case QUEEN:
				royalPair = true;
				break;
			case KING:
				royalPair = true;
				break;
			case ACE:
				royalPair = true;
				break;
			case EIGHT:
				royalPair = false;
				break;
			case FIVE:
				royalPair = false;
				break;
			case FOUR:
				royalPair = false;
				break;
			case NINE:
				royalPair = false;
				break;
			case SEVEN:
				royalPair = false;
				break;
			case SIX:
				royalPair = false;
				break;
			case TEN:
				royalPair = false;
				break;
			case THREE:
				royalPair = false;
				break;
			case TWO:
				royalPair = false;
				break;
			default:
				break;
				
		}
		return royalPair;
	}
	
	/**
	 * Determines if a player has a full house.
	 * @param player The player.
	 * @return true if the player has a full house.
	 * False otherwise.
	 */
	public boolean isFullHouse(final Player player) {
		if (isOfAKind(player) == 3) {
			ArrayList<Integer> temp = toInt(player);
			for (int i = 2; i < temp.size(); i++) {
				if ((temp.get(i - 2) == temp.get(i - 1) && (temp.get(i - 1) == temp.get(i)))) {
					temp.remove(i-2);
					temp.remove(i-1);
					temp.remove(i);
				}		
			}
			if(temp.size() == 2 ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines if a hand is a straight.
	 * @param player The player.
	 * @return true if the  player has a straight.
	 * false otherwise.
	 */
	public boolean isStraight(final Player player) {
		
		ArrayList<Integer> sortedRank = toInt(player);
		ArrayList<Suit> cardSuits = new ArrayList<Suit>();
		
		for (int i = 0; i < 5; i++) {
			cardSuits.add(player.getCard(i).getsuit());
		}
		
		for (int i = 1; i<5; i++) {
			if(sortedRank.get(i) != sortedRank.get(i - 1) + 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determines if the player has two pairs.
	 * @param player The player.
	 * @return true if player has two pairs.
	 * false otherwise.
	 */
	public boolean isTwoPair(final Player player) {
		int pairs = 0;
		ArrayList<Integer> converted = toInt(player);
		for(int i=1;i<converted.size();i++) {
			if(converted.get(i)==converted.get(i-1)) {
				pairs++;
			}
		}
		if(pairs == 2) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Determines if the player has four of a kind.	
	 * @param player The player.
	 * @return true if the player has four of a kind.
	 * false otherwise.
	 */
	public int isOfAKind(final Player player) {
		ArrayList<Integer> converted = toInt(player);
		int alike = 1;
		for (int i = 1; i<player.getHandSize(); i++) {
			if (converted.get(i-1) == converted.get(i)) {
				alike++;
			}
		}
		if (alike >= 3) {
			return alike;
		} else {
			return 0;
		}
	
	}
	
	/**
	 * Determines if the player has a flush.
	 * @param player The player.
	 * @return true if the player has a flush.
	 * false otherwise.
	 */
	public boolean isFlush(final Player player){
		Suit flushSuit = player.getCard(0).getsuit();
		for(Card c : player.getHand()){
			if(c.getsuit()!=flushSuit){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determines if the player has a royal flush.
	 * @param player The player.
	 * @return true if the player has a royal flush.
	 * false otherwise.
	 */
	public boolean isRoyalFlush(final Player player) {
		Suit flushSuit = player.getCard(0).getsuit();
		ArrayList<Integer> convertedHand = toInt(player);
		for (int i : convertedHand) {
			if (i < 10) {
				return false;
			}
		}
		for (Card c : player.getHand()) {
			if (c.getsuit() != flushSuit)
				return false;
		}
		return true;
	}
	
	/**
	 * Checks if the player has a straight flush.
	 * @param player The player.
	 * @return true if the player has a straight flush.
	 * false otherwise.
	 */
	public boolean isStraightFlush(final Player player) {
		ArrayList<Integer> sortedRanks = toInt(player);
		Suit flushSuit = player.getCard(0).getsuit();
		
		for (Card c : player.getHand()) {
			if (c.getsuit() != flushSuit) {
				return false;
			}
		}
		
		for (int i=1; i<4; i++) {
			if(sortedRanks.get(i) != sortedRanks.get(i - 1) + 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Getter method for the waged amount.
	 * @return wager The amount of money being waged.
	 */
	public int getWager(){
		return wager;
	}
	
	/**
	 * Updates the waged amount.
	 * @param bet The amount being waged.
	 */
	public void setWager(final int bet){
		wager = bet;
	}
	
	/**
	 * Converts hand value to array list of integers.
	 * @param player
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
