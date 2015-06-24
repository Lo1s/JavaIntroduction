/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import java.awt.event.*;

/**
 * @author jslapnicka
 * @Date & @Time 25. 9. 2014 2014 12:27:49 
 */
@SuppressWarnings("serial")
public class PE1703_TrafficLights extends JFrame {

	/**
	 * @param args
	 */
	
	// Create radio buttons for lights
	private JRadioButton jrbRed = new JRadioButton("Red");
	private JRadioButton jrbYellow = new JRadioButton("Yellow");
	private JRadioButton jrbGreen = new JRadioButton("Green");
	private JRadioButton jrbAuto = new JRadioButton("Auto");
	
	// Create a Traffic lights panel
	TrafficLights lights = new TrafficLights();
	
	// Create a Timer for automatic mode
	Timer timer = new Timer(500, new TimerListener());
	
	public PE1703_TrafficLights() {
		// TODO Auto-generated constructor stub
		// Create a panel for the radio buttons
		JPanel jpRadioButtons = new JPanel(new FlowLayout());
		jpRadioButtons.add(jrbRed);
		jpRadioButtons.add(jrbYellow);
		jpRadioButtons.add(jrbGreen);
		jpRadioButtons.add(jrbAuto);
		
		// Create a group for the buttons
		ButtonGroup group = new ButtonGroup();
		group.add(jrbRed);
		group.add(jrbYellow);
		group.add(jrbGreen);
		
		// Set border for the panel
		LineBorder lineBoarder = new LineBorder(Color.BLACK);
		jpRadioButtons.setBorder(lineBoarder);
		lights.setBorder(lineBoarder);
		
		// Register listeners
		jrbRed.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				timer.stop();
				lights.setColor(TrafficLights.RED);
				repaint();
			}
		});
		jrbYellow.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				timer.stop();
				lights.setColor(TrafficLights.YELLOW);
				repaint();
			}
		});
		jrbGreen.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				timer.stop();
				lights.setColor(TrafficLights.GREEN);
				repaint();
			}
		});
		jrbAuto.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				timer.start();
			}
		});
		
		
		// Add panels to the frame
		add(lights, BorderLayout.CENTER);
		add(jpRadioButtons, BorderLayout.SOUTH);
	
	}
	
	class TimerListener implements ActionListener {
		int color = 1;
		@Override
		public void actionPerformed(ActionEvent e) {
			lights.setColor(color);
			repaint();
			color++;
			if (color > 3)
				color = 0;
		}
	}
	
	class TrafficLights extends JPanel {
		
		private boolean isFilled;
		public static final int RED = 1;
		public static final int YELLOW = 2;
		public static final int GREEN = 3;
		private int color;
		
		public TrafficLights() {
			// TODO Auto-generated constructor stub
		}
		
		public boolean isFilled() {
			return isFilled;
		}
		
		public void setFilled(boolean filled) {
			this.isFilled = filled;
		}
		
		public void setColor(int newColor) {
			this.color = newColor;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;
			
			super.paintComponent(g);
			
			// Draw body
			int width = 20;
			int height = 60;
			g.drawRect(xCenter - width / 2, yCenter - height / 2, width, height);
			
			// Draw lights
			int radius = 8;
			g.setColor(Color.BLACK);
			for (int i = 0; i <= 38; i += 19) {
				g.drawOval(xCenter - width / 2 + 2, yCenter - height / 2 + 2 + i, 2 * radius, 2 * radius);
			}
			
			
			/** Light'em up ! */
			switch (color) {
			case 1: g.setColor(Color.RED); 
					g.fillOval(xCenter - width / 2 + 2, yCenter - height / 2 + 2 + 0, 2 * radius, 2 * radius);
					break;
			case 2: g.setColor(Color.YELLOW);
					g.fillOval(xCenter - width / 2 + 2, yCenter - height / 2 + 2 + 19, 2 * radius, 2 * radius);
					break;
			case 3: g.setColor(Color.GREEN);
					g.fillOval(xCenter - width / 2 + 2, yCenter - height / 2 + 2 + 2 * 19, 2 * radius, 2 * radius); 
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1703_TrafficLights frame = new PE1703_TrafficLights();
		frame.setTitle("Exercise17_03");
		frame.setSize(280, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
