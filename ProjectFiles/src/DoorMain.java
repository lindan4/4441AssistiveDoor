import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import FaceRecognizer.LinkerMethods;
import Interface.Main;

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
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
	
	private Timer tOne;
	
	private Timer tTwo;
	
	private Timer tThree;
	private Timer tThreeA;
	private Timer tThreeB;
	private Timer tThreeC;
	
	private Timer tThreeAllAttempts;
	
	
	private Timer tFour;
	
	private Timer tFive;
	private Timer tFiveA;
	private Timer tFiveB;
	private Timer tFiveC;
	
	private Timer tFiveAllAttempts;
	
	private Timer tSix;
	private Timer tSixA;
	private Timer tSixB;
	
	private Timer tSeven;
	
	private Timer toExit;
	
	
	private ArrayList<String> faceValidator;
	private String faceName;
	
	private int faceRecogAttempts = 4;
	private int voiceRecogAttempts = 4;
	
	private int voiceRecogCountdown = 5;
	private Timer voiceRecogTimer;
	private TimerTask tT;
	
	//private Timer t = new Timer();
	
	private SwingWorker<Integer, Integer> swT;
 
	/**
	 * Launch the application.
	 */
	public static void nunMe() 
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
		frame.setBounds(0, 0, 480, 320); //Screen Resolution
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().setBounds(0, 0, 480, 320); //Screen Resolution
		
		//Full-screen mode
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		
		
		
		
		
		
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
			progressBarButton.setBounds(0, 0, 480, 320);
			home.add(progressBarButton);
		
			//Inactive Power Icon
			ImageIcon PowerInactive = new ImageIcon("images/PowerInactive.png");
			activeIconButton = new JButton(PowerInactive);
			activeIconButton.setBorder(BorderFactory.createEmptyBorder());
			activeIconButton.setContentAreaFilled(false);
			activeIconButton.setBounds(0, 0, 480, 320);
			home.add(activeIconButton);
			
			//Inactive Serious Icon (Facial recog)
			ImageIcon SeriousInactive = new ImageIcon("images/SeriousInactive.png");
			faceRecogButton = new JButton(SeriousInactive);
			faceRecogButton.setBorder(BorderFactory.createEmptyBorder());
			faceRecogButton.setContentAreaFilled(false);
			faceRecogButton.setBounds(0, 0, 480, 320);
			home.add(faceRecogButton);
			
			//Inactive Serious Icon (Phrase icon)
			ImageIcon PhraseInactive = new ImageIcon("images/PhraseInactive.png");
			voiceRecogButton = new JButton(PhraseInactive);
			voiceRecogButton.setBorder(BorderFactory.createEmptyBorder());
			voiceRecogButton.setContentAreaFilled(false);
			voiceRecogButton.setBounds(0, 0, 480, 320);
			home.add(voiceRecogButton);
			
			//Lock Icon 
			ImageIcon Lock = new ImageIcon("images/Lock.png");
			doorLockButton = new JButton(Lock);
			doorLockButton.setBorder(BorderFactory.createEmptyBorder());
			doorLockButton.setContentAreaFilled(false);
			doorLockButton.setBounds(0, 0, 480, 320);
			home.add(doorLockButton);
	
			Prompts = new JLabel("", SwingConstants.CENTER);
			Prompts.setHorizontalAlignment(SwingConstants.CENTER);
			Prompts.setForeground(new Color(255, 255, 255));
			Prompts.setFont(new Font("Arial", Font.PLAIN, 16));
			Prompts.setBounds(0, 55, 480, 320);
			
			home.add(Prompts);
			
			
			//Blue Background
			JButton Background = new JButton(" ");
			Background.setHorizontalAlignment(SwingConstants.LEFT);
			Background.setBorder(new LineBorder(new Color(0, 77, 102), 3));
			Background.setOpaque(true);
			Background.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			Background.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Background.setBackground(new Color(0, 77, 102));
			Background.setBounds(0, 0, 480, 320);
			home.add(Background);
		
			/*
			ImageIcon background = new ImageIcon("images/Background.png");
			JLabel label1 = new JLabel();
			label1.setBounds(140, -360, 1181, 1476);
			label1.setIcon(background);
			
			JPanel panel1 = new JPanel();
			panel1.setBounds(0, 0, 0, 0);
			panel1.setLayout(null);
			home.add(label1);
			*/
			
			frame.pack();
			
			
		// Transition from inactive state to active state
			
			tOne = new Timer(5000, new ActionListener() 
			{
				  @Override
				  public void actionPerformed(ActionEvent arg0) 
				  {
				    secondState();
				    tOne.stop();
				  }
				}	  
			);
			
			tOne.start();
			
			


	}
	
	private void secondState()
	{
		activeIconButton.setIcon(new ImageIcon("images/PowerActive.png"));
		faceRecogButton.setIcon(new ImageIcon("images/HappyInactive.png"));
		voiceRecogButton.setIcon(new ImageIcon("images/PhraseInactive.png"));
		doorLockButton.setIcon(new ImageIcon("images/Lock.png"));
		progressBarButton.setIcon(new ImageIcon("images/OneFourth.png"));
		
		Prompts.setText("Hello There!");
		
		
		tTwo = new Timer(5000, new ActionListener()
		{
			  @Override
			  public void actionPerformed(ActionEvent arg0) 
			  {
			    thirdState();
			    tTwo.stop();
			  }
			}	  
		);
		tTwo.start();
	}
	
	private void thirdState()
	{
		if (faceRecogAttempts != 0)
		{
			activeIconButton.setIcon(new ImageIcon("images/PowerActive.png"));
			faceRecogButton.setIcon(new ImageIcon("images/SeriousInactive.png"));
			voiceRecogButton.setIcon(new ImageIcon("images/PhraseInactive.png"));
			doorLockButton.setIcon(new ImageIcon("images/Lock.png"));
			progressBarButton.setIcon(new ImageIcon("images/OneFourth.png"));
			
			Prompts.setText("Please position your face \nin front of the camera.");
			
			
			//
			
			
			tThree = new Timer(1, new ActionListener()
			{
				  @Override
				  public void actionPerformed(ActionEvent arg0) 
				  {
				  	faceValidator = LinkerMethods.callDetector();
				  	
				  	String pseudoBoolean = faceValidator.get(0);
				  	String identifiedName = faceValidator.get(1);
				  	int personID = Integer.parseInt(faceValidator.get(2));
				  	
				  		if (pseudoBoolean.equals("True") &&  !identifiedName.equals("Unknown"))
					  	{
					  		activeIconButton.setIcon(new ImageIcon("images/PowerActive.png"));
					  		faceRecogButton.setIcon(new ImageIcon("images/HappyActive.png"));
					  		progressBarButton.setIcon(new ImageIcon("images/HalfBar.png"));
							voiceRecogButton.setIcon(new ImageIcon("images/PhraseInactive.png"));
					  		doorLockButton.setIcon(new ImageIcon("images/Lock.png"));
					  		
					  		
					  		Prompts.setText("Face verified. Turning on microphone now.");
					  		
					  		faceRecogAttempts = 4;
					  		
					  		faceName = faceValidator.get(1)+"."+faceValidator.get(2);
					  		
					  		tThreeA = new Timer(3000, new ActionListener()
					  		{
					  			@Override
					  			public void actionPerformed(ActionEvent arg0) 
					  			{
					  				fifthState(faceName);
					  				tThreeA.stop();
					  			}
					  		}	  
					  		);
					  		tThreeA.start();
					  		
					  	}
					  	else if (pseudoBoolean.equals("False") && identifiedName.equals("Unknown"))
					  	{
					  		faceRecogAttempts--;
					  		faceRecogButton.setIcon(new ImageIcon("images/ErrorFacial.png"));
					  		
					  		Prompts.setText((faceRecogAttempts != 0) ? "<html><center>Invalid person. Please try again.<br /> (" + faceRecogAttempts + " attempt(s) remaining)</center></html>" : "<html><center>Invalid person.</center></html>");
					  		progressBarButton.setIcon(new ImageIcon("images/OneFourth.png"));
					  		
					  		
					  		
					  		tThreeB = new Timer(1500, new ActionListener()
					  		{
					  			@Override
					  			public void actionPerformed(ActionEvent arg0) 
					  			{
					  				thirdState();
					  				tThreeB.stop();
					  			}
					  		}	  
					  		);
					  		tThreeB.start();
					  	}
					  	else
					  	{
					  		faceRecogButton.setIcon(new ImageIcon("images/ErrorFacial.png"));
					  		Prompts.setText("There was a system error. Rebooting camera.");
					  		progressBarButton.setIcon(new ImageIcon("images/OneFourth.png"));
					  		
					  		tThreeC = new Timer(1500, new ActionListener()
					  		{
					  			@Override
					  			public void actionPerformed(ActionEvent arg0) 
					  			{
					  				thirdState();
					  				tThreeC.stop();
					  			}
					  		}	  
					  		);
					  		tThreeC.start();
					  	}
				  	
				  	
				  	
				  	
				    //fourthState();
				  	//System.out.println(faceValidator.toString());
				    tThree.stop();
				  }
				}	  
			);
			tThree.start();
			
		}
		else
	  	{
	  		Prompts.setText("<html><center>All attempts used. Please wait 1 minute <br /> before trying again.</center></html>");
	  		
	  		activeIconButton.setIcon(new ImageIcon("images/PowerInactive.png"));
	  		faceRecogButton.setIcon(new ImageIcon("images/HappyInactive.png"));
	  		progressBarButton.setIcon(new ImageIcon("images/EmptyBar.png"));
			voiceRecogButton.setIcon(new ImageIcon("images/PhraseInactive.png"));
	  		doorLockButton.setIcon(new ImageIcon("images/Lock.png"));
	  		
	  		tThreeAllAttempts = new Timer(60000, new ActionListener()
	  		{
	  			@Override
	  			public void actionPerformed(ActionEvent arg0) 
	  			{
	  				faceRecogAttempts = 4;
	  				tThreeAllAttempts.stop();
	  				secondState();
	  				
	  			}
	  		}	  
	  		);
	  		tThreeAllAttempts.start();

	  	}
		
		
		
		
	}
	
	
	//the name is collected from Saads code so the voice can know which model it is trying to authenticate
	private void fifthState(final String name_temp)
	{
		
		
		if (voiceRecogAttempts != 0)
		{
			voiceRecogButton.setIcon(new ImageIcon("images/SpeechDots.png"));
			Prompts.setText("Please say your pass phrase (" + voiceRecogCountdown + " seconds remaining).");
			final String name = name_temp;
			 
			
			
			
			tFive = new Timer(180, new ActionListener()
			{
				  @Override
				  public void actionPerformed(ActionEvent arg0) 
				  {
				    //sixthState();
					  Main voc = new Main();
					  
					  String recPath = "";

						
						// WATCH console for fixing bugs 
						
						
					// checks to see if enough models and the file path exists
					if(voc.checkModelSatus(name)) 
					{ //CASE 3
							
						// add some delay if you want
						
						
						
						/*
						swT = new SwingWorker<Integer, Integer>()
						{

							@Override
							protected Integer doInBackground() throws Exception 
							{
										// TODO Auto-generated method stub
								
								
									voiceRecogTimer = new Timer(1000, new ActionListener()
									{

											@Override
											public void actionPerformed(ActionEvent arg0) 
											{
												// TODO Auto-generated method stub
												Prompts.setText("" + --voiceRecogCountdown);
												
												if (voiceRecogCountdown == 0)
												{
													voiceRecogTimer.stop();
												}
											}
										
									});
									
									voiceRecogTimer.setRepeats(true);
									voiceRecogTimer.start();
									
								
								
								return null;
							}							
							
						};
						
						swT.execute();
						*/
						
						
						
						
						
						recPath = voc.recordTestCase();
						
						//voiceRecogCountdown = 5;
						
			//			Prompts.setText("Done recording passphrase.");
						
					}
							
					boolean HAS_VOICE_PASSED_TEST = false;
						
					// WATCH console for fixing bugs if any
					// test to make sure the speech was heard by azure 
					if(voc.checkTestcase()) 
					{  //CASE 3
							
							// this does the validation  CASE 1 = true  CASE 2 = false
							HAS_VOICE_PASSED_TEST = voc.validatePassphrase(name, recPath);
									//&& voc.validateUser(name, 50);
							//System.out.println(HAS_VOICE_PASSED_TEST);
					}
					else 
					{
						voiceRecogButton.setIcon(new ImageIcon("images/ErrorSpeech.png"));
				  		Prompts.setText("There was a system error. Restarting voice module.");
				  		progressBarButton.setIcon(new ImageIcon("images/HalfBar.png"));
				  		
						//System error. Please try again
						tFiveA = new Timer(5000, new ActionListener()
				  		{
				  			@Override
				  			public void actionPerformed(ActionEvent arg0) 
				  			{
				  				fifthState(name_temp);
				  				tFiveA.stop();
				  			}
				  		}	  
				  		);
						tFiveA.start();
						
					}
					
					// Voice passed
					if (HAS_VOICE_PASSED_TEST)
					{
						voiceRecogButton.setIcon(new ImageIcon("images/SpeechActive.png"));
						progressBarButton.setIcon(new ImageIcon("images/ThreeFourth.png"));
						Prompts.setText("Correct. Door is now unlocking.");
						
						tFiveB = new Timer(5000, new ActionListener()
				  		{
				  			@Override
				  			public void actionPerformed(ActionEvent arg0) 
				  			{
				  				seventhState();
				  				tFiveB.stop();
				  			}
				  		}	  
				  		);
						
						tFiveB.start();
						
						

					}
					else
					{
						voiceRecogAttempts--;
						
						voiceRecogButton.setIcon(new ImageIcon("images/ErrorSpeech.png"));
				  		Prompts.setText((voiceRecogAttempts != 0) ? "<html><center>Invalid passphrase. Please try again.<br /> (" + voiceRecogAttempts + " attempt(s) remaining)</center></html>" : "Invalid passphrase.");
				  		progressBarButton.setIcon(new ImageIcon("images/HalfBar.png"));
					
				  		tFiveC = new Timer(5000, new ActionListener()
				  		{
				  			@Override
				  			public void actionPerformed(ActionEvent arg0) 
				  			{
				  				fifthState(name_temp);
				  				tFiveC.stop();
				  			}
				  		}	  
				  		);
				  		
				  		tFiveC.start();
				  		
					}
					  
				    tFive.stop();
				    
				  }
				}	  
			);
			tFive.start();
		}
		else
		{
			Prompts.setText("<html><center>All attempts used. Please wait 1 minute <br /> before trying again.</center></html>");
	  		
	  		activeIconButton.setIcon(new ImageIcon("images/PowerInactive.png"));
	  		faceRecogButton.setIcon(new ImageIcon("images/HappyInactive.png"));
	  		progressBarButton.setIcon(new ImageIcon("images/EmptyBar.png"));
			voiceRecogButton.setIcon(new ImageIcon("images/PhraseInactive.png"));
	  		doorLockButton.setIcon(new ImageIcon("images/Lock.png"));
	  		
	  		tFiveAllAttempts = new Timer(60000, new ActionListener()
	  		{
	  			@Override
	  			public void actionPerformed(ActionEvent arg0) 
	  			{
	  				voiceRecogAttempts = 4;
	  				tFiveAllAttempts.stop();
	  				secondState();
	  				
	  			}
	  		}	  
	  		);
	  		tFiveAllAttempts.start();
		}
		
		
		
		
		
		
		
		
		// you can test this same code without the gui in RunnTHis.java   --->   test fifth case
		

		
		
		
		
		/*
		 * Three cases:
		 * 
		 * 1. Correct phrase and voice: move on to state 5
		 * 2. Wrong phrase and voide: invalid, please try again
		 * 3. System error: output prompt stating error, reset device, try again.
		 */
		
		
		
		
		
		
	}
	
	private void sixthState()
	{
		voiceRecogButton.setIcon(new ImageIcon("images/SpeechActive.png"));
		progressBarButton.setIcon(new ImageIcon("images/ThreeFourth.png"));
		Prompts.setText("Correct. Door is now unlocking.");
		
		
		
		tSix = new Timer(5000, new ActionListener()
		{
			  @Override
			  public void actionPerformed(ActionEvent arg0) 
			  {
			    seventhState();
			    tSix.stop();
			  }
			}	  
		);
		tSix.start();
		
	}
	
	private void seventhState()
	{
		doorLockButton.setIcon(new ImageIcon("images/Unlock.png"));
		progressBarButton.setIcon(new ImageIcon("images/FullBar.png"));
		Prompts.setText("Come on in, "+faceValidator.get(1)+"!");
		
		
		toExit = new Timer(5000, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				toExit.stop();
			}
			
		});
		
		toExit.start();
	}
	
	
	
	
	
	
}