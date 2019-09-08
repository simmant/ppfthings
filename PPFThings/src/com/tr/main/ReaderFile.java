package com.tr.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class ReaderFile {

	StringBuilder str = null;

	public static void main(String... strings) {

		ReaderFile file = new ReaderFile();
		System.out.println(file.getDateList());
	}

	public String getDateList() {

		ReaderFile readerFile = new ReaderFile();
		str = new StringBuilder();
		String data = readerFile.getData();
		for (String d : data.split("\n")) {
			String[] filterData = d.split(" ");
			str.append(filterData[0] + filterData[1] + filterData[2] + "\n");
		}

		String result = str.toString();
        str = null; 
		
		return result;
	}

	private String getData() {

		String resuilt = "";
		Scanner sc = null;

		try {
			sc = new Scanner(new File("C:\\Users\\ABC\\Documents\\code-base\\PPFThings\\dates.txt"));
			str = new StringBuilder();
			while (sc.hasNext()) {
				str.append(sc.nextLine() + "\n");
			}

			resuilt = str.toString();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {

			str = null;
			sc.close();
		}

		return resuilt;
	}

}
