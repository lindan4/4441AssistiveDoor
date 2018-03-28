import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public final class LinkerMethods {

	private LinkerMethods() {}
	
	/**
	 * Detects a face for 10 seconds and tries to recognize the face based on the training file.
	 * @return an ArrayList of strings with 3 elements. First depicts a boolean (whether a face was found or not, true if found).
	 * Second depicts the name of the individual's name. If this returns Unknown, this means that no match was found by the algorithm.
	 * Third depicts the ID associated with the person, which is stored in a database. A 0 means that no matching person was found by the algorithm.
	 * (false, error, -1) means that the script threw an exception.
	 */
	public static ArrayList<String> callDetector(){
		ArrayList<String> returnVals= new ArrayList<String>();
		try {
			Process p =Runtime.getRuntime().exec("cmd /c ../FaceRecognition/detector.py"); //Need to install python in the directory of the program
			//Input stream from the executable
			InputStream is = p.getInputStream();
			
			//Read the input stream
			int i=0;
			StringBuffer sb = new StringBuffer();
			while((i=is.read())!=-1) {
				sb.append((char)i);
			}
			
			System.out.println(sb.toString());
			
			
			Scanner scan= new Scanner(sb.toString());
			//scan.nextLine();
			String oneLine =scan.nextLine();
			
			//System.out.println(oneLine);
			
			StringTokenizer tokenize = new StringTokenizer(oneLine,",");
			
			while (tokenize.hasMoreTokens()) {
				returnVals.add(tokenize.nextToken());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnVals.clear();
			returnVals.add("false");
			returnVals.add("error");
			returnVals.add("-1");
			
		}
		return returnVals;
	}
	
	/**
	 * Allows the user to register their face into the program. Takes a 100 pictures and trains the algorithm to recognize the person's face.
	 * @return true if enrolled successfully, false otherwise.
	 */
	
	public static boolean callDataSetGeneration() {
		Process p;
		boolean retVal=false;
		try {
			p = Runtime.getRuntime().exec("C:\\\\Python27\\\\python.exe datasetCreator.py"); //need to fix this absolute path
			
			InputStream is = p.getInputStream();
			
			//Read the input stream
			int i=0;
			StringBuffer sb = new StringBuffer();
			while((i=is.read())!=-1) {
				sb.append((char)i);
			}
			
			//System.out.println(sb.toString());
			
			Scanner scan= new Scanner(sb.toString());
			scan.nextLine();
			scan.nextLine();
			String oneLine = scan.nextLine();
			
			//System.out.println(oneLine);
			
			retVal = Boolean.parseBoolean(oneLine);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			retVal=false;
		} //Need to install python in the directory of the program
		return retVal;
	}
	
	/**
	 * Allows the person to delete their own information from the whole system
	 * @return -1 if the person doesn't exist in the system, 1 if the delete was successful
	 * 0 if the authorized user decides not to delete their information, and -2 if an exceotion is thrown.
	 */
	public static int callDataDelete(){
		int i;
		try {
			Process p =Runtime.getRuntime().exec("C:\\\\Python27\\\\python.exe dataDeleteMechanism.py"); //Need to install python in the directory of the program
			//Input stream from the executable
			InputStream is = p.getInputStream();
			
			//Read the input stream
			//int i=0;
			StringBuffer sb = new StringBuffer();
			while((i=is.read())!=-1) {
				sb.append((char)i);
			}
			
			//System.out.println(sb.toString());
			
			Scanner scan= new Scanner(sb.toString());
			//scan.nextLine();
			String oneLine =scan.nextLine();
			i= Integer.parseInt(oneLine);
			//System.out.println(oneLine);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			i=-12;
		}
		return i;
	}
	
}
