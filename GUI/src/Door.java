import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

import java.awt.Cursor;

public class Door {

	private JFrame frame;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Door window = new Door();
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
	public Door() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.setBounds(new Rectangle(0, 0, 0, 0));
		frame.setBackground(new java.awt.Color(81, 68, 57));
		frame.getContentPane().setBackground(new java.awt.Color(81, 68, 57));
		frame.setBounds(0, 0, 1181, 1476); //Screen Resolution
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().setBounds(0, 0, 1181, 1476); //Screen Resolution
		
		/**
		 * Create the panel for the home page.
		 */
		final JPanel home = new JPanel();
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(home, "name_13597517755418");
		home.setLayout(null);
			
			/**
			 * Create the background image for the initial view.
			 */
		
			ImageIcon next = new ImageIcon("images/EmptyBar.png");
			JButton btnNext = new JButton(next);
			btnNext.setBorder(BorderFactory.createEmptyBorder());
			btnNext.setContentAreaFilled(false);
			btnNext.setBounds(140, 30, 900, 720);
			home.add(btnNext);
		
			ImageIcon background = new ImageIcon("images/Slide1.png");
			JLabel label1 = new JLabel();
			label1.setBounds(140, -360, 1181, 1476);
			label1.setIcon(background);
			
			JPanel panel1 = new JPanel();
			panel1.setBounds(0, 0, 0, 0);
			panel1.setLayout(null);
			home.add(label1);
		
			
		/**
		 * Create the panel for the active page.
		 */
		final JPanel active = new JPanel();
		active.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(active, "name_13597517755418");
		active.setLayout(null);
		
			/**
			 * Create the background image for the active view.
			 */
		
			ImageIcon next2 = new ImageIcon("images/OneFourth.png");
			JButton btnNext2 = new JButton(next2);
			btnNext2.setBorder(BorderFactory.createEmptyBorder());
			btnNext2.setContentAreaFilled(false);
			btnNext2.setBounds(140, 30, 900, 720);
			active.add(btnNext2);
		
			ImageIcon background2 = new ImageIcon("images/Slide2.png");
			JLabel label2 = new JLabel();
			label2.setBounds(140, -360, 1181, 1476);
			label2.setIcon(background2);
		
			JPanel panel2 = new JPanel();
			panel2.setBounds(0, 0, 0, 0);
			panel2.setLayout(null);
			active.add(label2);
		
			btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			active.setVisible(true);
			home.setVisible(false);
			}
		});
			
		/**
		 * Create the panel for the facial page.
		 */
		final JPanel facial = new JPanel();
		facial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(facial, "name_13597517755418");
		facial.setLayout(null);
			
		/**
		 * Create the background image for the active view.
		 */
		
			ImageIcon next3 = new ImageIcon("images/OneFourth.png");
			JButton btnNext3 = new JButton(next3);
			btnNext3.setBorder(BorderFactory.createEmptyBorder());
			btnNext3.setContentAreaFilled(false);
			btnNext3.setBounds(140, 30, 900, 720);
			facial.add(btnNext3);
			
			ImageIcon background3 = new ImageIcon("images/Slide3.png");
			JLabel label3 = new JLabel();
			label3.setBounds(140, -360, 1181, 1476);
			label3.setIcon(background3);
				
			JPanel panel3 = new JPanel();
			panel3.setBounds(0, 0, 0, 0);
			panel3.setLayout(null);
			facial.add(label3);
				
			btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			facial.setVisible(true);
			active.setVisible(false);
			}
		});
		
		/**
		 * Create the panel for the in-between page.
		 */
		final JPanel correct = new JPanel();
		correct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(correct, "name_13597517755418");
		correct.setLayout(null);
			
			/**
			 * Create the background image for the in-between view.
			 */
			
			ImageIcon next4 = new ImageIcon("images/HalfBar.png");
			JButton btnNext4 = new JButton(next4);
			btnNext4.setBorder(BorderFactory.createEmptyBorder());
			btnNext4.setContentAreaFilled(false);
			btnNext4.setBounds(140, 30, 900, 720);
			correct.add(btnNext4);
			
			ImageIcon background4 = new ImageIcon("images/Slide4.png");
			JLabel label4 = new JLabel();
			label4.setBounds(140, -360, 1181, 1476);
			label4.setIcon(background4);
				
			JPanel panel4 = new JPanel();
			panel4.setBounds(0, 0, 0, 0);
			panel4.setLayout(null);
			correct.add(label4);
				
			btnNext3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			correct.setVisible(true);
			facial.setVisible(false);
			}
		});
		
		/**
		 * Create the panel for the microphone page.
		 */
		final JPanel microphone = new JPanel();
		microphone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(microphone, "name_13597517755418");
		microphone.setLayout(null);
			
			/**
			 * Create the background image for the microphone view.
			 */
			
			ImageIcon next5 = new ImageIcon("images/HalfBar.png");
			JButton btnNext5 = new JButton(next5);
			btnNext5.setBorder(BorderFactory.createEmptyBorder());
			btnNext5.setContentAreaFilled(false);
			btnNext5.setBounds(140, 30, 900, 720);
			microphone.add(btnNext5);
			
			ImageIcon background5 = new ImageIcon("images/Slide5.png");
			JLabel label5 = new JLabel();
			label5.setBounds(140, -360, 1181, 1476);
			label5.setIcon(background5);
				
			JPanel panel5 = new JPanel();
			panel5.setBounds(0, 0, 0, 0);
			panel5.setLayout(null);
			microphone.add(label5);
				
			btnNext4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			microphone.setVisible(true);
			correct.setVisible(false);
			}
		});
		
		/**
		 * Create the panel for the in-between page.
		 */
		final JPanel correct2 = new JPanel();
		correct2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(correct2, "name_13597517755418");
		correct2.setLayout(null);
			
			/**
			 * Create the background image for the in-between view.
			 */
			
			ImageIcon next6 = new ImageIcon("images/ThreeFourth.png");
			JButton btnNext6 = new JButton(next6);
			btnNext6.setBorder(BorderFactory.createEmptyBorder());
			btnNext6.setContentAreaFilled(false);
			btnNext6.setBounds(140, 30, 900, 720);
			correct2.add(btnNext6);
			
			ImageIcon background6 = new ImageIcon("images/Slide6.png");
			JLabel label6 = new JLabel();
			label6.setBounds(140, -360, 1181, 1476);
			label6.setIcon(background6);
				
			JPanel panel6 = new JPanel();
			panel6.setBounds(0, 0, 0, 0);
			panel6.setLayout(null);
			correct2.add(label6);
				
			btnNext5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			correct2.setVisible(true);
			microphone.setVisible(false);
			}
		});
		
		/**
		 * Create the panel for the unlock page.
		 */
		final JPanel unlock = new JPanel();
		unlock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(unlock, "name_13597517755418");
		unlock.setLayout(null);
			
			/**
			 * Create the background image for the unlock view.
			 */
			
			ImageIcon next7 = new ImageIcon("images/FullBar.png");
			JButton btnNext7 = new JButton(next7);
			btnNext7.setBorder(BorderFactory.createEmptyBorder());
			btnNext7.setContentAreaFilled(false);
			btnNext7.setBounds(140, 30, 900, 720);
			unlock.add(btnNext7);
			
			ImageIcon background7 = new ImageIcon("images/Slide7.png");
			JLabel label7 = new JLabel();
			label7.setBounds(140, -360, 1181, 1476);
			label7.setIcon(background7);
				
			JPanel panel7 = new JPanel();
			panel7.setBounds(0, 0, 0, 0);
			panel7.setLayout(null);
			unlock.add(label7);
				
			btnNext6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			unlock.setVisible(true);
			correct2.setVisible(false);
			}
		});

	}
}