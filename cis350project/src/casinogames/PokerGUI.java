package casinogames;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
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
	/** Game Model **/
	private CasinoGamesPokerModel game;
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
	/** JButton for placing a bet at the start of the game */
	private final JButton bet = new JButton("Bet");
	/** JButton for drawing new cards after the first turn */
	private final JButton draw = new JButton("Draw");
	/** JLabels for the multiplier list */
	private final JLabel mult0 = new JLabel("Royal Pair: x1");
	private final JLabel mult1 = new JLabel("Two Pair: x2");
	private final JLabel mult2 = new JLabel("Three of a Kind: x3");
	private final JLabel mult3 = new JLabel("Straight: x5");
	private final JLabel mult4 = new JLabel("Flush: x6");
	private final JLabel mult5 = new JLabel("Full House: x9");
	private final JLabel mult6 = new JLabel("Four of a Kind: x25");
	private final JLabel mult7 = new JLabel("Straight Flush: x50");
	private final JLabel mult8 = new JLabel("Royal Flush: x250");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		testImage();
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
		mult5.setBounds(100, 11, 400, 175);
		mult6.setBounds(180, 11, 400, 175);
		multiplierPanel.add(mult0);
		multiplierPanel.add(mult1);
		multiplierPanel.add(mult2);
		multiplierPanel.add(mult3);
		multiplierPanel.add(mult4);
		multiplierPanel.add(mult5);
		multiplierPanel.add(mult6);
		
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
		//balance.setText("" + game.getPlayer().getBalance());

		balancePanel.add(balance);

		
		playerCard1.setBackground(Color.GRAY);
		playerCard1.setBounds(10, 22, 88, 127);
		playerHandPanel.add(playerCard1);
		
		holdCard1.setOpaque(false);
		holdCard1.setContentAreaFilled(false);
		holdCard1.setBounds(10, 22, 88, 127);
		playerHandPanel.add(holdCard1);
		
		playerCard2.setBackground(Color.GRAY);
		playerCard2.setBounds(108, 22, 88, 127);
		playerHandPanel.add(playerCard2);
		
		holdCard2.setOpaque(false);
		holdCard2.setContentAreaFilled(false);
		holdCard2.setBounds(108, 22, 88, 127);
		playerHandPanel.add(holdCard2);
		
		playerCard3.setBackground(Color.GRAY);
		playerCard3.setBounds(206, 22, 88, 127);
		playerHandPanel.add(playerCard3);
		
		holdCard3.setOpaque(false);
		holdCard3.setContentAreaFilled(false);
		holdCard3.setBounds(206, 22, 88, 127);
		playerHandPanel.add(holdCard3);
		
		playerCard4.setBackground(Color.GRAY);
		playerCard4.setBounds(304, 22, 88, 127);
		playerHandPanel.add(playerCard4);
		
		holdCard4.setOpaque(false);
		holdCard4.setContentAreaFilled(false);
		holdCard4.setBounds(304, 22, 88, 127);
		playerHandPanel.add(holdCard4);
		
		playerCard5.setBackground(Color.GRAY);
		playerCard5.setBounds(402, 22, 88, 127);
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
	
	
	
	/*Enables game buttons*/
	private void enableGameButtons(){
		holdCard1.setEnabled(true);
		holdCard2.setEnabled(true);
		holdCard3.setEnabled(true);
		holdCard4.setEnabled(true);
		holdCard5.setEnabled(true);
	}
	
	/*Disables game buttons*/
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

	
	
	
	/*Helper Method for setting up anonymous Methods.*/
	private void anonymousListeners(){
		holdCard1.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				game.startGame();
				enableGameButtons();
				holdCard1.setEnabled(true);
				game.getPlayer().getHand().get(0).fliphold();
			}
			
		});
		
		holdCard2.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				game.startGame();
				enableGameButtons();
				holdCard2.setEnabled(true);
				game.getPlayer().getHand().get(1).fliphold();
			}
			
		});
		
		holdCard3.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				game.startGame();
				enableGameButtons();
				holdCard3.setEnabled(true);
				game.getPlayer().getHand().get(2).fliphold();
			}
			
		});
		
		holdCard4.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				game.startGame();
				enableGameButtons();
				holdCard4.setEnabled(true);
				game.getPlayer().getHand().get(3).fliphold();
			}
			
		});
		
		holdCard5.addActionListener(new ActionListener(){
			@Override
			/*Anonymous method for holding card 1*/
			public void actionPerformed(final ActionEvent e){
				game.startGame();
				enableGameButtons();
				holdCard5.setEnabled(true);
				game.getPlayer().getHand().get(4).fliphold();
			}
			
		});
	}
	
	/**
	 * Test Method for images. /
	 */
	private void testImage() {
		playerCard1.setIcon(c2);
		playerCard2.setIcon(cardBack);
		playerCard3.setIcon(hK);
		playerCard4.setIcon(d7);
		playerCard5.setIcon(s0);
	}
	
	/**
	 * Initialize image for card back.
	 */
	private void initializeCardBack() {
		BufferedImage img = null;
		
		try {
		    img = ImageIO.read(new File("PNG/red_back.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		cardBack = new ImageIcon(cimg);
	}
	
	/**
	 * Intiailizes the club images for the deck.
	 */
	private void initializeCardImageClubs() {
		BufferedImage img = null;
		
		try {
		    img = ImageIO.read(new File("PNG/AC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		cA = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/2C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c2 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/3C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c3 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/4C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c4 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/5C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c5 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/6C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c6 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/7C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c7 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/8C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c8 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/9C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c9 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/10C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		c0 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/JC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		cJ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/QC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		cQ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/KC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		cK = new ImageIcon(cimg);
		
	}
	
	/**
	 * Initializes card images for spades.
	 */
	private void initializeCardImageSpades() {
		Image img = null;
		try {
		    img = ImageIO.read(new File("PNG/AS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		sA = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/2S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s2 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/3S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s3 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/4S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s4 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/5S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s5 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/6S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s6 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/7S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s7 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/8S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s8 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/9S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s9 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/10S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		s0 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/JS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		sJ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/QS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		sQ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/KS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		sK = new ImageIcon(cimg);
		
	}
	
	/**
	 * Initialize Card Images for Diamonds.
	 */
	private void initializeCardImageDiamonds() {
		Image img = null;
		try {
		    img = ImageIO.read(new File("PNG/AD.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		dA = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/2D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d2 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/3D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d3 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/4D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d4 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/5D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d5 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/6D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d6 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/7D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d7 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/8D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d8 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/9D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d9 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/10D.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		d0 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/JD.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		dJ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/QD.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		dQ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/KD.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		dK = new ImageIcon(cimg);
		
	}
	
	/**
	 * Initialize CardImages for Hearts.
	 */
	private void initializeCardImageHearts() {
		Image img = null;
		try {
		    img = ImageIO.read(new File("PNG/AH.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		hA = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/2H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h2 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/3H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h3 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/4H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h4 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/5H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h5 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/6H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h6 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/7H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h7 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/8H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h8 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/9H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h9 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/10H.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		h0 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/JH.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		hJ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/QH.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		hQ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/KH.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(88, 
				127, Image.SCALE_SMOOTH);
		
		hK = new ImageIcon(cimg);
	}
}
