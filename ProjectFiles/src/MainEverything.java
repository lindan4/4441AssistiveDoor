import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import Interface.*;
import FaceRecognizer.*;

public class MainEverything {
	public static void main(String[] args) {
		
		Scanner choices = new Scanner(System.in);
		ArrayList<String> id;
		Main voc = new Main();
		int choice;
		do {
			System.out.println("Would you like to:");
			System.out.println("1 :Register as a new user?");
			System.out.println("2 :Use the system to enter a door?");
			System.out.println("3 :De-enroll yourself from the system?\n");
			System.out.print(">>> ");
			choice= choices.nextInt();
			if(choice<1 ||choice>3) {
				System.out.println("Invalid choice. Try again\n\n");
			}
		}while(choice<1 || choice>3);
		
		if(choice==1) {
			//System.out.println("First branch");
			
			//Facial Recognition
			//Gets the id for the username.
			id=LinkerMethods.callDataSetGeneration();
			String username=id.get(0)+"."+id.get(1);
			
			System.out.println("\nFacial recognition is all set up!\n");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//voice recognition
			voc.createModel(username);
			System.out.println("Now working on the Voice Recognition\n");
			System.out.println("This process will repeat 3 times. Say the same passphrase\nEach recording session lasts 5 seconds\n");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			voc.setRecordingTime(5000);
			for(int i=0;i<3;i++) {
				try {
					System.out.println("\n"+(i+1)+" of 3");
					voc.recordModel(username);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Voice recognition was successful.\n\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\nRegistration was successful, "+id.get(0));
		}
		else if(choice==2) {
			//System.out.println("Second branch");
			File f= new File("recognizer" + File.separator+"traningData.yml");
			if(f.exists()) {
				DoorMain.nunMe();
			}else {
				System.out.println("\nThis feature is unavailable because no user is registered");
			}
		}
		else if(choice==3) {
			//System.out.println("Third branch");
			File f= new File("recognizer" + File.separator+"traningData.yml");
			if(f.exists()) {
				id=LinkerMethods.callDataDelete();
				String sentinel=id.get(0);
				if(sentinel.equals("True")) {
					System.out.println("\nFace Data for user "+id.get(1)+" deleted successfully.");
					String username=id.get(1)+"."+id.get(2);
					voc.deleteModel(new File("Models"+File.separator+username));
					System.out.println("Voice files for "+id.get(1)+" deleted successfully.\n\n"
							+ "The user was de-enrolled from the system successfully");
				}
				else {
					System.out.println("\nNo changes were made to the user files");
				}
			}
			else {
				System.out.println("This feature is unavailable because no users exist.");
			}
		}
	
	}
}
