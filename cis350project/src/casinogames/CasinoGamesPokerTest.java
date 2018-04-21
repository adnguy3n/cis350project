package casinogames;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 * JUnit tests for Poker.
 *
 */
public class CasinoGamesPokerTest {
	
	/**
	 * Tests for straight.
	 */
	@Test
	public void testIsStraight00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.KING, Suit.CLUBS);
		Card card3 = new Card(CardValue.TEN, Suit.HEARTS);
		Card card4 = new Card(CardValue.JACK, Suit.DIAMONDS);
		Card card5 = new Card(CardValue.QUEEN, Suit.HEARTS);
		game.getPlayer().addToHand(card1);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card5);
		assertEquals(PokerResult.STRAIGHT, game.getResult());
	}
	
	/**
	 * Tests Conversion.
	 */
	@Test
	public void testConversion00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card2 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card3 = new Card(CardValue.THREE, Suit.CLUBS);
		game.getPlayer().addToHand(card1);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card3);
		ArrayList<Integer> x = game.toInt(game.getPlayer());
		ArrayList<Integer> y = new ArrayList<Integer>();
		y.add(2);
		y.add(3);
		y.add(14);
		assertEquals(x, y);
	}
	
	/**
	 * Tests for three of a kind.
	 */
	@Test
	public void testIsThreeOfAKind00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card3 = new Card(CardValue.ACE, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card5 = new Card(CardValue.THREE, Suit.CLUBS);
		game.getPlayer().addToHand(card5);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card1);
		assertEquals(PokerResult.THREE_OF_A_KIND, game.getResult());

	}
	
	/**
	 * Tests for Royal Pair.
	 */
	@Test
	public void testisRoyalPair00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card3 = new Card(CardValue.FOUR, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card5 = new Card(CardValue.THREE, Suit.CLUBS);
		game.getPlayer().addToHand(card1);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card5);
		assertEquals(PokerResult.ROYAL_PAIR, game.getResult());
		
	}
	
	/**
	 * Tests for four of a kind.
	 */
	@Test
	public void testIsFourOfAKind() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card2 = new Card(CardValue.TWO, Suit.CLUBS);
		Card card3 = new Card(CardValue.TWO, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TWO, Suit.SPADES);
		Card card5 = new Card(CardValue.THREE, Suit.CLUBS);
		game.getPlayer().addToHand(card5);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card1);
		assertEquals(PokerResult.FOUR_OF_A_KIND, game.getResult());

	}
	
	/**
	 * Tests for two pairs.
	 */
	@Test
	public void testIsTwoPair00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card2 = new Card(CardValue.THREE, Suit.CLUBS);
		Card card3 = new Card(CardValue.THREE, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TEN, Suit.SPADES);
		Card card5 = new Card(CardValue.TEN, Suit.CLUBS);
		game.getPlayer().addToHand(card5);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card1);
		assertEquals(PokerResult.TWO_PAIR, game.getResult());
	}
	
	/**
	 * Test for Flush.
	 */
	@Test
	public void testIsFlush00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card2 = new Card(CardValue.SEVEN, Suit.HEARTS);
		Card card3 = new Card(CardValue.EIGHT, Suit.HEARTS);
		Card card4 = new Card(CardValue.FOUR, Suit.HEARTS);
		Card card5 = new Card(CardValue.TWO, Suit.HEARTS);
		game.getPlayer().addToHand(card5);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card1);
		assertEquals(PokerResult.FLUSH, game.getResult());
		
	}
	
	/**
	 * Test for Royal Flush.
	 */
	@Test
	public void testIsRoyalFlush00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card2 = new Card(CardValue.KING, Suit.HEARTS);
		Card card3 = new Card(CardValue.QUEEN, Suit.HEARTS);
		Card card4 = new Card(CardValue.TEN, Suit.HEARTS);
		Card card5 = new Card(CardValue.JACK, Suit.HEARTS);
		game.getPlayer().addToHand(card5);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card1);
		assertEquals(PokerResult.ROYAL_FLUSH, game.getResult());
		
	}
	
	/**
	 * Test for Straight Flush.
	 */
	@Test
	public void testIsStraightFlush00() {
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Card card1 = new Card(CardValue.SIX, Suit.HEARTS);
		Card card2 = new Card(CardValue.SEVEN, Suit.HEARTS);
		Card card3 = new Card(CardValue.EIGHT, Suit.HEARTS);
		Card card4 = new Card(CardValue.NINE, Suit.HEARTS);
		Card card5 = new Card(CardValue.TEN, Suit.HEARTS);
		game.getPlayer().addToHand(card5);
		game.getPlayer().addToHand(card4);
		game.getPlayer().addToHand(card3);
		game.getPlayer().addToHand(card2);
		game.getPlayer().addToHand(card1);
		assertEquals(PokerResult.STRAIGHT_FLUSH, game.getResult());
	}
	


}
