package com.bitsinharmony.recognito;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.microsoft.cognitive_services.speech_recognition.examples.SimpleExample;

import Interface.Main;

public class RUNTHIS {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Main voc = new Main();

		// Initiate

		System.out.println("Would you like to:");
		System.out.println("1 :Create a new voice model?");
		System.out.println("2 :Test confidence of system");

		if (scanner.nextLine().equals("1")) {
			System.out.println("Enter Your Name");
			String name = scanner.nextLine();

			if (voc.createModel(name)) {
				System.out.println("Profile Created/Found");
			} else {
				System.out.println("Cannot Create/Find account");
			}

			System.out.println("Enter Length of recording (in milliseconds) ! recording will start immediately after");

			long time = scanner.nextLong();
			voc.setRecordingTime(time);
			try {
				voc.recordModel(name);
				System.out.println("Passphase Updates with new recording: " + voc.getPassphrase(name));
			} catch (Exception e) {

			}

		} else {
			String testMessage = null;
			// user wants to check the database confidence level

			System.out.println("Enter Length of recording (in milliseconds) ! recording will start immediately after");
			long time = scanner.nextLong();
			voc.setRecordingTime(time);

			// file path to latest test
			String path = voc.recordTestCase();
			// get what was said in the latest case
			try {
				testMessage = voc.speechToText(path);
				System.out.println(">>>>>>>>> You Said : " + testMessage);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Map<String, String> usersPassPhrase = voc.getAllPassphrase();
			// ArrayList<String> users = voc.getRegisteredUsers();
			System.out.println("Who are you trying to validate?");
			
			String name = scanner.nextLine();
			
			// weird null error work around
			do {
				System.out.println("Who are you trying to validate?");
				name = scanner.nextLine();
			}while( name == null );

			// check to see if passphrase matches the user
			if (!usersPassPhrase.containsKey(name)) {
				System.out.println(">>>>>>>>>>>>> User Does Not exist");
			} else {
				System.out.println(">>>>>>>>>>>>> Users exists");
				if (usersPassPhrase.get(name).equals(testMessage)) {
					System.out.println(">>>>>>>>>>>>> PassPhrase Match");
					
				}else {
					System.out.println(">>>>>>>>>>>>> PassPhrase Does not match");
					/*System.out.println(testMessage);
					try {
						System.out.println(voc.getPassphrase(name).toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/
				}

				// 50% is a good value you can set to some other value
				int threshhold = 50;

				try {
					// uses latest test case
					if (voc.validateUser(name, threshhold)) {
						System.out.println("System is confident that User sounds like Model DataBase");
					} else {
						System.out.println("System is  not confident that User sounds like Model DataBase");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
}
