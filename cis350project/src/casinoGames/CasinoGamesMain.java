package casinoGames;

import java.awt.EventQueue;

public class CasinoGamesMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					casinoGUI window = new casinoGUI();
					window.frame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
