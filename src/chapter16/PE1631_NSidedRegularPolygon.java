/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 17. 9. 2014 2014 15:02:19 
 */
@SuppressWarnings("serial")
public class PE1631_NSidedRegularPolygon extends JFrame {

	int numberOfSides = 6;
	JButton jbtPlus1 = new JButton("+1");
	JButton jbtMinus1 = new JButton("-1");
	RegularPolygon p = new RegularPolygon(numberOfSides);
	
	public PE1631_NSidedRegularPolygon() {
		// TODO Auto-generated constructor stub
		add(p);
		JPanel panel = new JPanel();
		panel.add(jbtPlus1);
		panel.add(jbtMinus1);
		add(panel, BorderLayout.SOUTH);
		
		jbtPlus1.addActionListener(new EnlargeListener());
		jbtMinus1.addActionListener(new ShrinkListener());
		
	}
	
	class EnlargeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			p.addSide();
		}
	}
	
	class ShrinkListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			p.removeSide();
		}
	}
	
	class RegularPolygon extends JPanel {
		private int numberOfSides;

		public RegularPolygon() {

		}

		public RegularPolygon(int numberOfSides) {
			this.numberOfSides = numberOfSides;
			
		}

		public void setNumberOfSides(int numberOfSides) {
			this.numberOfSides = numberOfSides;
		}
		
		public void addSide() {
			numberOfSides++;
			repaint();
		}
		
		public void removeSide() {
			numberOfSides--;
			repaint();
		}


		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			Polygon p = new Polygon();

			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;
			int radius = (int)(Math.min(getWidth(), getHeight() * 0.4));

			for (int i = 1; i <= numberOfSides; i++) {
				p.addPoint((int)(xCenter + radius * Math.cos(i * 2 * Math.PI / numberOfSides)), 
						(int)(yCenter - radius * Math.sin(i * 2 * Math.PI / numberOfSides)));
			}
			g.drawPolygon(p);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1631_NSidedRegularPolygon();
		frame.setTitle("Exercise16_31");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
