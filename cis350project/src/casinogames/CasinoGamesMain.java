package casinogames;

import java.awt.EventQueue;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJackGUI window = new BlackJackGUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
