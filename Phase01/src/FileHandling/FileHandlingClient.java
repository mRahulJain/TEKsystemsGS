package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingClient {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter file path: ");
		String path = scn.nextLine();
		
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("File does not exist!");
			return;
		}

		System.out.println("-------MENU-------");
		System.out.println("1. READ");
		System.out.println("2. WRITE");
		System.out.println("3. APPEND");
		System.out.print("Enter your choice: ");
		int choice = Integer.parseInt(scn.nextLine());
		
		switch (choice) {
			case 1:
				readFile(file);
				break;
			case 2:
				System.out.println("Enter your text: ");
				String writeText = scn.nextLine();
				writeFile(file, writeText);
				break;
			case 3:
				System.out.println("Enter your text: ");
				String appendText = scn.nextLine();
				appendFile(file, appendText);
				break;
			default:
				break;
		}
		
		
	}
	
	private static void readFile(File file) {
		System.out.println();
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNext()) {
				String data = reader.nextLine();
				System.out.println(data);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception: "+e.getLocalizedMessage());
		}
	}

	private static void writeFile(File file, String text) {
		System.out.println();
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			writer.close();
			System.out.println("File written successful");
		} catch (IOException e) {
			System.out.println("File not found exception: "+e.getLocalizedMessage());
		}
	}
	
	private static void appendFile(File file, String text) {
		System.out.println();
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(text);
			writer.close();
			System.out.println("File append successful");
		} catch (IOException e) {
			System.out.println("File not found exception: "+e.getLocalizedMessage());
		}
	}
}
