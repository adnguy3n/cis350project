package casinogames;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

/**
 * Graphical User Interface for Black Jack Game.
 * @author Lunaception
 *
 */
public class BlackJackGUI {

	/** JFrame containing all of the GUI components. */
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
	/** JLabel Array for the cards in the player's hand. */	
	private final JLabel[] playerCard = new JLabel[17];
	/** JLabel Array for the cards in the player's hand. */	
	private final JLabel[] dealerCard = new JLabel[17];
	/** JButton for starting a new hand.*/
	private final JButton play = new JButton("Play");
	/** JButton for Hitting. */
	private final JButton hit = new JButton("Hit");
	/** JButton for Standing. */
	private final JButton stand = new JButton("Stand");
	/** Blackjack Game Object that contains the logic for the game.*/
	private CasinoGamesBlackJackModel game;
	/** Button group for wager radio buttons. */
	private final ButtonGroup wager = new ButtonGroup();
	/** Radio Button for waging 100 credits. */
	private final JRadioButton wager100 = new JRadioButton("100 credits");
	/** Radio Button for waging 200 credits. */
	private final JRadioButton wager200 = new JRadioButton("200 credits");
	/** Radio Button for waging 300 credits. */
	private final JRadioButton wager300 = new JRadioButton("300 credits");
	/** Radio Button for waging 400 credits. */
	private final JRadioButton wager400 = new JRadioButton("400 credits");
	/** Radio Button for waging 500 credits. */
	private final JRadioButton wager500 = new JRadioButton("500 credits");
	/** JLabel to display current balance. */
	private final JLabel balance = new JLabel();

	/**
	 * Create the application.
	 */
	public BlackJackGUI() {
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
		game = new CasinoGamesBlackJackModel(decks);
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
		frame.setTitle("Black Jack");
		frame.setBounds(100, 100, 825, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//JPanel for the player's hand.
		JPanel playerHandPanel = new JPanel();
		playerHandPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Player Hand", 
				TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		playerHandPanel.setBounds(10, 182, 600, 160);
		playerHandPanel.setLayout(null);
		frame.getContentPane().add(playerHandPanel);

		//JPanel for the dealer's hand.
		JPanel dealerHandPanel = new JPanel();
		dealerHandPanel.setLayout(null);
		dealerHandPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Dealer Hand", 
				TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		dealerHandPanel.setBounds(10, 11, 600, 160);
		frame.getContentPane().add(dealerHandPanel);

		//JPanel for the Buttons.
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Controls", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		controlPanel.setBounds(620, 11, 179, 330);
		controlPanel.setLayout(null);
		frame.getContentPane().add(controlPanel);

		//Play, hit, and stand buttons.
		play.setBounds(45, 22, 89, 23);
		controlPanel.add(play);

		hit.setEnabled(false);
		hit.setBounds(45, 56, 89, 23);
		controlPanel.add(hit);

		stand.setEnabled(false);
		stand.setBounds(45, 90, 89, 23);
		controlPanel.add(stand);

		//Panel for Wager Buttons.
		JPanel wagerPanel = new JPanel();
		wagerPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Wager", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		wagerPanel.setBounds(33, 124, 113, 152);
		controlPanel.add(wagerPanel);
		wagerPanel.setLayout(null);

		//Radio Buttons for Wager
		wager100.setBounds(6, 19, 101, 23);
		wagerPanel.add(wager100);

		wager200.setBounds(6, 45, 101, 23);
		wagerPanel.add(wager200);

		wager300.setBounds(6, 71, 101, 23);
		wagerPanel.add(wager300);

		wager400.setBounds(6, 97, 101, 23);
		wagerPanel.add(wager400);

		wager500.setBounds(6, 123, 101, 23);
		wagerPanel.add(wager500);

		//Adding Wager buttons to button group.
		wager.add(wager100);
		wager.add(wager200);
		wager.add(wager300);
		wager.add(wager400);
		wager.add(wager500);
		wager100.setSelected(true);
		game.setWager(100);
		disableWager();

		//JPanel for the player's money balance.
		JPanel balancePanel = new JPanel();
		balancePanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), 
				"Credits", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		balancePanel.setBounds(45, 276, 90, 43);

		controlPanel.add(balancePanel);
		balancePanel.setLayout(null);
		
		//JLabel for displaying the player's money balance.
		balance.setHorizontalAlignment(SwingConstants.CENTER);
		balance.setBounds(10, 14, 70, 21);
		balance.setText("" + game.getPlayer(1).getBalance());

		balancePanel.add(balance);

		//Dealer's Cards.
		for (int i = 0; i < 17; i++) {
			dealerCard[16 - i] = new JLabel();
			dealerCard[16 - i].setBounds(10 + 30 * (16 - i), 
					21, 90, 125);
			dealerHandPanel.add(dealerCard[16 - i]);
		}

		//Player's Cards.
		for (int i = 0; i < 17; i++) {
			playerCard[16 - i] = new JLabel();
			playerCard[16 - i].setBounds(10 + 30 * (16 - i), 
					21, 90, 125);
			playerHandPanel.add(playerCard[16 - i]);
		}

		anonymousListeners();
	}

