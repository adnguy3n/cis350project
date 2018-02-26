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
		stage.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.add(play, null);
		buttonPanel.add(hit, null);
		buttonPanel.add(stand, null);
		stage.add(output, BorderLayout.CENTER);
		
		
	}
	
}
