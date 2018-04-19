package casinogames;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

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
	private ImageIcon cardBack;
	private JLabel playerCard1;

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
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel playerHandPanel = new JPanel();
		playerHandPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Player Hand", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		playerHandPanel.setBounds(10, 190, 500, 160);
		playerHandPanel.setLayout(null);

		frame.getContentPane().add(playerHandPanel);
		
		playerCard1 = new JLabel("");
		playerCard1.setBackground(Color.GRAY);
		playerCard1.setBounds(10, 22, 88, 127);
		playerHandPanel.add(playerCard1);
		
		JLabel playerCard2 = new JLabel("");
		playerCard2.setBackground(Color.GRAY);
		playerCard2.setBounds(108, 22, 88, 127);
		playerHandPanel.add(playerCard2);
		
		JLabel playerCard3 = new JLabel("");
		playerCard3.setBackground(Color.GRAY);
		playerCard3.setBounds(206, 22, 88, 127);
		playerHandPanel.add(playerCard3);
		
		JLabel playerCard4 = new JLabel("");
		playerCard4.setBackground(Color.GRAY);
		playerCard4.setBounds(304, 22, 88, 127);
		playerHandPanel.add(playerCard4);
		
		JLabel playerCard5 = new JLabel("");
		playerCard5.setBackground(Color.GRAY);
		playerCard5.setBounds(402, 22, 88, 127);
		playerHandPanel.add(playerCard5);

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
	
	private void initializeImage() {
		BufferedImage img = null;
		
		try {
		    img = ImageIO.read(new File("PNG/AC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		cA = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/2C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c2 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/3C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c3 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/4C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c4 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/5C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c5 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/6C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c6 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/7C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c7 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/8C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c8 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/9C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c9 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/10C.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		c0 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/JC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		cJ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/QC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		cQ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/KC.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		cK = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/AS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		sA = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/2S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s2 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/3S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s3 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/4S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s4 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/5S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s5 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/6S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s6 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/7S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s7 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/8S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s8 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/9S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s9 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/10S.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		s0 = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/JS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		sJ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/QS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		sQ = new ImageIcon(cimg);
		
		try {
		    img = ImageIO.read(new File("PNG/KS.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		cimg = img.getScaledInstance(playerCard1.getWidth(), playerCard1.getHeight(),
		        Image.SCALE_SMOOTH);
		
		sK = new ImageIcon(cimg);
	}
}
