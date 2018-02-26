package casinoGames;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class casinoGUI extends JFrame{

	private JFrame stage;
	private JPanel buttonPanel = new JPanel();
	private JButton play = new JButton("Play");
	private JButton hit = new JButton("Hit	");
	private JButton stand = new JButton("Stand");
	private JPanel output = new JPanel();
	private JTextArea playerArea = new JTextArea();
	private JTextArea dealerArea = new JTextArea();
	
	/*
	 * Construction of the JFrame
	 */
	public casinoGUI(){
		stage  = new JFrame();
		stage.setSize(new Dimension(700,400));
		stage.setTitle("BlackJack");
		stage.setLayout(new BorderLayout());
		//outputPanel.setLayout(new BorderLayout());
		stage.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(play, null);
		buttonPanel.add(hit, null);
		buttonPanel.add(stand, null);
		stage.add(output, BorderLayout.CENTER);
		output.setLayout(new FlowLayout());
		output.add(dealerArea, null);
		output.add(playerArea, null);
		int width = getWidth();
		int height = getHeight();
		playerArea.setText(" ");
		dealerArea.setText(" ");
		stage.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void playAction(ActionListener x){
		play.addActionListener(x);
	}
	
	private void hitAction(ActionListener x){
		hit.addActionListener(x);
	}
	
	private void standAction(ActionListener x){
		stand.addActionListener(x);
	}
	
	private void displayPlayer(player one){
		playerArea.setText("P1: "+one.getHandValue());
	}
	
	private void displayDealer(player dealer){
		dealerArea.setText("Dealer: "+dealer.getHandValue());
	}
	
	private void enableGameButtons(){
		hit.setEnabled(true);
		stand.setEnabled(true);
		play.setEnabled(false);
	}
	
	private void enableStartButton(){
		play.setEnabled(true);
		hit.setEnabled(false);
		stand.setEnabled(false);
	}
	
	private void displayDealerCard(Card card){
		dealerArea.setText("Dealer reveals: "+card);
	}
	
	/*
	 * Method for returning the Jframe to the main class.
	 */
	public JFrame frame()
	{
		return stage;
	}
	
}
