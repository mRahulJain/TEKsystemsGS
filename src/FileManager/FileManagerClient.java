package FileManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManagerClient {
	
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws CustomException {
		
		showWelcomePart();
		
		int option1 = 0;
		
		do {
			System.out.println("--------------------------------------");
			System.out.print("Enter your directory path: ");
			String directory = scn.nextLine();
			File mDir = new File(directory);
			
			if(mDir.isDirectory()) {
				System.out.println();
				System.out.println("Directory exists!");
				System.out.println();
				int option2 = 0;
				Helper helper = new Helper();
				
				do {
					System.out.println("----------------MENU------------------");
					System.out.println("1. List all files.");
					System.out.println("2. Perform miscellaneous operations.");
					System.out.println("3. Enter new directory.");
					System.out.println("4. Quit");
					System.out.print("Enter your choice: ");
					option2 = getInput();
					
					if(option2 == 3 || option2 == 4) {
						break;
					}
					
					switch (option2) {
						case 1:
							listAscending(helper, mDir);
							break;
						case 2:
							System.out.println("-------------INNER-MENU---------------");
							System.out.println("1. Add a file.");
							System.out.println("2. Delete a file.");
							System.out.println("3. Search for a file.");
							System.out.println("4. Go back.");
							System.out.print("Enter your choice: ");
							int option3 = getInput();
							
							switch (option3) {
								case 1:
									System.out.print("Enter file name: ");
									String addFileName = scn.nextLine();
									createFile(helper, addFileName, directory);
									break;
								case 2:
									System.out.print("Enter file name: ");
									String deleteFileName = scn.nextLine();
									deleteFile(helper, deleteFileName, directory);
									break;
								case 3:
									System.out.print("Enter file name: ");
									String searchFileName = scn.nextLine();
									searchFile(helper, searchFileName, mDir);
									break;
								case 4:
									break;
								default:
									break;
							}
							break;
						default:
							System.out.println("Pick correct option!");
								break;
					}
				} while(true);
				
				if(option2 == 3) {
					option1 = 1;
				} else if(option2 == 4) {
					option1 = 2;
				}
			} else {
				System.out.println();
				System.out.println("Directory does not exist");
				System.out.println();
				System.out.println("----------------MENU------------------");
				System.out.println("1. Re-enter directory path.");
				System.out.println("2. Quit.");
				System.out.print("Enter your choice: ");
				option1 = getInput();
			}
		} while(option1 == 1);
	
		System.out.println("bye!");
	}

	private static int getInput() throws CustomException {
		String string = scn.nextLine();
		if(!(string.charAt(0) >= '0' && string.charAt(0) <= '9')) {
			throw new CustomException("You didn't enter a valid number!");
		}
		return Integer.parseInt(string);
	}
	
	private static void listAscending(Helper helper, File mDir) throws CustomException {
		try {
			helper.getListOfFiles(mDir);
		} catch (Exception e) {
			throw new CustomException("Some exception occured: "+ e.getLocalizedMessage());
		}
	}
	
	private static void createFile(Helper helper, String fileName, String directory) throws CustomException {
		try {
			File mDir = new File(directory+"/"+fileName);
			helper.createFile(mDir);
		} catch (Exception e) {
			throw new CustomException("Some exception occured: "+ e.getLocalizedMessage());
		}
	}
	
	private static void deleteFile(Helper helper, String fileName, String directory) throws CustomException {
		try {
			File mDir = new File(directory+"/"+fileName);
			helper.deleteFile(mDir);
		} catch (Exception e) {
			throw new CustomException("Some exception occured: "+ e.getLocalizedMessage());
		}
	}
	
	private static void searchFile(Helper helper, String fileName, File mDir) throws CustomException {
		try {
			helper.searchFile(fileName, mDir);
		} catch(Exception e) {
			throw new CustomException("Some exception occured: "+ e.getLocalizedMessage());
		}
	}
	
	private static void showWelcomePart() {
		System.out.println("--------------------------------------");
		System.out.println("        Welcome to File Manager       ");
		System.out.println("  App developed by Lockers Pvt. Ltd.  ");
	}

}
