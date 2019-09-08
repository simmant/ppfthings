package com.tr.main;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PPFThings {

	static HashMap<String, String> textMap = new HashMap<>();

	static String key = "";

	static int keyNumber = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter word or para to compare.");
	    String data = sc.nextLine();
		String textData = new ReaderFile().getDateList();
		for (String text : textData.split("\n")) {
			computeHash(hash(text.toUpperCase()));
		}
		computeHashOne(hash(data.toUpperCase()));

		
		System.out.println(textMap.size());
		
		for (Map.Entry<String, String> content : textMap.entrySet()) {

			int result = keyNumber;

			int value = Integer.parseInt(content.getValue());

			if ((value == result - 1) || (value == result) || (value == result + 1)) {

				//System.out.println(content.getKey() + " " + content.getValue());
				dispaly(value,result,content.getKey(),content.getValue());
			}

		}

		sc.close();
	}
	
	
	private static void dispaly(int value,int result, String contentKey, String contentValue) {

		int swVlu  = result - value;
		
		//System.out.println(swVlu);
		
		switch (swVlu) {
		case (-1): {
			System.out.println(contentKey + " is " + " relates to past.");
			break;
		}
		case (0): {
			System.out.println(contentKey + " is " + " relates to present.");
			break;
		}
		case 1: {
			System.out.println(contentKey + " is " + " relates to future.");
			break;
		}
		}

	}
	
	

	static String hash(String h) {

		StringBuilder number = new StringBuilder();

		key = h;

		for (char c : h.toCharArray()) {
			int i = (int) c;
			number.append(i);
		}
		return number.toString();
	}

	static void computeHash(String number) {

		char[] numberChar = number.toCharArray();
		int sum = 0;
		for (char num : numberChar) {
			sum = sum + Character.digit(num, 10);
		}

		String sumStr = new String(Integer.toString(sum));

		if (sumStr.length() != 1) {
			computeHash(sumStr);
		} else {
			textMap.put(key, sumStr);
		}

	}

	
	
	static void computeHashOne(String number) {

		char[] numberChar = number.toCharArray();
		int sum = 0;
		for (char num : numberChar) {
			sum = sum + Character.digit(num, 10);
		}

		String sumStr = new String(Integer.toString(sum));

		if (sumStr.length() != 1) {
			computeHashOne(sumStr);
		} else {
			keyNumber = Integer.parseInt(sumStr);
		}

	}
	
}
