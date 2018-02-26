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
	
	/*
	 * 
	 */
	public CasinoGamesBlackJackModel()
	{
		turn = 1;
		generateDeck(1);
	}
	
	/*
	 * Generates a shuffled deck to be played with.
	 */
	private void generateDeck(int decks)
	{
		int numOfCards = 52 * decks;
		Deck standardDeck = new Deck(this.standardDeck);
		int randCard;
		
		for (int i = 0; i < numOfCards; i++)
		{
			randCard = ThreadLocalRandom.current().
					nextInt(0, standardDeck.getSize());
			mainDeck.addCard(standardDeck.getCard(randCard));
			standardDeck.removeCard(randCard);
		}
	}
	
	/*
	 * 
	 */
	private void populatePlayerList()
	{
		playerList.add(dealer);
		playerList.add(player1);
	}
	
	/*
	 * Deal starting hand.
	 */
	private void deal()
	{
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		dealer.addToHand(mainDeck.draw());
		dealer.addToHand(mainDeck.draw());
	}
	
	/*
	 * 
	 */
	private void hit()
	{
		player1.addToHand(mainDeck.draw());
	}
	
	/*
	 * 
	 */
	public int getHandValue(player player)
	{
		return player.getHandValue();
	}
	
	private boolean isBlackJack(player player)
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
	
	/*
	 * Returns a Player's Hand in text message form.
	 */
	private String printPlayerHand(player player)
	{
		String s = "";
		System.out.println("Hand: ");
		for (int i = 0; i < player.getHandSize(); i++)
		{
			s += player.getCard(i).getValue() + " of " + player.getCard(i).getsuit()+"\n";
		}
		
		s += "Value: " + player1.getHandValue();
		
		return s;
	}
	
	/*
	 * Plays out a single hand.
	 */
	public void test_game()
	{
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		deal();
		
		if (player1.getHandValue() == 21)
		{
			boolean face = isBlackJack(player1);
			
			if (face == true)
			{
				System.out.println("BLACK JACK!");
				test_PrintPlayer1Hand();
				end = true;
			}
		}
	
		while(end != true)
		{
			int i = -1;
			while(i < 0 || i > 1)
			{
				test_PrintPlayer1Hand();
				System.out.println("Enter 1 to hit 0 to stand: ");
				i = sc.nextInt();
			}
			
			if (i == 1)
			{
				System.out.println("Hit!");
				hit();
				
				if (player1.getHandValue() > 21)
				{
					System.out.println("Bust!");
					end = true;
				}
			}
			
			if (i == 0)
			{
				System.out.println("This must be the work of an enemy stand!");
				end = true;
			}
			
			test_PrintPlayer1Hand();
		}
		
		player1.clearHand();
		
		sc.close();
	}
	
	/*
	 * Test Method, prints out player 1's hand.
	 */
	public void test_PrintPlayer1Hand()
	{
		System.out.println("Hand: ");
		for (int i = 0; i < player1.getHandSize(); i++)
		{
			System.out.println(player1.getCard(i).getValue() + " of " + player1.getCard(i).getsuit());
		}
		
		System.out.println("Value: " + player1.getHandValue());
	}
	
	/*
	 * Test Method, prints out all of the cards in the main deck.
	 */
	public void test_PrintOutDeck()
	{
		for (int i = 0; i < 52; i++)
		{
			System.out.println((i + 1) + " " 
					+ mainDeck.getCard(i).getValue() 
					+ " of " + mainDeck.getCard(i).getsuit());
		}
	}
	
}
