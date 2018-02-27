package casinoGames;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CasinoGUI extends JFrame{

	private JFrame stage;
	private JPanel buttonPanel = new JPanel();
	private JButton play = new JButton("Play");
	private JButton hit = new JButton("Hit	");
	private JButton stand = new JButton("Stand");
	private JPanel output = new JPanel();
	private CasinoGamesBlackJackModel game;
	private final JList<String> dealerHandList;
	private final JList<String> playerHandList;
	private DefaultListModel<String> playerHandModel;
	private DefaultListModel<String> dealerHandModel;
	private int playerWinCount;
	private int dealerWinCount;
	private final JLabel playerWinCountLbl = new JLabel("0");
	private final JLabel dealerWinCountLbl = new JLabel("0");
	
	/**
	 * Construction of the JFrame
	 */
	public CasinoGUI()
	{
		game = new CasinoGamesBlackJackModel();
		stage  = new JFrame();
		stage.setSize(new Dimension(700,400));
		stage.setTitle("BlackJack");
		stage.getContentPane().setLayout(null);
		buttonPanel.setBounds(0, 328, 684, 33);
		stage.getContentPane().add(buttonPanel);
		output.setBounds(0, 0, 684, 32);
		stage.getContentPane().add(output);
		output.setLayout(null);
		playerWinCountLbl.setBounds(70, 11, 46, 14);
		
		output.add(playerWinCountLbl);
		dealerWinCountLbl.setBounds(556, 11, 46, 14);
		
		output.add(dealerWinCountLbl);
		
		playerHandList = new JList<String>();
		playerHandModel = new DefaultListModel<String>();
		playerHandList.setModel(playerHandModel);
		playerHandList.setBounds(23, 43, 163, 247);
		stage.getContentPane().add(playerHandList);
		
		dealerHandList = new JList<String>();
		dealerHandModel = new DefaultListModel<String>();
		dealerHandList.setModel(dealerHandModel);
		dealerHandList.setBounds(498, 43, 163, 247);
		stage.getContentPane().add(dealerHandList);
		
		buttonPanel.add(play);
		buttonPanel.add(hit);
		buttonPanel.add(stand);
		enableStartButton();
		
		play.addActionListener(new ActionListener()
		{
			@Override
			/**
			 * Annoymous Method for play button. Deals cards to
			 * player and dealer.
			 */
			public void actionPerformed(ActionEvent e) 
			{
				game.startGame();
				enableGameButtons();
				updateHandPlayer();
				dealerHandModel.clear();
				dealerHandModel.addElement(game.getPlayer(0).getHand().get(0).getCardString());
			}
		});
		
		hit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				game.hit();
				if (game.isBust(game.getPlayer(game.getTurnPlayer())))
				{
					updateHandDealer();
					updateHandPlayer();
					endHand(true);
				}
				else
				{
					switch(game.getTurnPlayer())
					{
						case 0:
							updateHandDealer();
							break;
							
						case 1:
							updateHandPlayer();
							break;
					}
				}
			}
		});
		
		stand.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switch(game.getTurnPlayer())
				{
					case 0:
						endHand(false);
						break;
						
					case 1:
						game.stand();
						updateHandDealer();
						break;
				}
			}
		});
		
		stage.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	/**
	 * 
	 */
	private void updateHandPlayer()
	{
		playerHandModel.clear();
		for (int i= 0; i < game.getPlayer(1).getHand().size(); i++)
		{
			playerHandModel.addElement(game.getPlayer(1).getHand().get(i).getCardString());
		}
		
	}
	
	/**
	 * 
	 */
	private void updateHandDealer()
	{
		dealerHandModel.clear();
		for (int i= 0; i < game.getPlayer(0).getHand().size(); i++)
		{
			dealerHandModel.addElement(game.getPlayer(0).getHand().get(i).getCardString());
		}
	}
	
	private void endHand(boolean bust)
	{
		if (bust == true)
		{
			switch(game.getTurnPlayer())
			{
				case 0:
					playerWinCount++;
					break;
				
				case 1:
					dealerWinCount++;
					break;
			}
		}
		else if (game.isDraw(game.getPlayer(1), game.getPlayer(0)))
		{
			System.out.println("draw");
		}
		else if (game.dealerWon(game.getPlayer(1), game.getPlayer(0)))
		{
			dealerWinCount++;
		}
		else
		{
			playerWinCount++;
		}
		
		enableStartButton();
		game.gameReset();
		playerWinCountLbl.setText(""+playerWinCount);
		dealerWinCountLbl.setText(""+dealerWinCount);
	}
	
	/**
	 * 
	 */
	private void enableGameButtons(){
		hit.setEnabled(true);
		stand.setEnabled(true);
		play.setEnabled(false);
	}
	
	/**
	 * 
	 */
	private void enableStartButton(){
		play.setEnabled(true);
		hit.setEnabled(false);
		stand.setEnabled(false);
	}
	
	/**
	 * Method for returning the Jframe to the main class.
	 */
	public JFrame frame()
	{
		return stage;
	}
}
