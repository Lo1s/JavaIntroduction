/**
 * 
 */
package chapter15;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 10:18:34 
 */
public class PE1501_Functions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public PE1501_Functions() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1, 3));
		add(new drawFunctionA());
		add(new drawFunctionB());
		add(new drawFunctionC());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1501_Functions();
		frame.setTitle("Exercise15_01");
		frame.setSize(700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

@SuppressWarnings("serial")
class drawFunctionA extends PE1501_AbstractDrawFunction {
	
	@Override
	public double f(double x) {
		double scaleFactor = 0.01D;
        return scaleFactor * x * x;
	}
}

@SuppressWarnings("serial")
class drawFunctionB extends PE1501_AbstractDrawFunction {
	
	@Override
	public double f(double x) {
		return 50D * Math.sin((x / 100D) * 2D * Math.PI);
	}
}

@SuppressWarnings("serial")
class drawFunctionC extends PE1501_AbstractDrawFunction {
	
	@Override
	public double f(double x) {
		return 50D * Math.cos((x / 100D) * 2D * Math.PI);
	}
}
