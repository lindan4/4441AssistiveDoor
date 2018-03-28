package Interface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.bitsinharmony.recognito.FileReadWrite;
import com.bitsinharmony.recognito.JavaSoundRecorder;
import com.bitsinharmony.recognito.MatchResult;
import com.bitsinharmony.recognito.Recognito;
import com.microsoft.cognitive_services.speech_recognition.examples.SimpleExample;

// this class does all of work to get you the information

public class Main {

	final static String PASSPHASE_FILE_NAME = "\\PassPhrase.txt";
	final File ModelRoot = new File("Models\\");
	final File TestRoot = new File("Tests\\");

	final float sampleRate = 16000.0f;

	private long recordingTime = 5000;

	public long getRecordingTime() {
		return recordingTime;
	}

	public void setRecordingTime(long recordingTime) {
		this.recordingTime = recordingTime;
	}

	private String message;

	public Main() {

	}

	// return true if was able to add new model

	public boolean createModel(String name) {
		String filePathString = ModelRoot.getPath() + "/" + name + "/";
		File f = new File(filePathString);
		if (f.isDirectory()) {
			return true;
		}
		if (f.mkdirs()) {
			return true;
		}
		return false;
	}

	// record model and return file path + file name
	public String recordModel(String name) throws ParseException, IOException {
		if (createModel(name)) {
			String filePathString = ModelRoot.getPath() + "/" + name + "/";
			JavaSoundRecorder jsr = new JavaSoundRecorder(filePathString);
			jsr.run(recordingTime);

			speechToText(jsr.getfilePath(), filePathString);

			return jsr.getfilePath();
		}
		return null;
	}

