package ArithmeticCalculator;

public class Subtract {
	
	private double a;
	private double b;
	
	public double subtract(double a, double b) {
		this.a = a;
		this.b = b;
		return performSubtractInPrivate();
	}
	
	private double performSubtractInPrivate() {
		return a-b;
	}

}
