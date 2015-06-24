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
 * @Date & @Time 8. 9. 2014 2014 16:16:27 
 */
@SuppressWarnings("serial")
public class PE1521_JuliaSet extends JFrame {

	public PE1521_JuliaSet(){
		add(new JuliaCanvas());
	}

	public static void main(String[] args) {
		JFrame frame = new PE1521_JuliaSet();
		frame.setTitle("Exercise15_21");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class JuliaCanvas extends JPanel {
	JuliaCanvas() {

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(double x = -1.5D; x < 1.5D; x += 0.0050000000000000001D) {
			for(double y = -1.5D; y < 1.5D; y += 0.0050000000000000001D) {
				int times = count(x, y);
				if(count(x, y) == 50) {
					g.setColor(Color.BLACK);
				} else {
					int c = 50 - times;
					g.setColor(new Color((c * 14) % 256, (c * 6) % 256, (c * 13) % 256));
				}
				g.drawRect((int)(x * 100D) + 150, (int)(y * 100D) + 150, 1, 1);
			}

		}

	}

	static int count(double x, double y) {
		PE1519_ComplexClass c = new PE1519_ComplexClass(0.20000000000000001D, -0.59999999999999998D);
		PE1519_ComplexClass z = new PE1519_ComplexClass(x, y);
		for(int i = 0; i < 50; i++) {
			z = z.multiply(z).add(c);
			if(z.abs() > 2D) {
				return i;
			}
		}

		return 50;
	}
}