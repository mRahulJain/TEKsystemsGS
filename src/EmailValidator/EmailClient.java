package EmailValidator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailClient {

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter your email address: ");
		String email = scn.next();
		
		String regex = "^[a-zA-Z0-9-.+_]+@[a-zA-Z0-9-]+[.][a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			System.out.println("Your email "+email+" is valid");
		} else {
			System.out.println("Your email "+email+" is not valid");
		}
	}

}
