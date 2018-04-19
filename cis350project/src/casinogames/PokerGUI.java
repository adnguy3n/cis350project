package casinogames;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PokerGUI {

	private JFrame frame;
	private ImageIcon cA;
	private ImageIcon c2;
	private ImageIcon c3;
	private ImageIcon c4;
	private ImageIcon c5;
	private ImageIcon c6;
	private ImageIcon c7;
	private ImageIcon c8;
	private ImageIcon c9;
	private ImageIcon c0;
	private ImageIcon cJ;
	private ImageIcon cQ;
	private ImageIcon cK;
	private ImageIcon sA;
	private ImageIcon s2;
	private ImageIcon s3;
	private ImageIcon s4;
	private ImageIcon s5;
	private ImageIcon s6;
	private ImageIcon s7;
	private ImageIcon s8;
	private ImageIcon s9;
	private ImageIcon s0;
	private ImageIcon sJ;
	private ImageIcon sQ;
	private ImageIcon sK;
	private ImageIcon dA;
	private ImageIcon d2;
	private ImageIcon d3;
	private ImageIcon d4;
	private ImageIcon d5;
	private ImageIcon d6;
	private ImageIcon d7;
	private ImageIcon d8;
	private ImageIcon d9;
	private ImageIcon d0;
	private ImageIcon dJ;
	private ImageIcon dQ;
	private ImageIcon dK;
	private ImageIcon hA;
	private ImageIcon h2;
	private ImageIcon h3;
	private ImageIcon h4;
	private ImageIcon h5;
	private ImageIcon h6;
	private ImageIcon h7;
	private ImageIcon h8;
	private ImageIcon h9;
	private ImageIcon h0;
	private ImageIcon hJ;
	private ImageIcon hQ;
	private ImageIcon hK;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		
	
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 11, 174, 239);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("PNG/2C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(dimg);
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
		*/
	}

}
