package casinogames;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CasinoGamesPokerModel {
	/*player one*/
	private Player player1 = new Player();
	/*dealer*/
	private Player theDealer = new Player();
	/*List of players*/
	private ArrayList<Player> playerList = new ArrayList<Player>();
	/*Number of standard decks that comprises the deck in use*/
	private Deck standardDeck = new Deck();
	/*Deck being used*/
	private Deck mainDeck = new Deck(0);
	/*Turn in game, Player 1 = 1 and Dealer = 0*/
	private int turn;
	/*Number of hands dealt*/
	private int hands = 0;
	
	
	/*Default constructor of CasinoGamesPokerModel*/
	public CasinoGamesPokerModel(){
		generateDeck(1);
		playerList.add(player1);
		playerList.add(theDealer);	
	}
	
	/*starts the game*/
	public void startGame(){
		turn = 1;
	//	deal();
	}
	
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
	
}
