/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 21. 10. 2014 2014 11:05:17 
 */
@SuppressWarnings("serial")
public class PE1819_BouncingBalls extends JApplet {
	
	JButton jbtSuspend = new JButton("Suspend");
	JButton jbtResume = new JButton("Resume");
	JButton jbtPlusOne = new JButton("+1");
	JButton jbtMinusOne = new JButton("-1");
	
	JScrollBar jscbSpeed = new JScrollBar(JScrollBar.HORIZONTAL);
	L1807_Ball balls = new L1807_Ball();
	
	public PE1819_BouncingBalls() {
		// TODO Auto-generated constructor stub
		// Add buttons to the panel
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtSuspend);
		jpButtons.add(jbtResume);
		jpButtons.add(jbtPlusOne);
		jpButtons.add(jbtMinusOne);
		
		// Add red line border
		LineBorder lineBorder = new LineBorder(Color.RED);
		balls.setBorder(lineBorder);
		
		jscbSpeed.setValue(jscbSpeed.getMaximum());
		
		// Register listeners
		ButtonListener listener = new ButtonListener();
		jbtSuspend.addActionListener(listener);
		jbtResume.addActionListener(listener);
		jbtPlusOne.addActionListener(listener);
		jbtMinusOne.addActionListener(listener);
		
		jscbSpeed.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				balls.setDelay(jscbSpeed.getMaximum() - jscbSpeed.getMinimum() - jscbSpeed.getValue());
			}
		});
					
		add(jscbSpeed, BorderLayout.NORTH);
		add(balls, BorderLayout.CENTER);
		add(jpButtons, BorderLayout.SOUTH);
	}
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbtSuspend)
				balls.suspend();
			if (e.getSource() == jbtResume)
				balls.resume();
			if (e.getSource() == jbtPlusOne)
				balls.addBall();
			if (e.getSource() == jbtMinusOne)
				balls.removeBall();
		}
	}
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		PE1819_BouncingBalls applet = new PE1819_BouncingBalls();
		
		frame.add(applet);
		frame.setTitle("Exercise18_19");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
}
