package casinogames;

import java.util.*;
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
	private int bet = 0;
	/*Array of payout multipliers*/
	private static final int[] multipliers = {1,2,3,5,6,9,25,50,250};
	/*Array of winning hand types*/
	private static final String[] winningHands = { "Royal Pair" , "Two Pairs" , "Three of a Kind" , "Straight" , "Flush" , "Full House" , "Four of a Kind" , "Straight Flush" , "Royal Flush" };
	

	
	
	/*Default constructor of CasinoGamesPokerModel*/
	public CasinoGamesPokerModel(){
		generateDeck(1);	
	}
	
	/*Constructor with turn number parameter*/
	public CasinoGamesPokerModel(int x){
		this.turn = x;
		generateDeck(1);
	}
	
	/*player getter*/
	public Player getPlayer(){
		return this.player1;
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
	
	public boolean isRoyalPair(final Player player){
		Player temp = new Player();
		boolean royalPair = false;
		for(Card c : player.getHand()){
			for(Card d : player.getHand()){
				if((d.getValue()==c.getValue())&&(d.getsuit()!=c.getsuit())){
					temp.addToHand(c);
				}
			}
		}
		switch(temp.getCard(0).getValue()){
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
		
				
		}
		return royalPair;
	}
	
	/*determines if a hand is a straight or not*/
	
	public boolean isStraight(final Player player){
		
		ArrayList<Integer> sortedRank = toInt(player);
		ArrayList<Suit> cardSuits = new ArrayList<Suit>();
		
		for(int i = 0;i<5;i++){
			cardSuits.add(player.getCard(i).getsuit());
		}
		
		/*HashSet<Suit> suitSet = new HashSet<>(cardSuits);
		if(suitSet.size()>cardSuits.size()){
			return false;
		}*/
		
		for(int i = 1; i<5; i++){
			if(sortedRank.get(i) != sortedRank.get(i-1)+1){
				return false;
			}
		}
		return true;
	}
	
	
	/*determines if a hand has two pairs*/
	
	
	public boolean isTwoPair(final Player player){
		int pairs = 0;
		ArrayList<Integer> converted = toInt(player);
		for(int i=1;i<converted.size();i++){
			if(converted.get(i)==converted.get(i-1)){
				pairs++;
			}
		}
		if(pairs==2)
			return true;
		else
			return false;
	}
	
	/*determines if the hand is a three or four of a kind*/
	
	public boolean isOfAKind(final Player player){
		ArrayList<Integer> converted = toInt(player);
		int alike = 1;
		for(int i=1;i<player.getHandSize();i++){
			if(converted.get(i-1)==converted.get(i)){
				alike++;
			}
		}
		if(alike>=3){
			return true;
		}
		else{
			return false;
		}
	
	}
	
	
	/*determines if the player's hand is a flush*/
	
	
	public boolean isFlush(final Player player){
		Suit flushSuit = player.getCard(0).getsuit();
		for(Card c : player.getHand()){
			if(c.getsuit()!=flushSuit){
				return false;
			}
		}
		return true;
	}
	
	/*determines if the player's hand is a royal flush*/
	
	public boolean isRoyalFlush(final Player player){
		Suit flushSuit = player.getCard(0).getsuit();
		ArrayList<Integer> convertedHand = toInt(player);
		for(int i:convertedHand){
			if(i<10)
				return false;
		}
		for(Card c:player.getHand()){
			if(c.getsuit()!=flushSuit)
				return false;
		}
		return true;
	}
	
	/*checks if the hand is a straight flush*/
	
	public boolean isStraightFlush(final Player player){
		ArrayList<Integer> sortedRanks = toInt(player);
		Suit flushSuit = player.getCard(0).getsuit();
		
		for(Card c : player.getHand()){
			if(c.getsuit()!=flushSuit)
				return false;
		}
		
		for(int i=1;i<4;i++)
			if(sortedRanks.get(i)!=sortedRanks.get(i-1)+1){
				return false;
			}
		return true;
	}
	
	/*Creates a bet from player input*/
	
	private void getPlayerBet(){
		System.out.println("Enter bet: ");
	/*	try{
			
		}*/
	}
	
	/*updates the player's balance*/
	public void updateBalance(final Player player){
		//player.getBalance()-= player.bet();
	}
	
	/*converts card value in hand to array list of integers*/
	
	
	
	public ArrayList<Integer> toInt(final Player player){
		ArrayList<Integer> converted = new ArrayList<Integer>();
		for(int i=0;i<player.getHandSize();i++){
			switch(player.getCard(i).getValue()){
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
			}
		}
		Collections.sort(converted);
		return converted;
	}
	
}
