package casinogames;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CasinoGamesPokerModel {
	/*player one*/
	private Player player1 = new Player();
	/*Number of standard decks that comprises the deck in use*/
	private Deck standardDeck = new Deck();
	/*Deck being used*/
	private Deck mainDeck = new Deck(0);
	/*Turn in game*/
	private int turn;
	/*Number of hands dealt*/
	private int hands = 0;
	/*Bet placed at the beginning of the game*/
	private int bet;
	/*Array of payout multipliers*/
	private static final int[] multipliers = {1,2,3,5,6,9,25,50,250};
	/*Array of winning hand types*/
	private static final String[] winningHands = { "Royal Pair" , "Two Pairs" , "Three of a Kind" , "Straight" , "Flush" , "Full House" , "Four of a Kind" , "Straight Flush" , "Royal Flush" };
	

	
	
	/*Default constructor of CasinoGamesPokerModel*/
	public CasinoGamesPokerModel(){
		generateDeck(1);	
	}
	
	/*starts the game*/
	public void startGame(){
		turn = 1;
		deal();
		//prompt for bet amount
	}
	
	/*generates a standard poker deck*/
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
	
	
	/*deals a hand to the player and the dealer*/
	
	private void deal(){
		if (hands==5){
			System.out.println("Shuffling deck. ");
			generateDeck(1);
			hands = 0;
		}
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		player1.addToHand(mainDeck.draw());
		hands++;
	}
	
	/*replaces cards not held by the player*/
	
	private void nextTurn(){
		for(int i=0;i<player1.getHandSize();i++){
			if(player1.getCard(i).gethold() == false){
				player1.getHand().remove(i);
				player1.addToHand(mainDeck.draw());
			}
			
		}
		turn++;
	}
	
	/*determines if they player's hand is a royal pair*/
	
	private boolean isRoyalPair(final Player player){
		ArrayList<Card> temp = new ArrayList<Card>();
		boolean royalPair = false;
		for(Card c : player.getHand()){
			for(Card d : player.getHand()){
				if((d.getValue()==c.getValue())&&(d.getsuit()!=c.getsuit())){
					temp.add(c);
				}
			}
		}
		switch(player.getCard(0).getValue()){
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
				
		}
	}
	
}
