/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 15. 10. 2014 2014 14:55:42 
 */
@SuppressWarnings("serial")
public class PE1816_StockSticker extends JApplet {

	private String[] indexNames = new String[7];
	private String[] indexTimes = new String[7];
	private double[] indexPrevs = new double[7];
	private double[] indexChngs = new double[7];
	private ArrayList<Color> colors = new ArrayList<Color>();
	private Image stockTicker2;
	private Image stockTicker3;
	private ImageIcon icon1 = new ImageIcon("C:/Java/Java Introduction/bin/chapter18/image/stockTicker2.jpeg");
	private ImageIcon icon2 = new ImageIcon("C:/Java/Java Introduction/bin/chapter18/image/stockTicker3.jpg");
	private StockTicker stockTicker = new StockTicker();

	public PE1816_StockSticker() {
		// TODO Auto-generated constructor stub
		try {
		stockTicker2 = getImage(new URL("C:/Java/Java Introduction/bin/chapter18/image/stockTicker2.jpeg"));
		stockTicker3 = getImage(new URL("C:/Java/Java Introduction/bin/chapter18/image/stockTicker3.jpg"));
		}
		catch (MalformedURLException ex) {
			System.out.println("File not found !");
		}
		JLabel jlbl1 = new JLabel(icon2);
		JLabel jlbl2 = new JLabel(icon1);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel.add(jlbl1);
		panel.add(jlbl2);
		
		// Register listeners
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					stockTicker.timer.stop();
			}
			
			@Override 
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					stockTicker.timer.start();
			}
		});
		
		add(panel, BorderLayout.NORTH);
		add(stockTicker, BorderLayout.CENTER);
	}

	@Override
	public void init() {
		setSize(800, 260);
		setVisible(true);
		

		for (int i = 0; i < 7; i++) {
			indexNames[i] = getParameter("IndexName" + (i + 1));
			indexTimes[i] = getParameter("IndexTime" + (i + 1));
			indexPrevs[i] = Double.parseDouble(getParameter("IndexPrev" + (i + 1)));
			indexChngs[i] = Double.parseDouble(getParameter("IndexChng" + (i + 1)));
			if (indexChngs[i] < 0)
				colors.add(Color.RED);
			else
				colors.add(Color.GREEN);
		}
	}

	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	class HeaderImages extends JPanel {
		
		protected void paintComponent(Graphics g) {

			
			g.drawImage(stockTicker3, 0, 0, 354, 200, this);
			g.drawImage(stockTicker2, 355, 0, 357, 200, this);
		}
	}
	
	class StockTicker extends JPanel {

		private	int startingPoint = getWidth();
		private int move = 0;
		private Timer timer;
		private int[] arrowPointsX = new int[7];
		private int[] arrowPointsY = new int[7];

		public StockTicker() {
			// TODO Auto-generated constructor stub
			setSize(711, 200);
			setBackground(Color.BLACK);
			timer = new Timer(10, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					move -= 1;
					repaint();
				}
			});
			timer.start();
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			// Stock Name, Time, Value & Change
			Font font = new Font("Helvetica", Font.BOLD, 14);
			FontMetrics fm = getFontMetrics(font);
			g.setFont(font);
			System.out.println(startingPoint + "");
			for (int i = 0; i < indexNames.length; i++) {
				String nameTime = indexNames[i] + " " + indexTimes[i];
				String valueChange = indexPrevs[i] + " " + indexChngs[i];
				g.setColor(colors.get(i));
				g.drawString(nameTime, startingPoint, getHeight() / 2);
				g.drawString(valueChange, startingPoint, getHeight() / 2 + 15);
				int firstLineWidth = fm.stringWidth(nameTime);
				int secondLineWidth = fm.stringWidth(valueChange);
				startingPoint += 5 + (firstLineWidth > secondLineWidth ?
						firstLineWidth : secondLineWidth);
				arrowPointsX[i] = startingPoint + secondLineWidth + 2;
				arrowPointsY[i] = getHeight() / 2 + 15;
			}
			
			startingPoint = getWidth() + move;
			if (startingPoint < -640) {
				startingPoint = getWidth();
				move = 0;
			}
		}
	}

}
