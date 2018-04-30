import java.util.Scanner;
import Interface.*;
import FaceRecognizer.*;

public class MainEverything {
	public static void main(String[] args) {
		
		Scanner choices = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Would you like to:");
			System.out.println("1 :Register as a new user?");
			System.out.println("2 :Use the system to enter a door?");
			System.out.println("3 :De-enroll yourself from the system?");
			
			choice= choices.nextInt();
			if(choice<1 ||choice>3) {
				System.out.println("Invalid choice. Try again\n\n");
			}
		}while(choice<1 || choice>3);
		
		if(choice==1) {
			//System.out.println("First branch");
		}
		else if(choice==2) {
			//System.out.println("Second branch");
		}
		else if(choice==3) {
			//System.out.println("Third branch");
		}
	
	}
}
