package Interface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
	
	

	private long recordingTime;
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
			
			speechToText(jsr.getfilePath(),filePathString);
			
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
	public String getPassphrase(String name) throws IOException {
		return FileReadWrite.read(ModelRoot.getPath() + "\\" + name + "\\" + PASSPHASE_FILE_NAME).trim();
	}

	// gets pass phrase of a specified user
	public Map<String, String> getAllPassphrase() {

		HashMap<String, String> users = new HashMap<String, String>();
		for (File subF : ModelRoot.listFiles()) {
			if (subF.isDirectory()) {

				try {
					users.put(subF.getName(), getPassphrase(subF.getName().trim()));
				} catch (IOException e) {
					users.put(subF.getName(), null);
				}
			}
		}
		return users;
	}

	// checks to see if user has higher confidence than specificed
	// high confidence
	public boolean validateUser(String name, int threshhold)
			throws ParseException, UnsupportedAudioFileException, IOException {

		String currentTestCaseText = speechToText(getCurrentTestCaseFile());

		boolean passphraseExists = getPassphrase(name).equals(currentTestCaseText);

		int high = getConfidence(getCurrentTestCaseFile(), name);

		if (high < threshhold ) {
			return true;
		}
		return false;

	}

	// get highest confidence that this is correct user
	private int getConfidence(String currentTestCaseFile, String name)
			throws UnsupportedAudioFileException, IOException {
		Recognito recognito = inprintModel(name);
		int high = 0;
		
		int avg = 0;
		int avgCount = 0;

		List<MatchResult<String>> matches = recognito.identify(new File(getCurrentTestCaseFile()));

		for (MatchResult<String> match : matches) {
			System.out.println("File : " + match.getKey() + " .... Confidence %: " + match.getLikelihoodRatio());
			
			avg = avg + match.getLikelihoodRatio();
			avgCount++;
			
			/*
			if (high < match.getLikelihoodRatio()) {
				high = match.getLikelihoodRatio();
			}
			*/

		}
		
		high = avg / avgCount;
		
		System.out.println("Confidence average is: " + high);
		
		return high;

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

				//confidenceAvg = confidenceAvg + match.getLikelihoodRatio();
				//confidenceAvgCounter++;
				
				
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

}
