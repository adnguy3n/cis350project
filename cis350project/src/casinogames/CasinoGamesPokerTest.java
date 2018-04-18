package casinogames;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CasinoGamesPokerTest {
	
	@Test
	public void testIsStraight00(){
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Player player = game.getPlayer();
		Card card1 = new Card(CardValue.ACE, Suit.SPADES); 
		Card card2 = new Card(CardValue.KING, Suit.CLUBS);
		Card card3 = new Card(CardValue.TEN, Suit.HEARTS);
		Card card4 = new Card(CardValue.JACK, Suit.DIAMONDS);
		Card card5 = new Card(CardValue.QUEEN, Suit.HEARTS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		player.addToHand(card4);
		player.addToHand(card5);
		assertEquals(true, game.isStraight(player));
	}
	
	@Test
	public void testConversion00(){
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Player player = game.getPlayer();
		Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card2 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card3 = new Card(CardValue.THREE, Suit.CLUBS);
		player.addToHand(card1);
		player.addToHand(card2);
		player.addToHand(card3);
		ArrayList<Integer> x = game.toInt(player);
		ArrayList<Integer> y = new ArrayList<Integer>();
		y.add(2);
		y.add(3);
		y.add(11);
		assertEquals(x,y);
	}
	
	@Test
	public void testIsOfAKind00(){
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Player player = game.getPlayer();
		Card card1 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card3 = new Card(CardValue.ACE, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card5 = new Card(CardValue.THREE, Suit.CLUBS);
		player.addToHand(card5);
		player.addToHand(card4);
		player.addToHand(card3);
		player.addToHand(card2);
		player.addToHand(card1);
		assertEquals(true, game.isOfAKind(player));

	}
	
	@Test
	public void testIsOfAKind01(){
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Player player = game.getPlayer();
		Card card1 = new Card(CardValue.ACE, Suit.HEARTS);
		Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
		Card card3 = new Card(CardValue.FOUR, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card5 = new Card(CardValue.THREE, Suit.CLUBS);
		player.addToHand(card5);
		player.addToHand(card4);
		player.addToHand(card3);
		player.addToHand(card2);
		player.addToHand(card1);
		assertEquals(false, game.isOfAKind(player));
		
	}
	
	@Test
	public void testIsOfAKind02(){
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Player player = game.getPlayer();
		Card card1 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card2 = new Card(CardValue.TWO, Suit.CLUBS);
		Card card3 = new Card(CardValue.TWO, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TWO, Suit.SPADES);
		Card card5 = new Card(CardValue.THREE, Suit.CLUBS);
		player.addToHand(card5);
		player.addToHand(card4);
		player.addToHand(card3);
		player.addToHand(card2);
		player.addToHand(card1);
		assertEquals(true, game.isOfAKind(player));

	}
	
	@Test
	public void testIsTwoPair00(){
		CasinoGamesPokerModel game = new CasinoGamesPokerModel(1);
		Player player = game.getPlayer();
		Card card1 = new Card(CardValue.TWO, Suit.HEARTS);
		Card card2 = new Card(CardValue.THREE, Suit.CLUBS);
		Card card3 = new Card(CardValue.THREE, Suit.DIAMONDS);
		Card card4 = new Card(CardValue.TEN, Suit.SPADES);
		Card card5 = new Card(CardValue.TEN, Suit.CLUBS);
		player.addToHand(card5);
		player.addToHand(card4);
		player.addToHand(card3);
		player.addToHand(card2);
		player.addToHand(card1);
		assertEquals(true, game.isTwoPair(player));
	}

}
