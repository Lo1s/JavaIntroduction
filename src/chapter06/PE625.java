/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE625 {

	/**
	 * 
	 */
	public PE625() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    double[] eqn = new double[3];
	    hdR.mtd.createArray(eqn);   
	    
	    double[] roots = new double[2];
	    roots[0] = (-(eqn[1]) + Math.pow((Math.pow(eqn[1], 2) - 4 * (eqn[0] * eqn[2])), 0.5)) / (2 * eqn[0]);
	    roots[1] = (-(eqn[1]) - Math.pow((Math.pow(eqn[1], 2) - 4 * (eqn[0] * eqn[2])), 0.5)) / (2 * eqn[0]);

	  
		System.out.println("The equation has: " + solveQuadratic(eqn, roots) + " root(s)");
	    
	}
	public static int solveQuadratic(double[] eqn, double[] roots) {

	    double discriminant = Math.pow(eqn[1], 2) - 4 * (eqn[0] * eqn[2]);
	    if (discriminant > 0)
	    	return 2;
	    else if (discriminant < 0)
	    	return 0;
	    else
	    	return 1;
	}

}
