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
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Cursor;

public class DoorMain {

	private JFrame frame;
	
	
	private JButton progressBarButton;
	private JButton activeIconButton;
	private JButton faceRecogButton;
	private JButton voiceRecogButton;
	private JButton doorLockButton;
	
	private JLabel Prompts;
	
	
	//private Timer t = new Timer();
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoorMain window = new DoorMain();
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
	public DoorMain() throws InterruptedException{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws InterruptedException{
		
		
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
			progressBarButton = new JButton(next);
			progressBarButton.setBorder(BorderFactory.createEmptyBorder());
			progressBarButton.setContentAreaFilled(false);
			progressBarButton.setBounds(140, 30, 900, 720);
			home.add(progressBarButton);
		
			//Inactive Power Icon
			ImageIcon PowerInactive = new ImageIcon("images/PowerInactive.png");
			activeIconButton = new JButton(PowerInactive);
			activeIconButton.setBorder(BorderFactory.createEmptyBorder());
			activeIconButton.setContentAreaFilled(false);
			activeIconButton.setBounds(140, 18, 900, 720);
			home.add(activeIconButton);
			
			//Inactive Serious Icon (Facial recog)
			ImageIcon SeriousInactive = new ImageIcon("images/SeriousInactive.png");
			faceRecogButton = new JButton(SeriousInactive);
			faceRecogButton.setBorder(BorderFactory.createEmptyBorder());
			faceRecogButton.setContentAreaFilled(false);
			faceRecogButton.setBounds(140, 18, 900, 720);
			home.add(faceRecogButton);
			
			//Inactive Serious Icon (Phrase icon)
			ImageIcon PhraseInactive = new ImageIcon("images/PhraseInactive.png");
			voiceRecogButton = new JButton(PhraseInactive);
			voiceRecogButton.setBorder(BorderFactory.createEmptyBorder());
			voiceRecogButton.setContentAreaFilled(false);
			voiceRecogButton.setBounds(140, 18, 900, 720);
			home.add(voiceRecogButton);
			
			//Lock Icon 
			ImageIcon Lock = new ImageIcon("images/Lock.png");
			doorLockButton = new JButton(Lock);
			doorLockButton.setBorder(BorderFactory.createEmptyBorder());
			doorLockButton.setContentAreaFilled(false);
			doorLockButton.setBounds(140, 18, 900, 720);
			home.add(doorLockButton);
	
			Prompts = new JLabel("Why?");
			Prompts.setHorizontalAlignment(SwingConstants.CENTER);
			Prompts.setForeground(new Color(255, 255, 255));
			Prompts.setFont(new Font("Arial", Font.PLAIN, 36));
			Prompts.setBounds(136, 130, 900, 720);
			
			home.add(Prompts);
			
			
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
			
			
			
			
		// Transition from inactive state to active state
			
			Timer tOne = new Timer(5000, new ActionListener() 
			{
				  @Override
				  public void actionPerformed(ActionEvent arg0) 
				  {
				    secondState();
				  }
				}	  
			);
			
			tOne.start();
			
			


	}
	
	private void secondState()
	{
		activeIconButton.setIcon(new ImageIcon("images/PowerActive.png"));
		progressBarButton.setIcon(new ImageIcon("images/OneFourth.png"));
		Prompts.setText("Hello There!");
		
		
		Timer tTwo = new Timer(5000, new ActionListener()
		{
			  @Override
			  public void actionPerformed(ActionEvent arg0) 
			  {
			    thirdState();
			  }
			}	  
		);
		tTwo.start();
	}
	
	private void thirdState()
	{
		Prompts.setText("Please position your face \nin front of the camera.");
		
		
		Timer tThree = new Timer(5000, new ActionListener()
		{
			  @Override
			  public void actionPerformed(ActionEvent arg0) 
			  {
			    fourthState();
			  }
			}	  
		);
		tThree.start();
	}
	
	private void fourthState()
	{
		/*
		 * Three cases:
		 * 
		 * 1. Correct face: move on to state 5
		 * 2. Wrong face: invalid, please try again
		 * 3. System error: output prompt stating error, reset device, try again.
		 */
		
		faceRecogButton.setIcon(new ImageIcon("images/HappyActive.png"));
		Prompts.setText("Correct. Turning on microphone now.");
		progressBarButton.setIcon(new ImageIcon("images/HalfBar.png"));
		
		Timer tFour = new Timer(5000, new ActionListener()
		{
			  @Override
			  public void actionPerformed(ActionEvent arg0) 
			  {
			    fifthState();
			  }
			}	  
		);
		tFour.start();
		
	}
	
	private void fifthState()
	{
		/*
		 * Three cases:
		 * 
		 * 1. Correct phrase and voice: move on to state 5
		 * 2. Wrong phrase and voide: invalid, please try again
		 * 3. System error: output prompt stating error, reset device, try again.
		 */
		
		
		voiceRecogButton.setIcon(new ImageIcon("images/SpeechDots.png"));
		Prompts.setText("Please say pass phrase now.");
		
		Timer tSix = new Timer(5000, new ActionListener()
		{
			  @Override
			  public void actionPerformed(ActionEvent arg0) 
			  {
			    sixthState();
			  }
			}	  
		);
		tSix.start();
		
		
	}
	
	private void sixthState()
	{
		voiceRecogButton.setIcon(new ImageIcon("images/SpeechActive.png"));
		progressBarButton.setIcon(new ImageIcon("images/ThreeFourth.png"));
		Prompts.setText("Correct. Door is now unlocking.");
		
		Timer tSeven = new Timer(5000, new ActionListener()
		{
			  @Override
			  public void actionPerformed(ActionEvent arg0) 
			  {
			    seventhState();
			  }
			}	  
		);
		tSeven.start();
		
	}
	
	private void seventhState()
	{
		doorLockButton.setIcon(new ImageIcon("images/Unlock.png"));
		progressBarButton.setIcon(new ImageIcon("images/FullBar.png"));
		Prompts.setText("Come on in!");
		
	}
	
	
	
	
	
	
	
}