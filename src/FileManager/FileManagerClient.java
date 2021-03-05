package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManagerClient {
	
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		
		showWelcomePart();
		
		int outerOptionSelected = 1;
		
		do {
			System.out.println("--------------------------------------");
			System.out.print("Enter your directory path: ");
			String directory = scn.nextLine();
			File mDir = new File(directory);
			if(mDir.exists()) {
				
				System.out.println();
				System.out.println("Directory does exist");
				int innerOptionSelected = 0;
				Helper helper = new Helper();
				
				do {
					System.out.println("----------MENU----------");
					System.out.println("1. List all files.");
					System.out.println("2. Perform miscellaneous operations.");
					System.out.println("3. Enter new directory.");
					System.out.println("4. Quit");
					System.out.print("Enter your choice: ");
					innerOptionSelected = Integer.parseInt(scn.nextLine());
					
					if(innerOptionSelected == 3 || innerOptionSelected == 4) {
						break;
					}
					
					switch (innerOptionSelected) {
						case 1:
							listAlphabetically(helper, mDir);
							break;
						case 2:
							System.out.println("-------INNER-MENU-------");
							System.out.println("1. Add a file.");
							System.out.println("2. Delete a file.");
							System.out.println("3. Search for a file.");
							System.out.println("4. Go back.");
							System.out.print("Enter your choice: ");
							break;
						default:
							System.out.println("Pick correct option!");
								break;
					}
				} while(true);
				
				if(innerOptionSelected == 3) {
					outerOptionSelected = 1;
				} else if(innerOptionSelected == 4) {
					outerOptionSelected = 2;
				}
				
			} else {
				
				System.out.println();
				System.out.println("Directory does not exist");
				System.out.println("----------MENU----------");
				System.out.println("1. Re-enter directory path.");
				System.out.println("2. Quit.");
				System.out.print("Enter your choice: ");
				outerOptionSelected = Integer.parseInt(scn.nextLine());
			
			}
		} while(outerOptionSelected == 1);
	
		System.out.println("bye!");
	}

	
	private static void listAlphabetically(Helper helper, File mDir) {
		try {
			helper.getListOfFiles(mDir);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: "+e.getLocalizedMessage());
		}
	}
	
	private static void showWelcomePart() {
		System.out.println("--------------------------------------");
		System.out.println("|       Welcome to File Manager      |");
		System.out.println("|     App developed by Rahul Jain    |");
	}

}
