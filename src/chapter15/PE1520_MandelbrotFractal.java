/**
 * 
 */
package chapter15;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 14:08:08 
 */
@SuppressWarnings("serial")
public class PE1520_MandelbrotFractal extends JFrame {
	
	public PE1520_MandelbrotFractal() {

		add(new MandelbrotCanvas());
	}
	
	public static void main(String[] args) {
		JFrame frame = new PE1520_MandelbrotFractal();
		frame.setTitle("Exercise15_20");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public class MandelbrotCanvas extends JPanel {

		static final int COUNT_LIMIT = 60;
		private int red = 77;
		private int green = 58;
		private int blue = 159;

		public MandelbrotCanvas() {

		}
		
		public MandelbrotCanvas(int red, int green, int blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
		
		public void setRedColor(int newRed) {
			this.red = newRed;
		}
		
		public void setGreenColor(int newGreen) {
			this.green = newGreen;
		}
		
		public void setBlueColor(int newBlue) {
			this.blue = newBlue;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(double x = -2D; x < 2D; x += 0.01D) {
				for(double y = -2D; y < 2D; y += 0.01D) {
					int c = count(new PE1519_ComplexClass(x, y));
					if(c == 60) {
						g.setColor(Color.BLACK);
					} else {
						g.setColor(new Color((c * red) % 256, (c * green) % 256, (c * blue) % 256));
					}
					g.drawRect((int)(x * 100D) + 200, (int)(y * 100D) + 200, 1, 1);
				}

			}

		}

		public int count(PE1519_ComplexClass c) {
			PE1519_ComplexClass z = new PE1519_ComplexClass(0.0D, 0.0D);
			for(int i = 0; i < 60; i++) {
				z = z.multiply(z).add(c);
				if(z.abs() > 2D) {
					return i;
				}
			}

			return 60;
		}
	}
}

