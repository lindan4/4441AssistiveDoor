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
//		
		//boolean test = LinkerMethods.callDataSetGeneration();
		//System.out.println(test);
		
		
		ArrayList<String> returnVals= new ArrayList<String>();
		try {
			Process p =Runtime.getRuntime().exec("cmd /c detector.py"); //Need to install python in the directory of the program
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
		//return returnVals;
		
		//int i=LinkerMethods.callDataDelete();
		//System.out.println(i);
	}
}
