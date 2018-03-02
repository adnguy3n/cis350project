package casinogames;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 */
public class CasinoGamesBlackJackTest {
	
	@Test
	public void testIsBlackJack01() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.KING, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		assertEquals(true, game.isBlackJack(player));
	}
	
	@Test
	public void testIsBlackJack02() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.QUEEN, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		assertEquals(true, game.isBlackJack(player));
	}
	
	@Test
	public void testIsBlackJack03() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.JACK, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		assertEquals(true, game.isBlackJack(player));
	}
	
	@Test
	public void testIsBlackJack04() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card face = new Card(CardValue.TEN, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(face);
		// Should fail as ten is a not a face card.
		assertEquals(false, game.isBlackJack(player));
	}
	
	@Test
	public void testCardValue01() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card nine = new Card(CardValue.NINE, Suit.SPADES);
		player.addToHand(ace);
		player.addToHand(nine);
		assertEquals(20, game.getHandValue(player));
	}
	
	@Test
	public void testCardValue02() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.TWO, Suit.SPADES); 
		Card card2 = new Card(CardValue.TWO, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		assertEquals(4, game.getHandValue(player));
	}
	
	@Test
	public void testCardValue03() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.SEVEN, Suit.SPADES); 
		Card card2 = new Card(CardValue.EIGHT, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		assertEquals(15, game.getHandValue(player));
	}
	
	@Test
	public void testCardValue04() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.SIX, Suit.SPADES); 
		Card card2 = new Card(CardValue.KING, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		assertEquals(16, game.getHandValue(player));
	}
	
	@Test
	public void testCardValue05() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.QUEEN, Suit.SPADES); 
		Card card2 = new Card(CardValue.KING, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		assertEquals(20, game.getHandValue(player));
	}
	
	@Test
	public void testCardValue06() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.SEVEN, Suit.SPADES); 
		Card card2 = new Card(CardValue.SEVEN, Suit.CLUBS);
		Card card3 = new Card(CardValue.SEVEN, Suit.HEARTS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		assertEquals(21, game.getHandValue(player));
	}
	
	@Test
	public void testCardValue07() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.FIVE, Suit.SPADES); 
		Card card2 = new Card(CardValue.FIVE, Suit.CLUBS);
		Card card3 = new Card(CardValue.FIVE, Suit.HEARTS);
		Card card4 = new Card(CardValue.FIVE, Suit.DIAMONDS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		player.addToHand(card4);
		assertEquals(20, game.getHandValue(player));
	}
	
	@Test
	public void testCardValue08() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.SIX, Suit.SPADES); 
		Card card2 = new Card(CardValue.FIVE, Suit.CLUBS);
		Card card3 = new Card(CardValue.FIVE, Suit.HEARTS);
		Card card4 = new Card(CardValue.FIVE, Suit.DIAMONDS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		player.addToHand(card4);
		assertEquals(21, game.getHandValue(player));
	}
	
	@Test
	public void testCardValueAce01() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card ace = new Card(CardValue.ACE, Suit.SPADES); 
		Card nine = new Card(CardValue.NINE, Suit.SPADES);
		Card two = new Card(CardValue.TWO, Suit.HEARTS);
		player.addToHand(ace);
		player.addToHand(nine);
		player.addToHand(two);
		//The Ace should automatically change form a value of 11 to 1.
		assertEquals(12, game.getHandValue(player));
	}
	
	@Test
	public void testCardValueAce02() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		assertEquals(12, game.getHandValue(player));
	}
	
	@Test
	public void testCardValueAce03() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.SIX, Suit.CLUBS);
		Card card3 = new Card(CardValue.QUEEN, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		assertEquals(17, game.getHandValue(player));
	}
	
	@Test
	public void testCardValueAce04() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.EIGHT, Suit.HEARTS);
		Card card3 = new Card(CardValue.FOUR, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		assertEquals(13, game.getHandValue(player));
	}
	
	@Test
	public void testPlayerVsDealer01() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.KING, Suit.CLUBS);
		Card card3 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card4 = new Card(CardValue.TEN, Suit.DIAMONDS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		assertEquals(false, game.dealerWon(player, dealer));
	}

	@Test
	public void testPlayerVsDealer02() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.TEN, Suit.CLUBS);
		Card card3 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card4 = new Card(CardValue.JACK, Suit.DIAMONDS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		assertEquals(true, game.dealerWon(player, dealer));
	}
	
	@Test
	public void testPlayerVsDealer03() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.KING, Suit.CLUBS);
		Card card3 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card4 = new Card(CardValue.JACK, Suit.DIAMONDS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		assertEquals(false, game.dealerWon(player, dealer));
	}
	
	@Test
	public void testPlayerVsDealer04() {
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.KING, Suit.CLUBS);
		Card card3 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card4 = new Card(CardValue.JACK, Suit.DIAMONDS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		assertEquals(true, game.isDraw(player, dealer));
	}
	
	@Test
	public void testPlayerVsDealer05(){
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.EIGHT, Suit.CLUBS);
		Card card2 = new Card(CardValue.EIGHT, Suit.DIAMONDS);
		Card card3 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card4 = new Card(CardValue.SIX, Suit.CLUBS);
		Card card5 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card6 = new Card(CardValue.EIGHT, Suit.HEARTS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		player.addToHand(card4);
		dealer.addToHand(card5);
		dealer.addToHand(card6);
		
		assertEquals(true, game.dealerWon(player, dealer));
	}
	
	@Test
	public void testPlayerVsDealer06(){
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.TEN, Suit.CLUBS);
		Card card2 = new Card(CardValue.KING, Suit.SPADES);
		Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card4 = new Card(CardValue.ACE, Suit.DIAMONDS);
		Card card5 = new Card(CardValue.JACK, Suit.HEARTS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		dealer.addToHand(card5);
		
		assertEquals(false, game.dealerWon(player, dealer));

	}
	
	@Test
	public void testPlayerVsDealer07(){
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.TEN, Suit.HEARTS);
		Card card2 = new Card(CardValue.JACK, Suit.SPADES);
		Card card3 = new Card(CardValue.QUEEN, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.SEVEN, Suit.DIAMONDS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		
		assertEquals(false, game.dealerWon(player, dealer));

	}
	
	@Test
	public void testPlayerVsDealer08(){
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.SEVEN, Suit.HEARTS);
		Card card2 = new Card(CardValue.ACE, Suit.SPADES);
		Card card3 = new Card(CardValue.JACK, Suit.CLUBS);
		Card card4 = new Card(CardValue.EIGHT, Suit.HEARTS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		
		assertEquals(false, game.dealerWon(player, dealer));

	}
	
	@Test
	public void testPlayerVsDealer09(){
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.SEVEN, Suit.HEARTS);
		Card card2 = new Card(CardValue.ACE, Suit.DIAMONDS);
		Card card3 = new Card(CardValue.THREE, Suit.CLUBS);
		Card card4 = new Card(CardValue.FOUR, Suit.DIAMONDS);
		Card card5 = new Card(CardValue.ACE, Suit.HEARTS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		dealer.addToHand(card5);
		
		assertEquals(true, game.isDraw(player, dealer));

	}
	
	@Test
	public void testPlayerVsDealer10(){
		CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel(1);
		Player player = game.getPlayer(1);
		Player dealer = game.getPlayer(0);
		Card card1 = new Card(CardValue.NINE, Suit.CLUBS);
		Card card2 = new Card(CardValue.ACE, Suit.SPADES);
		Card card3 = new Card(CardValue.FIVE, Suit.CLUBS);
		Card card4 = new Card(CardValue.JACK, Suit.DIAMONDS);
		Card card5 = new Card(CardValue.JACK, Suit.HEARTS);
		player.addToHand(card1);
		player.addToHand(card2);
		dealer.addToHand(card3);
		dealer.addToHand(card4);
		dealer.addToHand(card5);
		
		assertEquals(false, game.dealerWon(player, dealer));

	}
}
