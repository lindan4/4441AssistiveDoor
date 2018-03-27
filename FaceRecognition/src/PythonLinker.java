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
		
		int i=LinkerMethods.callDataDelete();
		System.out.println(i);
	}
}
