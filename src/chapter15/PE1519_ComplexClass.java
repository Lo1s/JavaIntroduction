/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 11:28:15 
 */
public class PE1519_ComplexClass {
	
	double a;
	double b;
	double i = Math.sqrt((-1));
	double abs;
	StringBuilder log = new StringBuilder();
	
	double resultA;
	double resultB;
	
	public PE1519_ComplexClass() {
		// TODO Auto-generated constructor stub
		this.a = 0;
		this.b = 0;
	}
	
	public PE1519_ComplexClass(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public PE1519_ComplexClass(double a) {
		this.a = a;
		this.b = 0;
	}
	
	
	public PE1519_ComplexClass add(PE1519_ComplexClass c) {
		this.resultA = (this.a + c.a);
		this.resultB = (this.b + c.b);
		log.append("(" + this.a + " + " + this.b + "i) + " + "(" + c.a + " + " + c.b + "i) = "
				+ resultA + " + " + resultB + "i\n");
		return new PE1519_ComplexClass(resultA, resultB);
	}
	
	public PE1519_ComplexClass subtract(PE1519_ComplexClass c) {
		this.resultA = (this.a - c.a);
		this.resultB = (this.b - c.b);
		log.append("(" + this.a + " + " + this.b + "i) - " + "(" + c.a + " + " + c.b + "i) = "
				+ resultA + " + " + resultB + "i\n");
		return new PE1519_ComplexClass(resultA, resultB);
	}
		
	public PE1519_ComplexClass multiply(PE1519_ComplexClass c) {
		this.resultA = (this.a * c.a - this.b * c.b);
		this.resultB = (this.b * c.a + this.a * c.b);
		log.append("(" + this.a + " * " + this.b + "i) - " + "(" + c.a + " + " + c.b + "i) = "
				+ resultA + " + " + resultB + "i\n");
		return new PE1519_ComplexClass(resultA, resultB);
	}
	
	public PE1519_ComplexClass divide(PE1519_ComplexClass c) {
		this.resultA = (this.a * c.a + this.b * c.b) / (Math.pow(c.a, 2) + Math.pow(c.b, 2));
		this.resultB = (this.b * c.a - this.a * c.b) / (Math.pow(c.a, 2) + Math.pow(c.b, 2));
		log.append("(" + this.a + " * " + this.b + "i) / " + "(" + c.a + " + " + c.b + "i) = "
				+ resultA + " + " + resultB + "i\n");
		return new PE1519_ComplexClass(resultA, resultB);
	}

	public double abs() {
		abs = Math.sqrt((Math.pow(this.a, 2) + Math.pow(this.b, 2)));
		log.append("|(" + this.a + " * " + this.b + "i)| = "
				+ abs + "\n");
		return abs;
	}
	
	public double[] getRealPart() {
		double[] realPart = new double[2];
		return realPart;
	}
	
	public double getImaginatyPart() {
		return this.i;
	}
}
