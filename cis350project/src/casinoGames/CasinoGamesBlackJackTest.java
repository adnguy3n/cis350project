package casinoGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 */
public class CasinoGamesBlackJackTest {
	
	@Test
	public void testIsBlackJack01() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.KING, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		assertEquals(true, game.isBlackJack(player));
	}
	
	@Test
	public void testIsBlackJack02() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.QUEEN, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		assertEquals(true, game.isBlackJack(player));
	}
	
	@Test
	public void testIsBlackJack03() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.JACK, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		assertEquals(true, game.isBlackJack(player));
	}
	
	@Test
	public void testIsBlackJack04() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.TEN, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		// Should fail as TEN is a not a face card.
		assertEquals(false, game.isBlackJack(player));
	}
	
	@Test
	public void testCardValue21() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card nine = new Card(CardValue.NINE, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(nine);
		assertEquals(20, game.getHandValue(player));
	}
	
	@Test
	public void testCardValueAce() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card nine = new Card(CardValue.NINE, Suit.SPADES);
		Card two = new Card(CardValue.TWO, Suit.HEARTS);
		player.addToHand(ace);
		player.addToHand(nine);
		player.addToHand(two);
		assertEquals(12, game.getHandValue(player));
	}

}
