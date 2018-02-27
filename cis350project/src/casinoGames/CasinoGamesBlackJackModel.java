package casinoGames;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class CasinoGamesBlackJackModel {
	/* Dealer Object*/
	private player dealer = new player();
	/* Player 1 Object*/
	private player player1 = new player();
	/* Array List of players, including the dealer*/
	private ArrayList<player> playerList = new ArrayList<player>();
	/* Standard Non-Shuffled Play Deck. */
	private Deck standardDeck = new Deck();
	/* Deck being used. */
	private Deck mainDeck = new Deck(0);
	/* Current Player Turn Flag: 1 for Player 1, 0 for Dealer */
	private int turn;
	
	
	/**
	 * 
	 */
	public CasinoGamesBlackJackModel()
	{
		generateDeck(1);
		playerList.add(dealer);
		playerList.add(player1);
	}
	
	/**
	 * 
	 */
	public void startGame()
	{
		turn = 1;
		deal();
	}
	
	/**
	 * Generates a shuffled deck to be played with.
	 */
	private void generateDeck(int decks)
	{
		int numOfCards = 52 * decks;
		Deck standardDeck = new Deck(this.standardDeck);
		int randCard;
		mainDeck.clearDeck();
		
		for (int i = 0; i < numOfCards; i++)
		{
			randCard = ThreadLocalRandom.current().
					nextInt(0, standardDeck.getSize());
			mainDeck.addCard(standardDeck.getCard(randCard));
			standardDeck.removeCard(randCard);
		}
	}
	
	
	/**
	 * Deal starting hand.
	 */
	private void deal()
	{
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		dealer.addToHand(mainDeck.draw());
		dealer.addToHand(mainDeck.draw());
	}
	
	/**
	 * 
	 */
	public void hit()
	{
		switch(turn)
		{
			case 0:
				dealer.addToHand(mainDeck.draw());
				break;
			
			case 1:
				player1.addToHand(mainDeck.draw());
				break;
		}
	}
	
	/**
	 * 
	 */
	public void stand()
	{
		changePlayer();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTurnPlayer()
	{
		return turn;
	}
	
	/**
	 * 
	 */
	private void changePlayer()
	{
		switch(turn)
		{
			case 0:
				turn = 1;
				break;
			
			case 1:
				turn = 0;
				break;
		}
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public int getHandValue(player player)
	{
		return player.getHandValue();
	}
	
	/**
	 * Checks if the player has a BlackJack and returns a boolean.
	 * 
	 * @param player
	 * @return true if the player has a black jack; false if the player does not have a black jack
	 */
	public boolean isBlackJack(player player)
	{
		boolean face = false;
		for (int i = 0; i < player.getHandSize(); i++)
		{
			switch(player.getCard(i).getValue())
			{
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
				case EIGHT:
					break;
				case FIVE:
					break;
				case FOUR:
					break;
				case NINE:
					break;
				case SEVEN:
					break;
				case SIX:
					break;
				case TEN:
					break;
				case THREE:
					break;
				case TWO:
					break;
				default:
					break;
			}
		}
		
		return face;
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public boolean isBust(player player)
	{
		if (player.getHandValue() > 21)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param player
	 * @param dealer
	 * @return
	 */
	public boolean dealerWon(player player, player dealer)
	{
		if (dealer.getHandValue() > player.getHandValue())
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param player
	 * @param dealer
	 * @return
	 */
	public boolean isDraw(player player, player dealer)
	{
		if (dealer.getHandValue() == player.getHandValue())
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Get Method for a particular player so the GUI can access
	 * things such as the player's hand.
	 * 
	 * @param player
	 * @return
	 */
	public player getPlayer(int i)
	{
		return playerList.get(i);
	}
	
	public void gameReset()
	{
		player1.clearHand();
		dealer.clearHand();
	}
	
}
