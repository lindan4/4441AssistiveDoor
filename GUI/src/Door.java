import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
		
			//Progress Bar
			ImageIcon next = new ImageIcon("images/EmptyBar.png");
			JButton btnNext = new JButton(next);
			btnNext.setBorder(BorderFactory.createEmptyBorder());
			btnNext.setContentAreaFilled(false);
			btnNext.setBounds(140, 30, 900, 720);
			home.add(btnNext);
		
			//Inactive Power Icon
			ImageIcon PowerInactive = new ImageIcon("images/PowerInactive.png");
			JButton btnPowerInactive = new JButton(PowerInactive);
			btnPowerInactive.setBorder(BorderFactory.createEmptyBorder());
			btnPowerInactive.setContentAreaFilled(false);
			btnPowerInactive.setBounds(140, 18, 900, 720);
			home.add(btnPowerInactive);
			
			//Inactive Serious Icon
			ImageIcon SeriousInactive = new ImageIcon("images/SeriousInactive.png");
			JButton btnSeriousInactive = new JButton(SeriousInactive);
			btnSeriousInactive.setBorder(BorderFactory.createEmptyBorder());
			btnSeriousInactive.setContentAreaFilled(false);
			btnSeriousInactive.setBounds(140, 18, 900, 720);
			home.add(btnSeriousInactive);
			
			//Inactive Serious Icon
			ImageIcon PhraseInactive = new ImageIcon("images/PhraseInactive.png");
			JButton btnPhraseInactive = new JButton(PhraseInactive);
			btnPhraseInactive.setBorder(BorderFactory.createEmptyBorder());
			btnPhraseInactive.setContentAreaFilled(false);
			btnPhraseInactive.setBounds(140, 18, 900, 720);
			home.add(btnPhraseInactive);
			
			//Lock Icon
			ImageIcon Lock = new ImageIcon("images/Lock.png");
			JButton btnLock = new JButton(Lock);
			btnLock.setBorder(BorderFactory.createEmptyBorder());
			btnLock.setContentAreaFilled(false);
			btnLock.setBounds(140, 18, 900, 720);
			home.add(btnLock);
	
			//Blue Background
			JButton Background = new JButton(" ");
			Background.setHorizontalAlignment(SwingConstants.LEFT);
			Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
			Background.setOpaque(true);
			Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Background.setBackground(new Color(0, 77, 102));
			Background.setBounds(171, 147, 834, 563);
			home.add(Background);
		
			ImageIcon background = new ImageIcon("images/Background.png");
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
		
			JLabel greeting = new JLabel("Hello there!");
			greeting.setHorizontalAlignment(SwingConstants.CENTER);
			greeting.setForeground(new Color(255, 255, 255));
			greeting.setFont(new Font("Arial", Font.PLAIN, 36));
			greeting.setBounds(136, 130, 900, 720);
			active.add(greeting);
		
			//Progress Bar
			ImageIcon next2 = new ImageIcon("images/OneFourth.png");
			JButton btnNext2 = new JButton(next2);
			btnNext2.setBorder(BorderFactory.createEmptyBorder());
			btnNext2.setContentAreaFilled(false);
			btnNext2.setBounds(140, 30, 900, 720);
			active.add(btnNext2);
			
				btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				active.setVisible(true);
				home.setVisible(false);
			
			//Active Power Icon
			ImageIcon PowerActive = new ImageIcon("images/PowerActive.png");
			JButton btnPowerActive = new JButton(PowerActive);
			btnPowerActive.setBorder(BorderFactory.createEmptyBorder());
			btnPowerActive.setContentAreaFilled(false);
			btnPowerActive.setBounds(140, 18, 900, 720);
			active.add(btnPowerActive);
			
			//Inactive Happy Icon
			ImageIcon HappyInactive = new ImageIcon("images/HappyInactive.png");
			JButton btnHappyInactive = new JButton(HappyInactive);
			btnHappyInactive.setBorder(BorderFactory.createEmptyBorder());
			btnHappyInactive.setContentAreaFilled(false);
			btnHappyInactive.setBounds(140, 18, 900, 720);
			active.add(btnHappyInactive);
			
			//Inactive Phrase Icon
			ImageIcon PhraseInactive = new ImageIcon("images/PhraseInactive.png");
			JButton btnPhraseInactive = new JButton(PhraseInactive);
			btnPhraseInactive.setBorder(BorderFactory.createEmptyBorder());
			btnPhraseInactive.setContentAreaFilled(false);
			btnPhraseInactive.setBounds(140, 18, 900, 720);
			active.add(btnPhraseInactive);
			
			//Lock Icon
			ImageIcon Lock = new ImageIcon("images/Lock.png");
			JButton btnLock = new JButton(Lock);
			btnLock.setBorder(BorderFactory.createEmptyBorder());
			btnLock.setContentAreaFilled(false);
			btnLock.setBounds(140, 18, 900, 720);
			active.add(btnLock);
	
			//Blue Background
			JButton Background = new JButton(" ");
			Background.setHorizontalAlignment(SwingConstants.LEFT);
			Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
			Background.setOpaque(true);
			Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Background.setBackground(new Color(0, 77, 102));
			Background.setBounds(171, 147, 834, 563);
			active.add(Background);

			ImageIcon background2 = new ImageIcon("images/Background.png");
			JLabel label2 = new JLabel();
			label2.setBounds(140, -360, 1181, 1476);
			label2.setIcon(background2);
		
			JPanel panel2 = new JPanel();
			panel2.setBounds(0, 0, 0, 0);
			panel2.setLayout(null);
			active.add(label2);
		
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
		
		JLabel position = new JLabel("<html><center>Please position your face<br/>in front of the camera.</center></html>");
		position.setForeground(new Color(255, 255, 255));
		position.setFont(new Font("Arial", Font.PLAIN, 36));
		position.setBounds(390, 130, 900, 720);
		facial.add(position);
		
		//Progress Bar
		ImageIcon next3 = new ImageIcon("images/OneFourth.png");
		JButton btnNext3 = new JButton(next3);
		btnNext3.setBorder(BorderFactory.createEmptyBorder());
		btnNext3.setContentAreaFilled(false);
		btnNext3.setBounds(140, 30, 900, 720);
		facial.add(btnNext3);
		
			btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			facial.setVisible(true);
			active.setVisible(false);
		
			
		//Active Power Icon
		ImageIcon PowerActive = new ImageIcon("images/PowerActive.png");
		JButton btnPowerActive = new JButton(PowerActive);
		btnPowerActive.setBorder(BorderFactory.createEmptyBorder());
		btnPowerActive.setContentAreaFilled(false);
		btnPowerActive.setBounds(140, 18, 900, 720);
		facial.add(btnPowerActive);
		
		//Inactive Serious Icon
		ImageIcon SeriousInactive = new ImageIcon("images/SeriousInactive.png");
		JButton btnSeriousInactive = new JButton(SeriousInactive);
		btnSeriousInactive.setBorder(BorderFactory.createEmptyBorder());
		btnSeriousInactive.setContentAreaFilled(false);
		btnSeriousInactive.setBounds(140, 18, 900, 720);
		facial.add(btnSeriousInactive);
		
		//Inactive Phrase Icon
		ImageIcon PhraseInactive = new ImageIcon("images/PhraseInactive.png");
		JButton btnPhraseInactive = new JButton(PhraseInactive);
		btnPhraseInactive.setBorder(BorderFactory.createEmptyBorder());
		btnPhraseInactive.setContentAreaFilled(false);
		btnPhraseInactive.setBounds(140, 18, 900, 720);
		facial.add(btnPhraseInactive);
		
		//Lock Icon
		ImageIcon Lock = new ImageIcon("images/Lock.png");
		JButton btnLock = new JButton(Lock);
		btnLock.setBorder(BorderFactory.createEmptyBorder());
		btnLock.setContentAreaFilled(false);
		btnLock.setBounds(140, 18, 900, 720);
		facial.add(btnLock);

		//Blue Background
		JButton Background = new JButton(" ");
		Background.setHorizontalAlignment(SwingConstants.LEFT);
		Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
		Background.setOpaque(true);
		Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Background.setBackground(new Color(0, 77, 102));
		Background.setBounds(171, 147, 834, 563);
		facial.add(Background);
		
		ImageIcon background3 = new ImageIcon("images/Background.png");
		JLabel label3 = new JLabel();
		label3.setBounds(140, -360, 1181, 1476);
		label3.setIcon(background3);
				
		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 0, 0, 0);
		panel3.setLayout(null);
		facial.add(label3);
		

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
			
				//Progress Bar
				ImageIcon next4 = new ImageIcon("images/HalfBar.png");
				JButton btnNext4 = new JButton(next4);
				btnNext4.setBorder(BorderFactory.createEmptyBorder());
				btnNext4.setContentAreaFilled(false);
				btnNext4.setBounds(140, 30, 900, 720);
				correct.add(btnNext4);
				
					btnNext3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					correct.setVisible(true);
					facial.setVisible(false);	
					
					/**
					//Error Text
					JLabel ErrorFacial = new JLabel("<html><center>Incorrect. Please try again. <br />(Attempt 1 out of 2)</center></html>");
					ErrorFacial.setForeground(new Color(255, 255, 255));
					ErrorFacial.setFont(new Font("Arial", Font.PLAIN, 36));
					ErrorFacial.setBounds(380, 130, 900, 720);
					correct.add(ErrorFacial);
					
					//Error Text
					JLabel ErrorFacial2 = new JLabel("<html><center>Incorrect. Please try again. <br />(Attempt 2 out of 2)</center></html>");
					ErrorFacial2.setForeground(new Color(255, 255, 255));
					ErrorFacial2.setFont(new Font("Arial", Font.PLAIN, 36));
					ErrorFacial2.setBounds(380, 130, 900, 720);
					correct.add(ErrorFacial2);
					
					//Active Error Icon
					ImageIcon ErrorFacial = new ImageIcon("images/ErrorFacial.png");
					JButton btnErrorFacial = new JButton(ErrorFacial);
					btnErrorFacial.setBorder(BorderFactory.createEmptyBorder());
					btnErrorFacial.setContentAreaFilled(false);
					btnErrorFacial.setBounds(140, 18, 900, 720);
					correct.add(btnErrorFacial);
					**/
							
				JLabel position = new JLabel("Correct. Turning on microphone now.");
				position.setForeground(new Color(255, 255, 255));
				position.setFont(new Font("Arial", Font.PLAIN, 36));
				position.setBounds(305, 130, 900, 720);
				correct.add(position);
				
				
				//Active Power Icon
				ImageIcon PowerActive = new ImageIcon("images/PowerActive.png");
				JButton btnPowerActive = new JButton(PowerActive);
				btnPowerActive.setBorder(BorderFactory.createEmptyBorder());
				btnPowerActive.setContentAreaFilled(false);
				btnPowerActive.setBounds(140, 18, 900, 720);
				correct.add(btnPowerActive);
				
				//Active Happy Icon
				ImageIcon HappyActive = new ImageIcon("images/HappyActive.png");
				JButton btnHappyActive = new JButton(HappyActive);
				btnHappyActive.setBorder(BorderFactory.createEmptyBorder());
				btnHappyActive.setContentAreaFilled(false);
				btnHappyActive.setBounds(140, 18, 900, 720);
				correct.add(btnHappyActive);
					
				//Inactive Phrase Icon
				ImageIcon PhraseInactive = new ImageIcon("images/PhraseInactive.png");
				JButton btnPhraseInactive = new JButton(PhraseInactive);
				btnPhraseInactive.setBorder(BorderFactory.createEmptyBorder());
				btnPhraseInactive.setContentAreaFilled(false);
				btnPhraseInactive.setBounds(140, 18, 900, 720);
				correct.add(btnPhraseInactive);
				
				//Lock Icon
				ImageIcon Lock = new ImageIcon("images/Lock.png");
				JButton btnLock = new JButton(Lock);
				btnLock.setBorder(BorderFactory.createEmptyBorder());
				btnLock.setContentAreaFilled(false);
				btnLock.setBounds(140, 18, 900, 720);
				correct.add(btnLock);

				//Blue Background
				JButton Background = new JButton(" ");
				Background.setHorizontalAlignment(SwingConstants.LEFT);
				Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
				Background.setOpaque(true);
				Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				Background.setBackground(new Color(0, 77, 102));
				Background.setBounds(171, 147, 834, 563);
				correct.add(Background);
				
				ImageIcon background4 = new ImageIcon("images/Background.png");
				JLabel label4 = new JLabel();
				label4.setBounds(140, -360, 1181, 1476);
				label4.setIcon(background4);
					
				JPanel panel4 = new JPanel();
				panel4.setBounds(0, 0, 0, 0);
				panel4.setLayout(null);
				correct.add(label4);
					
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
					
			//Progress Bar
			ImageIcon next5 = new ImageIcon("images/HalfBar.png");
			JButton btnNext5 = new JButton(next5);
			btnNext5.setBorder(BorderFactory.createEmptyBorder());
			btnNext5.setContentAreaFilled(false);
			btnNext5.setBounds(140, 30, 900, 720);
			microphone.add(btnNext5);
			
				btnNext4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				microphone.setVisible(true);
				correct.setVisible(false);
			
				/**
				//Error Text
				JLabel ErrorFacial3 = new JLabel("<html><center>Incorrect. Please try again. <br />(Attempt 1 out of 2)</center></html>");
				ErrorFacial3.setForeground(new Color(255, 255, 255));
				ErrorFacial3.setFont(new Font("Arial", Font.PLAIN, 36));
				ErrorFacial3.setBounds(380, 130, 900, 720);
				microphone.add(ErrorFacial3);
				
				//Error Text
				JLabel ErrorFacial4 = new JLabel("<html><center>Incorrect. Please try again. <br />(Attempt 2 out of 2)</center></html>");
				ErrorFacial4.setForeground(new Color(255, 255, 255));
				ErrorFacial4.setFont(new Font("Arial", Font.PLAIN, 36));
				ErrorFacial4.setBounds(380, 130, 900, 720);
				microphone.add(ErrorFacial4);
				
				//Active Error Icon
				ImageIcon ErrorSpeech = new ImageIcon("images/ErrorSpeech.png");
				JButton btnErrorSpeech = new JButton(ErrorSpeech);
				btnErrorSpeech.setBorder(BorderFactory.createEmptyBorder());
				btnErrorSpeech.setContentAreaFilled(false);
				btnErrorSpeech.setBounds(140, 18, 900, 720);
				microphone.add(btnErrorSpeech);
				**/
				
			JLabel position = new JLabel("Please say your pass phrase now.");
			position.setForeground(new Color(255, 255, 255));
			position.setFont(new Font("Arial", Font.PLAIN, 36));
			position.setBounds(315, 130, 900, 720);
			microphone.add(position);
			
			//Active Power Icon
			ImageIcon PowerActive = new ImageIcon("images/PowerActive.png");
			JButton btnPowerActive = new JButton(PowerActive);
			btnPowerActive.setBorder(BorderFactory.createEmptyBorder());
			btnPowerActive.setContentAreaFilled(false);
			btnPowerActive.setBounds(140, 18, 900, 720);
			microphone.add(btnPowerActive);
				
			//Active Happy Icon
			ImageIcon HappyActive = new ImageIcon("images/HappyActive.png");
			JButton btnHappyActive = new JButton(HappyActive);
			btnHappyActive.setBorder(BorderFactory.createEmptyBorder());
			btnHappyActive.setContentAreaFilled(false);
			btnHappyActive.setBounds(140, 18, 900, 720);
			microphone.add(btnHappyActive);
				
			//Active Phrase (Dots) Icon
			ImageIcon SpeechDots = new ImageIcon("images/SpeechDots.png");
			JButton btnSpeechDots = new JButton(SpeechDots);
			btnSpeechDots.setBorder(BorderFactory.createEmptyBorder());
			btnSpeechDots.setContentAreaFilled(false);
			btnSpeechDots.setBounds(140, 18, 900, 720);
			microphone.add(btnSpeechDots);
				
			//Lock Icon
			ImageIcon Lock = new ImageIcon("images/Lock.png");
			JButton btnLock = new JButton(Lock);
			btnLock.setBorder(BorderFactory.createEmptyBorder());
			btnLock.setContentAreaFilled(false);
			btnLock.setBounds(140, 18, 900, 720);
			microphone.add(btnLock);

			//Blue Background
			JButton Background = new JButton(" ");
			Background.setHorizontalAlignment(SwingConstants.LEFT);
			Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
			Background.setOpaque(true);
			Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Background.setBackground(new Color(0, 77, 102));
			Background.setBounds(171, 147, 834, 563);
			microphone.add(Background);
			
			ImageIcon background5 = new ImageIcon("images/Background.png");
			JLabel label5 = new JLabel();
			label5.setBounds(140, -360, 1181, 1476);
			label5.setIcon(background5);
				
			JPanel panel5 = new JPanel();
			panel5.setBounds(0, 0, 0, 0);
			panel5.setLayout(null);
			microphone.add(label5);
				
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
			
			//Progress
			ImageIcon next6 = new ImageIcon("images/ThreeFourth.png");
			JButton btnNext6 = new JButton(next6);
			btnNext6.setBorder(BorderFactory.createEmptyBorder());
			btnNext6.setContentAreaFilled(false);
			btnNext6.setBounds(140, 30, 900, 720);
			correct2.add(btnNext6);
			
				btnNext5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				correct2.setVisible(true);
				microphone.setVisible(false);
			
			JLabel position = new JLabel("Correct. Door is now unlocking.");
			position.setForeground(new Color(255, 255, 255));
			position.setFont(new Font("Arial", Font.PLAIN, 36));
			position.setBounds(335, 130, 900, 720);
			correct2.add(position);
			
			//Active Power Icon
			ImageIcon PowerActive = new ImageIcon("images/PowerActive.png");
			JButton btnPowerActive = new JButton(PowerActive);
			btnPowerActive.setBorder(BorderFactory.createEmptyBorder());
			btnPowerActive.setContentAreaFilled(false);
			btnPowerActive.setBounds(140, 18, 900, 720);
			correct2.add(btnPowerActive);
				
			//Active Happy Icon
			ImageIcon HappyActive = new ImageIcon("images/HappyActive.png");
			JButton btnHappyActive = new JButton(HappyActive);
			btnHappyActive.setBorder(BorderFactory.createEmptyBorder());
			btnHappyActive.setContentAreaFilled(false);
			btnHappyActive.setBounds(140, 18, 900, 720);
			correct2.add(btnHappyActive);
				
			//Active Phrase (Correct) Icon
			ImageIcon SpeechDots = new ImageIcon("images/SpeechActive.png");
			JButton btnSpeechDots = new JButton(SpeechDots);
			btnSpeechDots.setBorder(BorderFactory.createEmptyBorder());
			btnSpeechDots.setContentAreaFilled(false);
			btnSpeechDots.setBounds(140, 18, 900, 720);
			correct2.add(btnSpeechDots);
				
			//Lock Icon
			ImageIcon Lock = new ImageIcon("images/Lock.png");
			JButton btnLock = new JButton(Lock);
			btnLock.setBorder(BorderFactory.createEmptyBorder());
			btnLock.setContentAreaFilled(false);
			btnLock.setBounds(140, 18, 900, 720);
			correct2.add(btnLock);

			//Blue Background
			JButton Background = new JButton(" ");
			Background.setHorizontalAlignment(SwingConstants.LEFT);
			Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
			Background.setOpaque(true);
			Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Background.setBackground(new Color(0, 77, 102));
			Background.setBounds(171, 147, 834, 563);
			correct2.add(Background);
			
			ImageIcon background6 = new ImageIcon("images/Background.png");
			JLabel label6 = new JLabel();
			label6.setBounds(140, -360, 1181, 1476);
			label6.setIcon(background6);
				
			JPanel panel6 = new JPanel();
			panel6.setBounds(0, 0, 0, 0);
			panel6.setLayout(null);
			correct2.add(label6);
				
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
			
			//Progress Bar
			ImageIcon next7 = new ImageIcon("images/FullBar.png");
			JButton btnNext7 = new JButton(next7);
			btnNext7.setBorder(BorderFactory.createEmptyBorder());
			btnNext7.setContentAreaFilled(false);
			btnNext7.setBounds(140, 30, 900, 720);
			unlock.add(btnNext7);
			
				btnNext6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				unlock.setVisible(true);
				correct2.setVisible(false);
			
			JLabel position = new JLabel("Come on in!");
			position.setForeground(new Color(255, 255, 255));
			position.setFont(new Font("Arial", Font.PLAIN, 36));
			position.setBounds(490, 130, 900, 720);
			unlock.add(position);
			
			//Active Power Icon
			ImageIcon PowerActive = new ImageIcon("images/PowerActive.png");
			JButton btnPowerActive = new JButton(PowerActive);
			btnPowerActive.setBorder(BorderFactory.createEmptyBorder());
			btnPowerActive.setContentAreaFilled(false);
			btnPowerActive.setBounds(140, 18, 900, 720);
			unlock.add(btnPowerActive);
				
			//Active Happy Icon
			ImageIcon HappyActive = new ImageIcon("images/HappyActive.png");
			JButton btnHappyActive = new JButton(HappyActive);
			btnHappyActive.setBorder(BorderFactory.createEmptyBorder());
			btnHappyActive.setContentAreaFilled(false);
			btnHappyActive.setBounds(140, 18, 900, 720);
			unlock.add(btnHappyActive);
				
			//Active Phrase (Correct) Icon
			ImageIcon SpeechDots = new ImageIcon("images/SpeechActive.png");
			JButton btnSpeechDots = new JButton(SpeechDots);
			btnSpeechDots.setBorder(BorderFactory.createEmptyBorder());
			btnSpeechDots.setContentAreaFilled(false);
			btnSpeechDots.setBounds(140, 18, 900, 720);
			unlock.add(btnSpeechDots);
				
			//Unlock Icon
			ImageIcon Lock = new ImageIcon("images/Unlock.png");
			JButton btnLock = new JButton(Lock);
			btnLock.setBorder(BorderFactory.createEmptyBorder());
			btnLock.setContentAreaFilled(false);
			btnLock.setBounds(140, 18, 900, 720);
			unlock.add(btnLock);

			//Blue Background
			JButton Background = new JButton(" ");
			Background.setHorizontalAlignment(SwingConstants.LEFT);
			Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
			Background.setOpaque(true);
			Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Background.setBackground(new Color(0, 77, 102));
			Background.setBounds(171, 147, 834, 563);
			unlock.add(Background);
			
			ImageIcon background7 = new ImageIcon("images/Background.png");
			JLabel label7 = new JLabel();
			label7.setBounds(140, -360, 1181, 1476);
			label7.setIcon(background7);
			
			JPanel panel7 = new JPanel();
			panel7.setBounds(0, 0, 0, 0);
			panel7.setLayout(null);
			unlock.add(label7);
				
			}
		});
				

	}
}