package com.bitsinharmony.recognito;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.microsoft.cognitive_services.speech_recognition.examples.SimpleExample;

public class VOC {

	final static String PASSPHASE_FILE_NAME = "\\PassPhrase.txt";
	private static String message;

	public static void main(String[] args) {
		String name = "";
		String filePathString = "";
		final File ModelRoot = new File("Models\\");
		final File TestRoot = new File("Test\\");
		File f;
		long time = 0;
		

		Recognito<String> recognito = null;
		Scanner scanner = new Scanner(System.in);
		// Initiate
		System.out.println("Would you like to:");
		System.out.println("1 :Create a new voice model?");
		System.out.println("2 :Test confidence of system");

		if (scanner.nextLine().equals("1")) {

			// user wants to add a new voice model

			System.out.println("Enter Your Name");
			name = scanner.nextLine();
			filePathString = ModelRoot.getPath() + "/" + name + "/";
			f = new File(filePathString);

			if (f.isDirectory()) {
				System.out.println("Your Name is recongized... System is adding your current database");
			} else {
				System.out.println("Your Name is not recongized... System is Creating New Profile");
				if (f.mkdirs()) {
					System.out.println("New Profile Created");
				} else {
					System.out.println("Cannot Create new account");
				}
			}

			// record new model in the correct folder based on name

			JavaSoundRecorder jsr = new JavaSoundRecorder(filePathString);
			System.out.println("Enter Length of recording (in milliseconds) ! recording will start immediately after");
			time = scanner.nextLong();
			jsr.run(time);

			// new input will always be the current passphrase
			// translate to text and store with model

			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(SimpleExample.run(jsr.getfilePath()));
				JSONObject jsonObject = (JSONObject) obj;
				message = (String) jsonObject.get("DisplayText");

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// store pass phrase with model as text file

			try {

				FileReadWrite.write(f.getPath() + PASSPHASE_FILE_NAME, message);

			} catch (IOException e) {
				System.out.println("Exception ");

			}

			System.out.println(" New Passphrase >>>>>>>> " + message);

		} else {

			// user wants to check the database confidence level
			// create a new recording in tests
			filePathString = "Tests/";
			JavaSoundRecorder jsr = new JavaSoundRecorder(filePathString);
			System.out.println("Enter Length of recording (in milliseconds) ! recording will start immediately after");
			time = scanner.nextLong();
			jsr.run(time);

			// print what you said
			String testmessage = null;
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(SimpleExample.run(jsr.getfilePath()));
				JSONObject jsonObject = (JSONObject) obj;
				testmessage = (String) jsonObject.get("DisplayText");
				System.out.println("");
				System.out.println("What you said was : " + testmessage);
				System.out.println("");
			} catch (Exception e) {

			}
			// create a model per a directory
			f = ModelRoot;
			File[] database = f.listFiles();

			for (File datafolder : database) {

				if (datafolder.isDirectory()) {
					recognito = new Recognito<>(16000.0f);

					// read passphrase of the current model

					try {
						message = FileReadWrite.read(datafolder.getPath() + PASSPHASE_FILE_NAME);

					} catch (IOException e1) {
						System.out.println(datafolder.getName() + " did not set a Passphrase");
					}

					for (File dataSample : datafolder.listFiles()) {

						if (dataSample.isFile() && dataSample.getName().endsWith(".wav")) {
							try {
								// add fingerprint to model
								recognito.createVoicePrint(dataSample.getName(), dataSample);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					}

					try {
						File[] test = new File("Tests/").listFiles();
						// test last known recording
						List<MatchResult<String>> matches = recognito.identify(test[test.length - 1]);

						int average = 0;
						int high = 0;

						for (MatchResult<String> match : matches) {
							System.out.println(
									"File : " + match.getKey() + " .... Confidence %: " + match.getLikelihoodRatio());
							average += match.getLikelihoodRatio();
							if (high < match.getLikelihoodRatio()) {
								high = match.getLikelihoodRatio();
							}

						}
						boolean result = testmessage.equals(message.trim());
						System.out.println(">>>>>>>> PhaseMatch = '" + result + "' with " + datafolder.getName());

					//	System.out.println(">>>>>>>> PhaseMatch = '" + testmessage +"' '" +message.trim() + "' with " + datafolder.getName());
						System.out
								.println(">>>>>>>> System is " + (average / matches.size()) + "%(average)  Confident this is "
										+ datafolder.getName() + " ... highest Confidence is %: " + high);
						System.out.println("--------------------------------------\n");
					} catch (Exception e) {
						e.printStackTrace();

					}

				}

			}
		}
	}
}
