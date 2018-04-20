package casinogames;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

/**
 * Main Class has the main method.
 *
 */
public final class CasinoGamesMain {

	/**
	 * Main Method.
	 * 
	 * @param args Arguments for main method. Not used.
	 */
	public static void main(final String[] args) {
		//Asks which game the player wants to play.
		String game;
		Object[] possibilities = {"Black Jack", "Poker"};
		game = (String) JOptionPane.showInputDialog(
				null,
				"Enter number of decks:",
				"Number of Decks",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				1);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					switch (game) {
					//Play Black Jack.
					case "Black Jack":
						BlackJackGUI blackJack 
						= new BlackJackGUI();
						blackJack.getFrame().
						setVisible(true);
						break;

					//Play Poker.
					case "Poker":
						PokerGUI poker = 
						new PokerGUI();
						poker.getFrame().
						setVisible(true);
						break;

					default:
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,
						"You did not pick a game. "
							+ "Exiting!");
					System.exit(1);
				}
			}
		});

	}

	/**
	 * Private Constructor to prevent initialization. 
	 * Should never be called.
	 */
	private CasinoGamesMain() {

	}

}
