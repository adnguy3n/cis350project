package casinogames;

import java.awt.EventQueue;

public class CasinoGamesMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CasinoGUI window = new CasinoGUI();
					window.frame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// TODO Auto-generated method stub
				//CasinoGamesBlackJackModel game = new CasinoGamesBlackJackModel();
				//game.test_PrintOutDeck();
				//boolean test = true;
				//while (test = true)
				//{
					//game.test_game();
				//}
	}
		

}