	// get speech text of a given file name
	public String speechToText(String filePathNameToRead) throws ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(SimpleExample.run(filePathNameToRead));
		JSONObject jsonObject = (JSONObject) obj;
		return ((String) jsonObject.get("DisplayText")).trim();
	}

	// reads file and writes it to location specified

	public void speechToText(String filePathNameToRead, String filePathNameToWrite) throws ParseException, IOException {
		String text = speechToText(filePathNameToRead);
		text = text.trim();
		FileReadWrite.write(filePathNameToWrite + PASSPHASE_FILE_NAME, text);
	}

	// get a list of users that have been registered
	public ArrayList<String> getRegisteredUsers() {
		ArrayList<String> users = new ArrayList<String>();
		for (File subF : ModelRoot.listFiles()) {
			if (subF.isDirectory()) {
				users.add(subF.getName());
			}
		}
		return users;
	}

	// gets pass phrase of a specified user
	public String getPassphrase(String name) {
		try {
			return FileReadWrite.read(ModelRoot.getPath() + "\\" + name + "\\" + PASSPHASE_FILE_NAME).trim();
		} catch (IOException e) {
			//System.out.println("Could not read passphrase for " + name);
			return null;
		}
	}

	// gets pass phrase of a specified user
	public Map<String, String> getAllPassphrase() {

		HashMap<String, String> users = new HashMap<String, String>();
		for (File subF : ModelRoot.listFiles()) {
			if (subF.isDirectory()) {
				users.put(subF.getName(), getPassphrase(subF.getName()));
			}
		}
		return users;
	}

	// checks to see if user has higher confidence than specificed
	// high confidence
	public boolean validateUser(String name, int threshhold){

		String currentTestCaseText = null;
		try {
			currentTestCaseText = speechToText(getCurrentTestCaseFile());
		} catch (ParseException e) {
			System.out.println("Speech was not understood");
		}

	//	boolean passphraseExists = getPassphrase(name).equals(currentTestCaseText);

		float high = getConfidence(getCurrentTestCaseFile(), name);

		if (high > threshhold) {
			return true;
		}
		return false;

	}

	private float getConfidence(String currentTestCaseFile, String name)
			{
		Recognito recognito = inprintModel(name);
		//int high = 0;
		
		float above = 0;
		
		

		List<MatchResult<String>> matches = null;
		try {
			matches = recognito.identify(new File(getCurrentTestCaseFile()));
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Something went wrong with recording device");
			
		} catch (IOException e) {
			System.out.println("BIG PROBLEM");
		}

		for (MatchResult<String> match : matches) {
			System.out.println("File : " + match.getKey() + " .... Confidence %: " + match.getLikelihoodRatio());
			
			if(match.getLikelihoodRatio() >= 50) {
				above ++;
			}
		//	if (high < match.getLikelihoodRatio()) {
		//		high = match.getLikelihoodRatio();
			//}

		}
		
		
		
		above  = (above / matches.size())*100;
		
		
		System.out.println(above + " " + matches.size() );
			return above;
		

	}

	// gets the highest confidence compared to all
	public int getHighestConfidenceAll(String currentTestCasePath) throws UnsupportedAudioFileException, IOException {
		Recognito recognito;
		int high = 0;

		int confidenceAvg = 0;
		int confidenceAvgCounter = 0;

		for (String user : getRegisteredUsers()) {
			recognito = inprintModel(user);

			List<MatchResult<String>> matches = recognito.identify(new File(getCurrentTestCaseFile()));

			for (MatchResult<String> match : matches) {
				System.out.println("File : " + match.getKey() + " .... Confidence %: " + match.getLikelihoodRatio());

				// confidenceAvg = confidenceAvg + match.getLikelihoodRatio();
				// confidenceAvgCounter++;

				if (high < match.getLikelihoodRatio()) {
					high = match.getLikelihoodRatio();
				}

			}

		}

		high = confidenceAvg / confidenceAvgCounter;

		return high;
	}

	// record test case and return the current case
	public String recordTestCase() {

		JavaSoundRecorder jsr = new JavaSoundRecorder(TestRoot.getAbsolutePath());
		jsr.run(recordingTime);
		return getCurrentTestCaseFile();
	}

	// returns the latest test recording
	private String getCurrentTestCaseFile() {
		File[] test = TestRoot.listFiles();

		return test[test.length - 1].getAbsolutePath();

	}

	private Recognito inprintModel(String name) {

		File datafolder = new File(ModelRoot.getAbsolutePath() + "\\" + name);

		Recognito reg = new Recognito<>(sampleRate);

		for (File dataSample : datafolder.listFiles()) {

			if (dataSample.isFile() && dataSample.getName().endsWith(".wav")) {
				try {
					// add fingerprint to model
					reg.createVoicePrint(dataSample.getName(), dataSample);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return reg;
	}

	public boolean checkModelSatus(String name) {

		String filePathString = ModelRoot.getPath() + "/" + name + "/";
		File f = new File(filePathString);
		if (!f.isDirectory()) {
			f.mkdirs();
			System.out.println(name
					+ " was not a directory . A new one was created please Use RunThis.java to create new voice models.");

			System.out.println("OR move the exisiting models to : " + f.getAbsolutePath());

			System.out.println("_________________________________");
			return false;
		}

		if (f.list().length < 3) {
			System.out.println(name + " need 3 voice models ");
			return false;
		}
		
		ArrayList<String>  list = new ArrayList<String>();
		Collections.addAll(list, f.list());
		if (!list.contains("PassPhrase.txt")){
			System.out.println(name + " does not have a passphrase");
			 System.out.println(list);
			
		}

		if (!TestRoot.isDirectory()) {
			TestRoot.mkdir();
			System.out.println("Test folder was not found a new one was made at : " + TestRoot.getAbsolutePath());
		}

		return true;

	}

	public boolean checkTestcase() {

		try {
			if (!(new File(getCurrentTestCaseFile())).exists()) {
				System.out.println("testcase was not created");
				return false;
			}

			speechToText(getCurrentTestCaseFile());
		} catch (ParseException e) {
			System.out.println(
					"Speech to text did not understand what was said >> prompt user for repeat and call record test case method again");
			return false;
		}
		return true;
	}

	public boolean validatePassphrase(String name) {
		String path = getCurrentTestCaseFile();
		
		String testMessage = null;
		try {
			testMessage = speechToText(path);
		} catch (ParseException e) {
			return false;
		}
		
		Map<String, String> usersPassPhrase = getAllPassphrase();
		if (usersPassPhrase.get(name).equals(testMessage)) {
			return true;
		}
		
		return false;
		
		
	}

}
