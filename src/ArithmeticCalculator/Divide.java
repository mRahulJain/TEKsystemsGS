package ArithmeticCalculator;

public class Divide {
	
	private double a;
	private double b;
	
	public double divide(double a, double b) {
		this.a = a;
		this.b = b;
		return performDivideInPrivate();
	}
	
	private double performDivideInPrivate() {
		return a/b;
	}

}
