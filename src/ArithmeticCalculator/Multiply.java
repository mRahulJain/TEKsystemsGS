package ArithmeticCalculator;

public class Multiply {

	private double a;
	private double b;
	
	public double multiply(double a, double b) {
		this.a = a;
		this.b = b;
		return performMultiplyInPrivate();
	}
	
	private double performMultiplyInPrivate() {
		return a*b;
	}
	
}
