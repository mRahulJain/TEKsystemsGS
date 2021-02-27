package ArithmeticCalculator;
import java.util.Scanner;

public class ArithmeticCalculatorClient {

	public static void main(String[] args) {
		startCalculator();
	}
	
	private static void startCalculator() {
		Scanner scn = new Scanner(System.in);
		double a = 0.0;
		double b = 0.0;
		char ch;
		do {
			System.out.println("----------------------------------------------------------");
			System.out.print("Enter two numbers: ");
			a = scn.nextDouble();
			b = scn.nextDouble();
			System.out.print("Mention your operation (+ or - or * or /): ");
			ch = scn.next().charAt(0);
			switch(ch) {
				case '+':
					Add add = new Add();
					System.out.println("The result is: "+ add.add(a, b));
					break;
				case '-':
					Subtract subtract = new Subtract();
					System.out.println("The result is: "+ subtract.subtract(a, b));
					break;
				case '*':
					Multiply multiply = new Multiply();
					System.out.println("The result is: "+ multiply.multiply(a, b));
					break;
				case '/':
					Divide divide = new Divide();
					System.out.println("The result is: "+ divide.divide(a, b));
					break;
				default:
					System.out.println("Please mention from (+ or - or * or /) operators only.");
					break;
			}
			System.out.println();
			do {
				System.out.println("Do you wish to continue? y/n");
				ch = scn.next().charAt(0);
			} while(ch != 'y' && ch != 'n');
		} while(ch == 'y');
		System.out.println();
		System.out.println("Arithmetic Calculator Stopped");
	}

}
