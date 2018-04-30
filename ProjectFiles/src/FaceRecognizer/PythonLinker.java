package FaceRecognizer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PythonLinker {

	public static void main(String[] args) {
		
//		for(String s:LinkerMethods.callDetector()) {
//			System.out.print(s+" ");
//		}
		ArrayList<String> returnVals= new ArrayList<String>();
		try {
			Process p =Runtime.getRuntime().exec("cmd /c datasetCreator.py"); //Need to install python in the directory of the program
			//Input stream from the executable
			InputStream is = p.getInputStream();
			
			//Read the input stream
			int i=0;
			StringBuffer sb = new StringBuffer();
			while((i=is.read())!=-1) {
				sb.append((char)i);
			}
			
			//System.out.println(sb.toString());
			
			Scanner scan= new Scanner(sb.toString());
			//scan.nextLine();
			String oneLine =scan.nextLine();
			
			//System.out.println(oneLine);
			StringTokenizer tokenize = new StringTokenizer(oneLine,",");
			
			while (tokenize.hasMoreTokens()) {
				returnVals.add(tokenize.nextToken());
			}
			scan.close();
			
			for(String s:returnVals) {
				System.out.print(s+" ");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