	/**
	 * Helper Method for setting up Anonymous methods.
	 */
	private void anonymousListeners() {
		play.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for play button. Deals cards to
			 * player and dealer.
			 */
			public void actionPerformed(final ActionEvent e) {
				clearHand();
				game.startGame();
				enableGameButtons();
				updatePlayerHand();
				dealerCard[0].setIcon(cardBack);
				dealerCard[1].setIcon(parseCard(
						game.getPlayer(0).
						getHand().get(1)));
			}
		});

		hit.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for the hit button. Deals a card
			 * to the active player.
			 */
			public void actionPerformed(final ActionEvent e) {
				game.hit();
				disableWager();
				if (game.isBust(game.
						getPlayer(game.
								getTurnPlayer()
								))) {
					updateDealerHand();
					updatePlayerHand();
					endHand(true);
				} else {
					switch (game.getTurnPlayer()) {
					case 0:
						updateDealerHand();
						break;

					case 1:
						updatePlayerHand();
						break;

					default:
						break;
					}
				}
			}
		});

		stand.addActionListener(new ActionListener() {
			@Override
			/**
			 * Anonymous Method for the Stand Button. Ends the
			 * active player's turn.
			 */
			public void actionPerformed(final ActionEvent e) {
				disableWager();
				switch (game.getTurnPlayer()) {
				case 0:
					endHand(false);
					break;

				case 1:
					game.stand();
					updateDealerHand();
					break;

				default:
					break;
				}
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
	 * Determines who won the round and adds increments their win counter.
	 * @param bust Boolean for whether or not the hand was a bust.
	 */
	private void endHand(final boolean bust) {
		if (bust) {
			switch (game.getTurnPlayer()) {
			case 0:
				JOptionPane.showMessageDialog(frame,
						"Player Wins!");
				game.getPlayer(1).
				addBalance(game.getWager());
				break;

			case 1:
				JOptionPane.showMessageDialog(frame,
						"Dealer Wins!");
				game.getPlayer(1).
				subBalance(game.getWager());
				break;

			default:
				break;
			}
		} else if (game.isDraw(game.getPlayer(1), game.getPlayer(0))) {
			JOptionPane.showMessageDialog(frame,
					"Draw!");
		} else if (game.dealerWon(game.getPlayer(1), 
				game.getPlayer(0))) {
			JOptionPane.showMessageDialog(frame,
					"Dealer Wins!");
			game.getPlayer(1).subBalance(game.getWager());
		} else {
			JOptionPane.showMessageDialog(frame,
					"Player Wins!");
			game.getPlayer(1).addBalance(game.getWager());
		}

		enableStartButton();
		game.gameReset();
		balance.setText("" + game.getPlayer(1).getBalance());

		//Exits game if player runs out of money.
		if (game.getPlayer(1).getBalance() <= 0) {
			JOptionPane.showMessageDialog(frame,
					"You're out of money!",
					"You're broke!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * Update the player's hand visual.
	 */
	private void updatePlayerHand() {
		for (int i = 0; i < game.getPlayer(1).getHand().size(); i++) {
			playerCard[i].setIcon(parseCard(
					game.getPlayer(1).getHand().get(i)));
		}
	}

	/**
	 * Update the dealer's hand visual.
	 */
	private void updateDealerHand() {
		for (int i = 0; i < game.getPlayer(0).getHand().size(); i++) {
			dealerCard[i].setIcon(parseCard(
					game.getPlayer(0).getHand().get(i)));
		}
	}

	/**
	 * Clears the Hand Visuals.
	 */
	private void clearHand() {
		for (int i = 0; i < 17; i++) {
			dealerCard[i].setIcon(null);
		}

		for (int i = 0; i < 17; i++) {
			playerCard[i].setIcon(null);
		}
	}

	/**
	 * Enable the Hit and Stand Buttons while disabling the play button.
	 */
	private void enableGameButtons() {
		hit.setEnabled(true);
		stand.setEnabled(true);
		play.setEnabled(false);
		enableWager();
	}

	/**
	 * Enable the Play Button while disabling the Hit and Stand Buttons.
	 */
	private void enableStartButton() {
		play.setEnabled(true);
		hit.setEnabled(false);
		stand.setEnabled(false);
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
	 * Method for returning the Jframe to the main class.
	 * 
	 * @return The Jframe Stage so the GUI can be ran from the main method.
	 */
	public JFrame getFrame() {
		return frame;
	}
}
