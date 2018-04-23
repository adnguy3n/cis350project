package casinogames;

/**
 * Enum containing the possible results for a poker hand.
 *
 */
public enum PokerResult {
	/**
	 * The possible results for a poker hand.
	 * None, Royal Pair, two pairs, and three of a kind.
	 */
	NONE, ROYAL_PAIR, TWO_PAIR, THREE_OF_A_KIND, 
	/**
	 * The possible results for a poker hand.
	 * Straight, flush, and full house.
	 */
	STRAIGHT, FLUSH, FULLHOUSE, 
	/**
	 * The possible results for a poker hand.
	 * Four of a kind, straight flush, and royal flush.
	 */
	FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH
}
