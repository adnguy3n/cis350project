package casinogames;

import java.awt.Image;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

/**
 *  GUI for Poker.
 */
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
	private CasinoGamesPokerModel game;
	/** JLabel array of cards in the hand. */
	private final JLabel[] playerCards = new JLabel[5];
	/** JPanel array for JPanels used to 
	 * visual show which cards are kept. */
	private final JPanel[] cardSlot = new JPanel[5];
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
	private final JButton play = new JButton("Play");
	/** JButton for drawing new cards after the first turn. */
	private final JButton redraw = new JButton("Re-Draw");
	/** Boolean flag to determine if a hand is in progress. */
	private boolean start = false;
	/** Log of the current game session. */
	private final JTextArea history = new JTextArea();
	/** Scroll Pane to hold history. */
	private final JScrollPane scroll = new JScrollPane(history);

	/**
	 * Create the application.
	 */
	public PokerGUI() {
		int decks = 1;
		Object[] possibilities = {1, 2, 3};
		try {
			decks = (int) JOptionPane.showInputDialog(
					null,
					"Enter number of decks:",
					"Number of Decks",
					JOptionPane.PLAIN_MESSAGE,
					null,
					possibilities,
					1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"You did not pick the number of decks. "
					+ "Defaulting to 1.");
		}
		game = new CasinoGamesPokerModel(decks);
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
		history.setEditable(false);
		frame = new JFrame();
		frame.setBounds(100, 100, 833, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel playerHandPanel = new JPanel();
		playerHandPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Player Hand", TitledBorder.LEFT, 
				TitledBorder.TOP, null, null));
		playerHandPanel.setBounds(10, 188, 610, 177);
		playerHandPanel.setLayout(null);
		frame.getContentPane().add(playerHandPanel);
		
		for (int i = 0; i < 5; i++) {
			cardSlot[i] = new JPanel();
			cardSlot[i].setBackground(SystemColor.control);
			cardSlot[i].setBounds(10 + (120 * i), 21, 110, 145);
			playerHandPanel.add(cardSlot[i]);
			cardSlot[i].setLayout(null);
			
			playerCards[i] = new JLabel();
			playerCards[i].setBounds(10, 11, 88, 127);
			playerCards[i].setIcon(cardBack);
			cardSlot[i].add(playerCards[i]);
		}
		
		JPanel multiplierPanel = new JPanel();
		multiplierPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Hand Multipliers", TitledBorder.LEFT, 
				TitledBorder.TOP, null, null));
		multiplierPanel.setBounds(10, 0, 149, 177);
		multiplierPanel.setLayout(null);
		frame.getContentPane().add(multiplierPanel);
		
		JTable multiplierListTable = new JTable();
		multiplierListTable.setShowHorizontalLines(false);
		multiplierListTable.setBackground(SystemColor.control);
		multiplierListTable.setShowGrid(false);
		multiplierListTable.setRowSelectionAllowed(false);
		multiplierListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"Royal Flush", "250x"},
				{"Straight Flush", "50x"},
				{"Four of a Kind", "25x"},
				{"Full House", "9x"},
				{"Flush", "6x"},
				{"Straight", "5x"},
				{"Three of a Kind", "3x"},
				{"Two Pair", "2x"},
				{"Royal Pair", "1x"},
			},
			new String[] {
				"Hand", "Multiplier"
			}
		));
		multiplierListTable.getColumnModel().
		getColumn(0).setPreferredWidth(83);
		multiplierListTable.getColumnModel().
		getColumn(1).setPreferredWidth(29);
		multiplierListTable.getColumnModel().
		getColumn(1).setMinWidth(2);
		multiplierListTable.setBounds(10, 21, 129, 145);
		multiplierPanel.add(multiplierListTable);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Controls", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		controlPanel.setBounds(630, 0, 180, 365);
		controlPanel.setLayout(null);
		frame.getContentPane().add(controlPanel);
		
		play.setBounds(45, 22, 89, 23);
		controlPanel.add(play);
		
		redraw.setEnabled(false);
		redraw.setBounds(45, 56, 89, 23);
		controlPanel.add(redraw);
		
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
		wager100.setSelected(true);
		game.setWager(100);
		
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
		balance.setText("" + game.getPlayer().getBalance());
		balancePanel.add(balance);
		
		scroll.setBounds(169, 11, 449, 166);
		scroll.setViewportView(history);
		frame.getContentPane().add(scroll);
		
		anonymousListeners();

	}
	
	/**
	 * Helper Method for setting up anonymous Methods.
	 */
	private void anonymousListeners() {
		
		play.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous method for starting the game.
			 */
			public void actionPerformed(final ActionEvent e) {
				start = true;
				game.resetKeep();
				game.getPlayer().clearHand();
				game.startGame();
				updatePlayerHand();
				disableWager();
				enableGameButtons();
				history.append("Drawing new hand. Wager: " 
				+ game.getWager() + " credits.\n");
			}
		});
		
		redraw.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous method for drawing new cards on the 
			 * last turn.
			 */
			public void actionPerformed(final ActionEvent e) {
				start = false;
				disableGameButtons();
				for (int i = 0; i < 5; i++) {
					if (!game.getKeep(i)) {
						game.redraw(i);
					}
				}
				updatePlayerHand();
				endGame();
				enableWager();
			}
		});
		
		for (int i = 0; i < 5; i++) {
			final int slot = i;
			playerCards[slot].addMouseListener(
					new MouseAdapter() {  
			    public void mouseClicked(final MouseEvent e) {  
			    	if (start) {
			    		game.setKeep(slot);
				    	updatePlayerHand();
			    	}
			    }  
			}); 
		}
		
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
	 * Enable game buttons.
	 */
	private void enableGameButtons() {
		redraw.setEnabled(true);
		play.setEnabled(false);
	}
	
	/**
	 * Disables game buttons.
	 */
	private void disableGameButtons() {
		redraw.setEnabled(false);
		play.setEnabled(true);
	}
	
	/**
	 * Helper Method for enabling wager radio buttons.
	 */
	private void enableWager() {
		wager100.setEnabled(true);
		
		if (game.getPlayer().getBalance() >= 200) {
			wager200.setEnabled(true);
		} else if (wager200.isSelected()) {
			wager100.setSelected(true);
			game.setWager(100);
		}
		
		if (game.getPlayer().getBalance() >= 300) {
			wager300.setEnabled(true);
		} else if (wager300.isSelected()) {
			wager100.setSelected(true);
			game.setWager(100);
		}
		
		if (game.getPlayer().getBalance() >= 400) {
			wager400.setEnabled(true);
		} else if (wager400.isSelected()) {
			wager100.setSelected(true);
			game.setWager(100);
		}
		
		if (game.getPlayer().getBalance() >= 500) {
			wager500.setEnabled(true);
		} else if (wager500.isSelected()) {
			wager100.setSelected(true);
			game.setWager(100);
		}
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
	 * Update the player's hand visual.
	 */
	private void updatePlayerHand() {
		for (int i = 0; i < game.getPlayer().getHand().size(); i++) {
			playerCards[i].setIcon(parseCard(
					game.getPlayer().getHand().get(i)));
			if (game.getKeep(i)) {
				cardSlot[i].setBackground(Color.GRAY);
			} else {
				cardSlot[i].setBackground(SystemColor.control);
			}
		}
	}
	
	/**
	 * Ends the hand.
	 */
	private void endGame() {
		switch (game.getResult()) {
			case ROYAL_FLUSH:
				JOptionPane.showMessageDialog(frame,
						"Royal Flush!");
				history.append("Royal Flush! +" 
						+ game.getWager() * 250 
						+ "credits.\n");
				break;
			case STRAIGHT_FLUSH:
				history.append("Straight Flush! +" 
						+ game.getWager() * 50 
						+ " credits.\n");
				break;
			case FOUR_OF_A_KIND:
				history.append("Four of a kind! +" 
						+ game.getWager() * 25 
						+ " credits.\n");
				break;
			case FULLHOUSE:
				history.append("Full House! +" 
						+ game.getWager() * 9 
						+ " credits.\n");
				break;
			case FLUSH:
				history.append("Flush. +" 
						+ game.getWager() * 6 
						+ " credits.\n");
				break;
			case STRAIGHT:
				history.append("You got a Straight. +" 
						+ game.getWager() * 5 
						+ " credits.\n");
				break;
			case THREE_OF_A_KIND:
				history.append("You got Three of a kind. +" 
						+ game.getWager() * 3 
						+ " credits.\n");
				break;
			case TWO_PAIR:
				history.append("You got Two Pairs. +" 
						+ game.getWager() * 2 
						+ " credits.\n");
				break;
			case ROYAL_PAIR:
				history.append("You got a Royal Pair. +" 
						+ game.getWager() 
						+ " credits.\n");
				break;
			default:
				//Exits game if player runs out of money.
				if (game.getPlayer().getBalance() < 100) {
					JOptionPane.showMessageDialog(frame,
						"You don't have enough money!",
						"~Better luck next time!~",
						JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				history.append("You got nothing. -" 
						+ game.getWager() 
						+ " credits.\n");
				break;
		}
		
		balance.setText("" + game.getPlayer().getBalance());
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
