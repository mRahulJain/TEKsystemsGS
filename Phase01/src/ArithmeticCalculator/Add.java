package ArithmeticCalculator;

public class Add {
	
	private double a;
	private double b;
	
	public double add(double a, double b) {
		this.a = a;
		this.b = b;
		return performAddInPrivate();
	}
	
	private double performAddInPrivate() {
		return a+b;
	}

}
