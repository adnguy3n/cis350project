package casinoGames;
import javax.swing.*;

public class casinoGUI extends JFrame{

	private Container stage;
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
		stage = getContentPane();
		setSize(new Dimension(700,400));
		setTitle("BlackJack");
		stage.setLayout(new BorderLayout());
		outputPanel.setLayout(new BorderLayout());
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void playAction(ActionListener x){
		play.addActionListener(x);
	}
	
	public void hitAction(ActionListener x){
		hit.addActionListener(x);
	}
	public void standAction(ActionListener x){
		stand.addActionListener(x);
	}
	
	public void displayPlayer(player one){
		playerArea.setText("P1: "+one.getHandValue());
	}
	
	public void displayDealer(player dealer){
		dealerArea.setText("Dealer: "+dealer.getHandValue());
	}
	
	public void enableGameButtons(){
		hitButton.setEnabled(true);
		standButton.setEnabled(true);
		playButton.setEnabled(false);
	}
	
	public void enableStartButton(){
		playButton.setEnabled(true);
		hitButton.setEnabled(false);
		standButton.setEnabled(false);
	}
	
	public void displayDealerCard(card card){
		dealerArea.setText("Dealer reveals: "+card);
	}
}
