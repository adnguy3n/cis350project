package casinogames;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class PokerGUI {

	/** JFrame, returned to main to run the program. */
	private JFrame frame;
	/** Card Image for Ace of Clubs. */
	private ImageIcon cA;
	/** Card Image for Two of Clubs. */
	private ImageIcon c2;
	/** Card Image for Three of Clubs. */
	private ImageIcon c3;
	/** Card Image for Four of Clubs. */
	private ImageIcon c4;
	/** Card Image for Five of Clubs. */
	private ImageIcon c5;
	/** Card Image for Six of Clubs. */
	private ImageIcon c6;
	/** Card Image for Seven of Clubs. */
	private ImageIcon c7;
	/** Card Image for Eight of Clubs. */
	private ImageIcon c8;
	/** Card Image for Nine of Clubs. */
	private ImageIcon c9;
	/** Card Image for Ten of Clubs. */
	private ImageIcon c0;
	/** Card Image for Jack of Clubs. */
	private ImageIcon cJ;
	/** Card Image for Queen of Clubs. */
	private ImageIcon cQ;
	/** Card Image for King of Clubs. */
	private ImageIcon cK;
	/** Card Image for Ace of Spades. */
	private ImageIcon sA;
	/** Card Image for Two of Spades. */
	private ImageIcon s2;
	/** Card Image for Three of Spades. */
	private ImageIcon s3;
	/** Card Image for Four of Spades. */
	private ImageIcon s4;
	/** Card Image for Five of Spades. */
	private ImageIcon s5;
	/** Card Image for Six of Spades. */
	private ImageIcon s6;
	/** Card Image for Seven of Spades. */
	private ImageIcon s7;
	/** Card Image for Eight of Spades. */
	private ImageIcon s8;
	/** Card Image for Nine of Spades. */
	private ImageIcon s9;
	/** Card Image for Ten of Spades. */
	private ImageIcon s0;
	/** Card Image for Jack of Spades. */
	private ImageIcon sJ;
	/** Card Image for Queen of Spades. */
	private ImageIcon sQ;
	/** Card Image for King of Spades. */
	private ImageIcon sK;
	/** Card Image for Ace of Diamonds. */
	private ImageIcon dA;
	/** Card Image for Two of Diamonds. */
	private ImageIcon d2;
	/** Card Image for Three of Diamonds. */
	private ImageIcon d3;
	/** Card Image for Four of Diamonds. */
	private ImageIcon d4;
	/** Card Image for Five of Diamonds. */
	private ImageIcon d5;
	/** Card Image for Six of Diamonds. */
	private ImageIcon d6;
	/** Card Image for Seven of Diamonds. */
	private ImageIcon d7;
	/** Card Image for Eight of Diamonds. */
	private ImageIcon d8;
	/** Card Image for Nine of Diamonds. */
	private ImageIcon d9;
	/** Card Image for Ten of Diamonds. */
	private ImageIcon d0;
	/** Card Image for Jack of Diamonds. */
	private ImageIcon dJ;
	/** Card Image for Queen of Diamonds. */
	private ImageIcon dQ;
	/** Card Image for King of Diamonds. */
	private ImageIcon dK;
	/** Card Image for Ace of Hearts. */
	private ImageIcon hA;
	/** Card Image for Two of Hearts. */
	private ImageIcon h2;
	/** Card Image for Three of Hearts. */
	private ImageIcon h3;
	/** Card Image for Four of Hearts. */
	private ImageIcon h4;
	/** Card Image for Five of Hearts. */
	private ImageIcon h5;
	/** Card Image for Six of Hearts. */
	private ImageIcon h6;
	/** Card Image for Seven of Hearts. */
	private ImageIcon h7;
	/** Card Image for Eight of Hearts. */
	private ImageIcon h8;
	/** Card Image for Nine of Hearts. */
	private ImageIcon h9;
	/** Card Image for Ten of Hearts. */
	private ImageIcon h0;
	/** Card Image for Jack of Hearts. */
	private ImageIcon hJ;
	/** Card Image for Queen of Hearts. */
	private ImageIcon hQ;
	/** Card Image for King of Hearts. */
	private ImageIcon hK;
	/** Card Image for the card back. */
	private ImageIcon cardBack;
	/** Game Model. **/
	private CasinoGamesPokerModel game = new CasinoGamesPokerModel();
	/** JLabel for the first card in the player's hand. */
	private final JLabel playerCard1 = new JLabel();
	/** JLabel for the second card in the player's hand. */
	private final JLabel playerCard2 = new JLabel();
	/** JLabel for the third card in the player's hand. */
	private final JLabel playerCard3 = new JLabel();
	/** JLabel for the fourth card in the player's hand. */
	private final JLabel playerCard4 = new JLabel();
	/** JLabel for the fifth card in the player's hand. */
	private final JLabel playerCard5 = new JLabel();
	/** JLabel array of all cards in the hand. */
	private final JLabel[] playerCards = {
			playerCard1, playerCard2, 
			playerCard3, playerCard4, playerCard5};
	/** JButton for holding the first card in the player's hand. */
	private final JButton holdCard1 = new JButton();
	/** JButton for holding the second card in the player's hand. */
	private final JButton holdCard2 = new JButton();
	/** JButton for holding the third card in the player's hand. */
	private final JButton holdCard3 = new JButton();
	/** JButton for holding the fourth card in the player's hand. */
	private final JButton holdCard4 = new JButton();
	/** JButton for holding the fifth card in the player's hand. */
	private final JButton holdCard5 = new JButton();
	/** JButton array for which cards are being held. */
	private final JButton holdCards[] = {
			holdCard1, holdCard2, 
			holdCard3, holdCard4, holdCard5};
	/** Button group for wager radio buttons. */
	private final ButtonGroup wager = new ButtonGroup();
	/** Radio Button for waging 100 credits. */
	private final JRadioButton wager100 = new JRadioButton("$100");
	/** Radio Button for waging 200 credits. */
	private final JRadioButton wager200 = new JRadioButton("$200");
	/** Radio Button for waging 300 credits. */
	private final JRadioButton wager300 = new JRadioButton("$300");
	/** Radio Button for waging 400 credits. */
	private final JRadioButton wager400 = new JRadioButton("$400");
	/** Radio Button for waging 500 credits. */
	private final JRadioButton wager500 = new JRadioButton("$500");
	/** JLabel to display current balance. */
	private final JLabel balance = new JLabel();
	/** JButton for placing a bet at the start of the game. */
	private final JButton bet = new JButton("Bet");
	/** JButton for drawing new cards after the first turn. */
	private final JButton draw = new JButton("Draw");
	/** JLabels for the multiplier list. */
	private final JLabel mult0 = new JLabel("Royal Pair: x1");
	/** JLabels for the multiplier list. */
	private final JLabel mult1 = new JLabel("Two Pair: x2");
	/** JLabels for the multiplier list. */
	private final JLabel mult2 = new JLabel("Three of a Kind: x3");
	/** JLabels for the multiplier list. */
	private final JLabel mult3 = new JLabel("Straight: x5");
	/** JLabels for the multiplier list. */
	private final JLabel mult4 = new JLabel("Flush: x6");
	/** JLabels for the multiplier list. */
	private final JLabel mult5 = new JLabel("Full House: x9");
	/** JLabels for the multiplier list. */
	private final JLabel mult6 = new JLabel("Four of a Kind: x25");
	/** JLabels for the multiplier list. */
	private final JLabel mult7 = new JLabel("Straight Flush: x50");
	/** JLabels for the multiplier list. */
	private final JLabel mult8 = new JLabel("Royal Flush: x250");
	
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokerGUI window = new PokerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PokerGUI() {
		initializeCardBack();
		initializeCardImageClubs();
		initializeCardImageSpades();
		initializeCardImageDiamonds();
		initializeCardImageHearts();
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel playerHandPanel = new JPanel();
		playerHandPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Player Hand", TitledBorder.LEFT, 
				TitledBorder.TOP, null, null));
		playerHandPanel.setBounds(10, 190, 500, 160);
		playerHandPanel.setLayout(null);
		frame.getContentPane().add(playerHandPanel);
		
		JPanel multiplierPanel = new JPanel();
		multiplierPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Hand Multipliers", TitledBorder.LEFT, 
				TitledBorder.TOP, null, null));
		multiplierPanel.setBounds(10,11,450,200);
		multiplierPanel.setLayout(null);
		frame.getContentPane().add(multiplierPanel);
		mult0.setBounds(10, 11, 400, 100);
		mult1.setBounds(100, 11, 400, 100);
		mult2.setBounds(180, 11, 400, 100);
		mult3.setBounds(310, 11, 400, 100);
		mult4.setBounds(10, 11, 400, 175);
		mult5.setBounds(90, 11, 400, 175);
		mult6.setBounds(200, 11, 400, 175);
		mult7.setBounds(10, 11, 400, 250);
		mult8.setBounds(150, 11, 400, 250);
		multiplierPanel.add(mult0);
		multiplierPanel.add(mult1);
		multiplierPanel.add(mult2);
		multiplierPanel.add(mult3);
		multiplierPanel.add(mult4);
		multiplierPanel.add(mult5);
		multiplierPanel.add(mult6);
		multiplierPanel.add(mult7);
		multiplierPanel.add(mult8);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Controls", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		controlPanel.setBounds(505, 20, 179, 330);
		controlPanel.setLayout(null);
		frame.getContentPane().add(controlPanel);
		
		bet.setBounds(45, 22, 89, 23);
		controlPanel.add(bet);
		
		draw.setEnabled(false);
		draw.setBounds(45, 56, 89, 23);
		controlPanel.add(draw);
		
		JPanel wagerPanel = new JPanel();
		wagerPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Wager", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		wagerPanel.setBounds(45, 124, 90, 152);
		controlPanel.add(wagerPanel);
		wagerPanel.setLayout(null);

		wager100.setBounds(6, 19, 79, 23);
		wagerPanel.add(wager100);

		wager200.setBounds(6, 45, 79, 23);
		wagerPanel.add(wager200);

		wager300.setBounds(6, 71, 79, 23);
		wagerPanel.add(wager300);

		wager400.setBounds(6, 97, 79, 23);
		wagerPanel.add(wager400);

		wager500.setBounds(6, 123, 79, 23);
		wagerPanel.add(wager500);

		wager.add(wager100);
		wager.add(wager200);
		wager.add(wager300);
		wager.add(wager400);
		wager.add(wager500);
		
		JPanel balancePanel = new JPanel();
		balancePanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Credits", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		balancePanel.setBounds(45, 276, 90, 43);

		controlPanel.add(balancePanel);
		balancePanel.setLayout(null);
		balance.setHorizontalAlignment(SwingConstants.CENTER);
		balance.setBounds(10, 14, 70, 21);
		balance.setText(""+game.getPlayer().getBalance());
		balancePanel.add(balance);

		
		playerCard1.setBackground(Color.GRAY);
		playerCard1.setBounds(10, 22, 88, 127);
		playerCard1.setIcon(cardBack);
		playerHandPanel.add(playerCard1);
		
		holdCard1.setOpaque(false);
		holdCard1.setContentAreaFilled(false);
		holdCard1.setBounds(10, 22, 88, 127);
		playerHandPanel.add(holdCard1);
		
		playerCard2.setBackground(Color.GRAY);
		playerCard2.setBounds(108, 22, 88, 127);
		playerCard2.setIcon(cardBack);
		playerHandPanel.add(playerCard2);
		
		holdCard2.setOpaque(false);
		holdCard2.setContentAreaFilled(false);
		holdCard2.setBounds(108, 22, 88, 127);
		playerHandPanel.add(holdCard2);
		
		playerCard3.setBackground(Color.GRAY);
		playerCard3.setBounds(206, 22, 88, 127);
		playerCard3.setIcon(cardBack);
		playerHandPanel.add(playerCard3);
		
		holdCard3.setOpaque(false);
		holdCard3.setContentAreaFilled(false);
		holdCard3.setBounds(206, 22, 88, 127);
		playerHandPanel.add(holdCard3);
		
		playerCard4.setBackground(Color.GRAY);
		playerCard4.setBounds(304, 22, 88, 127);
		playerCard4.setIcon(cardBack);
		playerHandPanel.add(playerCard4);
		
		holdCard4.setOpaque(false);
		holdCard4.setContentAreaFilled(false);
		holdCard4.setBounds(304, 22, 88, 127);
		playerHandPanel.add(holdCard4);
		
		playerCard5.setBackground(Color.GRAY);
		playerCard5.setBounds(402, 22, 88, 127);
		playerCard5.setIcon(cardBack);
		playerHandPanel.add(playerCard5);
		
		holdCard5.setOpaque(false);
		holdCard5.setContentAreaFilled(false);
		holdCard5.setBounds(402, 22, 88, 127);
		playerHandPanel.add(holdCard5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(520, 11, 154, 160);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

	}
	
	
	
	/**
	 * Enable game buttons.
	 */
	private void enableGameButtons(){
		holdCard1.setEnabled(true);
		holdCard2.setEnabled(true);
		holdCard3.setEnabled(true);
		holdCard4.setEnabled(true);
		holdCard5.setEnabled(true);
	}
	
	/**
	 * Disables game buttons.
	 */
	private void disableGameButtons(){
		holdCard1.setEnabled(false);
		holdCard2.setEnabled(false);
		holdCard3.setEnabled(false);
		holdCard4.setEnabled(false);
		holdCard5.setEnabled(false);
	}
	
	/**
	 * Helper Method for enabling wager radio buttons.
	 */
	private void enableWager() {
		wager100.setEnabled(true);
		wager200.setEnabled(true);
		wager300.setEnabled(true);
		wager400.setEnabled(true);
		wager500.setEnabled(true);
	}

	/**
	 * Helper Method for disabling wager radio buttons.
	 */
	private void disableWager() {
		wager100.setEnabled(false);
		wager200.setEnabled(false);
		wager300.setEnabled(false);
		wager400.setEnabled(false);
		wager500.setEnabled(false);
	}

	/**
	 * Helper Method for setting up anonymous Methods.
	 */
	private void anonymousListeners() {
		
		bet.addActionListener(new ActionListener() {
			@Override
			/*Anonymous method for starting the game with a bet*/
			public void actionPerformed(final ActionEvent e) {
				game.startGame();
				disableWager();
				enableGameButtons();
				
			}
		});
		
		draw.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for drawing new cards on the last turn */
			public void actionPerformed(final ActionEvent e){
				disableGameButtons();
				game.nextTurn();
				updatePlayerHand();
				endGame();
				enableWager();
			}
		});
		
		holdCard1.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				holdCard1.setEnabled(true);
				game.getPlayer().getHand().get(0).fliphold();
			}
			
		});
		
		holdCard2.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				holdCard2.setEnabled(true);
				game.getPlayer().getHand().get(1).fliphold();
			}
			
		});
		
		holdCard3.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				holdCard3.setEnabled(true);
				game.getPlayer().getHand().get(2).fliphold();
			}
			
		});
		
		holdCard4.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				holdCard4.setEnabled(true);
				game.getPlayer().getHand().get(3).fliphold();
			}
			
		});
		
		holdCard5.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				holdCard5.setEnabled(true);
				game.getPlayer().getHand().get(4).fliphold();
			}
			
		});
		
		wager100.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for a wager radio button. 
			 * Sets the wagered amount.
			 */
			public void actionPerformed(final ActionEvent e) {
				game.setWager(100);
			}

		});

		wager200.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for a wager radio button. 
			 * Sets the wagered amount.
			 */
			public void actionPerformed(final ActionEvent e) {
				game.setWager(200);
			}

		});

		wager300.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for a wager radio button. 
			 * Sets the wagered amount.
			 */
			public void actionPerformed(final ActionEvent e) {
				game.setWager(300);
			}

		});

		wager400.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for a wager radio button. 
			 * Sets the wagered amount.
			 */
			public void actionPerformed(final ActionEvent e) {
				game.setWager(400);
			}

		});

		wager500.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for a wager radio button. 
			 * Sets the wagered amount.
			 */
			public void actionPerformed(final ActionEvent e) {
				game.setWager(500);
			}

		});
	}
	
	/**
	 * Update the player's hand visual.
	 */
	private void updatePlayerHand() {
		for (int i = 0; i < game.getPlayer().getHand().size(); i++) {
			playerCards[i].setIcon(parseCard(
					game.getPlayer().getHand().get(i)));
		}
	}
	
	/**
	 * Ends the hand.
	 */
	private void endGame(){
		if(game.isRoyalPair(game.getPlayer())){
			game.getPlayer().addBalance(game.getWager());
		}
		else if(game.isTwoPair(game.getPlayer())){
			game.getPlayer().addBalance(2*game.getWager());
		}
		else if(game.isOfAKind(game.getPlayer())==3){
			game.getPlayer().addBalance(3*game.getWager());
		}
		else if(game.isStraight(game.getPlayer())){
			game.getPlayer().addBalance(5*game.getWager());
		}
		else if(game.isFlush(game.getPlayer())){
			game.getPlayer().addBalance(6*game.getWager());
		}
		else if(game.isFullHouse(game.getPlayer())){
			game.getPlayer().addBalance(9*game.getWager());
		}
		else if(game.isOfAKind(game.getPlayer())==4){
			game.getPlayer().addBalance(25*game.getWager());
		}
		else if(game.isStraightFlush(game.getPlayer())){
			game.getPlayer().addBalance(50*game.getWager());
		}
		else if(game.isRoyalFlush(game.getPlayer())){
			game.getPlayer().addBalance(250*game.getWager());
		}
		else{
			game.getPlayer().addBalance(-1*game.getWager());
		}
		game.getPlayer().clearHand();
		game.startGame();
	}
	
	/**
	 * Helper Method for getting the card image for a specific card in hand.
	 * @param card Card that is getting an image.
	 * @return icon the image icon for the card.
	 */
	private ImageIcon parseCard(final Card card) {
		ImageIcon icon = null;
		switch (card.getsuit()) {
		case CLUBS: 
			icon = getCardImageClubs(card);
			break;
		case SPADES:
			icon = getCardImageSpades(card);
			break;
		case DIAMONDS:
			icon = getCardImageDiamonds(card);
			break;
		case HEARTS:
			icon = getCardImageHearts(card);
			break;
		default:
			break;
		}
		return icon;
	}
	
	
	/**
	 * Get card image for clubs.
	 * @param card Card that is getting an image.
	 * @return icon the image icon for the card.
	 */
	private ImageIcon getCardImageClubs(final Card card) {
		ImageIcon icon = null;
		switch (card.getValue()) {
		case ACE:
			icon = cA;
			break;
		case TWO:
			icon = c2;
			break;
		case THREE:
			icon = c3;
			break;
		case FOUR:
			icon = c4;
			break;
		case FIVE:
			icon = c5;
			break;
		case SIX:
			icon = c6;
			break;
		case SEVEN:
			icon = c7;
			break;
		case EIGHT:
			icon = c8;
			break;
		case NINE:
			icon = c9;
			break;
		case TEN:
			icon = c0;
			break;
		case JACK:
			icon = cJ;
			break;
		case QUEEN:
			icon = cQ;
			break;
		case KING:
			icon = cK;
			break;
		default:
			break;
		}
		return icon;
	}

	/**
	 * Get card image for Spades.
	 * @param card Card that is getting an image.
	 * @return icon the image icon for the card.
	 */
	private ImageIcon getCardImageSpades(final Card card) {
		ImageIcon icon = null;
		switch (card.getValue()) {
		case ACE:
			icon = sA;
			break;
		case TWO:
			icon = s2;
			break;
		case THREE:
			icon = s3;
			break;
		case FOUR:
			icon = s4;
			break;
		case FIVE:
			icon = s5;
			break;
		case SIX:
			icon = s6;
			break;
		case SEVEN:
			icon = s7;
			break;
		case EIGHT:
			icon = s8;
			break;
		case NINE:
			icon = s9;
			break;
		case TEN:
			icon = s0;
			break;
		case JACK:
			icon = sJ;
			break;
		case QUEEN:
			icon = sQ;
			break;
		case KING:
			icon = sK;
			break;
		default:
			break;
		}
		return icon;
	}

	/**
	 * Get card image for Diamonds.
	 * @param card Card that is getting an image.
	 * @return icon the image icon for the card.
	 */
	private ImageIcon getCardImageDiamonds(final Card card) {
		ImageIcon icon = null;
		switch (card.getValue()) {
		case ACE:
			icon = dA;
			break;
		case TWO:
			icon = d2;
			break;
		case THREE:
			icon = d3;
			break;
		case FOUR:
			icon = d4;
			break;
		case FIVE:
			icon = d5;
			break;
		case SIX:
			icon = d6;
			break;
		case SEVEN:
			icon = d7;
			break;
		case EIGHT:
			icon = d8;
			break;
		case NINE:
			icon = d9;
			break;
		case TEN:
			icon = d0;
			break;
		case JACK:
			icon = dJ;
			break;
		case QUEEN:
			icon = dQ;
			break;
		case KING:
			icon = dK;
			break;
		default:
			break;
		}
		return icon;
	}

	/**
	 * Get card image for Hearts.
	 * @param card Card that is getting an image.
	 * @return icon the image icon for the card.
	 */
	private ImageIcon getCardImageHearts(final Card card) {
		ImageIcon icon = null;
		switch (card.getValue()) {
		case ACE:
			icon = hA;
			break;
		case TWO:
			icon = h2;
			break;
		case THREE:
			icon = h3;
			break;
		case FOUR:
			icon = h4;
			break;
		case FIVE:
			icon = h5;
			break;
		case SIX:
			icon = h6;
			break;
		case SEVEN:
			icon = h7;
			break;
		case EIGHT:
			icon = h8;
			break;
		case NINE:
			icon = h9;
			break;
		case TEN:
			icon = h0;
			break;
		case JACK:
			icon = hJ;
			break;
		case QUEEN:
			icon = hQ;
			break;
		case KING:
			icon = hK;
			break;
		default:
			break;
		}
		return icon;
	}

	
	/**
	 * Test Method for images. /
	 */
	/*private void testImage() {
		playerCard1.setIcon(c2);
		playerCard2.setIcon(cardBack);
		playerCard3.setIcon(hK);
		playerCard4.setIcon(d7);
		playerCard5.setIcon(s0);
	}*/
	
	/**
	 * Initialize image for card back.
	 */
	private void initializeCardBack() {
		Image img = null;

		try {
			img = ImageIO.read(new File("PNG/red_back.png"));
			Image cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);
			cardBack = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the club images for the deck.
	 */
	private void initializeCardImageClubs() {
		Image img = null;
		Image cimg = null;

		try {
			img = ImageIO.read(new File("PNG/AC.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			cA = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/2C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c2 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/3C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c3 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/4C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c4 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/5C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c5 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/6C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c6 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/7C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c7 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/8C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c8 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/9C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c9 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/10C.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			c0 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/JC.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			cJ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/QC.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			cQ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/KC.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			cK = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initializes card images for spades.
	 */
	private void initializeCardImageSpades() {
		Image img = null;
		Image cimg = null;
		
		try {
			img = ImageIO.read(new File("PNG/AS.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			sA = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/2S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s2 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/3S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s3 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/4S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s4 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/5S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s5 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/6S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s6 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/7S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s7 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/8S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s8 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/9S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s9 = new ImageIcon(cimg);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/10S.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			s0 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/JS.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			sJ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/QS.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			sQ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/KS.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			sK = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initialize Card Images for Diamonds.
	 */
	private void initializeCardImageDiamonds() {
		Image img = null;
		Image cimg = null;
		try {
			img = ImageIO.read(new File("PNG/AD.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			dA = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/2D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d2 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/3D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d3 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/4D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d4 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/5D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d5 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/6D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d6 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/7D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d7 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/8D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d8 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/9D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d9 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/10D.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			d0 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/JD.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			dJ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/QD.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			dQ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/KD.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			dK = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initialize CardImages for Hearts.
	 */
	private void initializeCardImageHearts() {
		Image img = null;
		Image cimg = null;
		
		try {
			img = ImageIO.read(new File("PNG/AH.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			hA = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/2H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h2 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/3H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h3 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/4H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h4 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/5H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h5 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/6H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h6 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/7H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h7 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/8H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h8 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/9H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h9 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/10H.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			h0 = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/JH.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			hJ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/QH.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			hQ = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			img = ImageIO.read(new File("PNG/KH.png"));
			cimg = img.getScaledInstance(88, 
					127, Image.SCALE_SMOOTH);

			hK = new ImageIcon(cimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Method for returning the Jframe to the main class.
	 * 
	 * @return The Jframe Stage so the GUI can be ran from the main method.
	 */
	public JFrame getFrame() {
		return frame;
	}
}
