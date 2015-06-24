/**
 * 
 */
package chapter18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 24. 10. 2014 2014 14:59:36 
 */
@SuppressWarnings("serial")
public class PE1827_Graphs extends JApplet {

	private DrawGraphs graphs = new DrawGraphs();

	public PE1827_Graphs() {
		// TODO Auto-generated constructor stub
		graphs.setBorder(new LineBorder(Color.BLACK));
		// Add items to the frame
		setLayout(new GridLayout(1, 2, 2, 2));
		add(new DrawInstructions());
		add(graphs);
	}
	
	@Override
	public void init() {
		setSize(600, 200);
	}

	class DrawInstructions extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawRect(20, 20, 200, 120);
			g.drawString("INSTRUCTIONS", 30, 40);
			g.drawString("Add:", 30, 60);
			g.drawString("Move:", 30, 80);
			g.drawString("Connect:", 30, 100);
			g.drawString("Remove:", 30, 120);

			g.drawString("Left Click", 100, 60);
			g.drawString("Ctrl Drag", 100, 80);
			g.drawString("Drag", 100, 100);
			g.drawString("Right Click", 100, 120);
		}
	}

	class DrawGraphs extends JPanel {
		private int radius = 20;
		private int mouseX;
		private int mouseY;
		private int tempIndex = 0;
		private ArrayList<Point> circles = new ArrayList<Point>();
		private ArrayList<Point> lines = new ArrayList<Point>();
		private ArrayList<int[]> connected = new ArrayList<int[]>();
		private boolean dragWithin = false;
		private int startPoint = -1;
		private int endPoint = -1;

		public DrawGraphs() {
			// TODO Auto-generated constructor stub
			addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1 && !e.isControlDown()) {
						mouseX = e.getX();
						mouseY = e.getY();
						if (!isInside(mouseX, mouseY)) {
							circles.add(new Point(mouseX, mouseY));
							lines.add(new Point(-1, -1));
							repaint();
						}
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						mouseX = e.getX();
						mouseY = e.getY();
						if (circles.size() > 0) {
							for (int i = 0; i < circles.size(); i++) {
								if (isSelected(i, mouseX, mouseY)) {
									circles.remove(i);
									repaint();
									break;
								}
							}
						}
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					if (startPoint > -1 && endPoint > -1)
						connected.add(new int[] {startPoint, endPoint});
					tempIndex = -1;
					dragWithin = false;
					startPoint = -1;
					endPoint = -1;
					repaint();
				}
			});
			addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {

					for (int i = 0; i < circles.size(); i++) {
						if (isSelected(i, e.getX(), e.getY())) {
							tempIndex = i;
							dragWithin = true;
							break;
						} else {
							tempIndex = -1;
							dragWithin = false;
						}
					}
					if (e.isControlDown()) {
						if (tempIndex != -1) {
							dragWithin = false;
							circles.set(tempIndex, new Point(e.getX(), e.getY()));
							lines.set(tempIndex, new Point(e.getX(), e.getY()));
							repaint();
						}
					} else {
						mouseX = e.getX();
						mouseY = e.getY();
						if (tempIndex != - 1) {
							if (dragWithin && startPoint == -1)
								startPoint = tempIndex;
							else if (dragWithin && startPoint > -1)
								endPoint = tempIndex;
						}
						repaint();					
					}
				}

			});

		}

		public void setLines() {

		}

		public boolean isInside(int x, int y) {
			if (circles.size() > 0) {
				for (int i = 0; i < circles.size(); i++) {
					if ((x + radius > (int)circles.get(i).getX() - radius && x - radius < (int)circles.get(i).getX() + radius
							&& y + radius > (int)circles.get(i).getY() - radius && y - radius < (int)circles.get(i).getY() + radius))
						return true;
				}
			}
			return false;
		}


		public boolean isSelected(int index, int x, int y) {
			if (circles.size() > 0) {
				if ((x > (int)circles.get(index).getX() - radius && x < (int)circles.get(index).getX() + radius
						&& y > (int)circles.get(index).getY() - radius && y < (int)circles.get(index).getY() + radius))
					return true;
			}
			return false;
		}



		@Override
		public void paintComponent(Graphics g) {


			super.paintComponent(g);

			// Draw oval
			System.out.println(startPoint);
			g.setColor(Color.BLACK);
			if (circles.size() > 0)
				for (int i = 0; i < circles.size(); i++) {
					g.fillOval((int)circles.get(i).getX() - radius, (int)circles.get(i).getY() - radius, 2 * radius, 2 * radius);
				}
			if (connected.size() > 0)
				for (int i = 0; i < connected.size(); i++) {
					g.drawLine((int)circles.get(connected.get(i)[0]).getX(), (int)circles.get(connected.get(i)[0]).getY(), 
							(int)circles.get(connected.get(i)[1]).getX(), (int)circles.get(connected.get(i)[1]).getY());
				}
			if (startPoint > -1)
				g.drawLine((int)circles.get(startPoint).getX(), (int)circles.get(startPoint).getY(), mouseX, mouseY);
			
			/** if (lines.size() > 0)
				for (int i = 0; i + 1 < lines.size(); i++) {
					if (lines.get(i).getX() != -1)
						g.drawLine((int)circles.get(i).getX(), (int)circles.get(i).getY(), 
								(int)lines.get(i).getX(), (int)lines.get(i).getY());					
				} */
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1827_Graphs applet = new PE1827_Graphs();

		frame.add(applet);
		frame.setTitle("Exercise18_27");
		frame.setSize(600, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
