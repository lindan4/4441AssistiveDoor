package com.bitsinharmony.recognito;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

	public static void write(String fileName, String message) throws IOException {

		// BufferedWriter out = new BufferedWriter(new
		// FileWriter(f.getPath()+"PassPhrase.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		out.write(message);
		out.close();
	}

	public static String read(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		StringBuilder stringBuilder = new StringBuilder();
		char[] buffer = new char[10];
		while (reader.read(buffer) != -1) {
			stringBuilder.append(new String(buffer));
			buffer = new char[10];
		}
		reader.close();
		return stringBuilder.toString();
	}

}
