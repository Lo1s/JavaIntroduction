/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author jslapnicka
 * @Date & @Time 6. 10. 2014 2014 14:32:43 
 */
@SuppressWarnings("serial")
public class L1808_BallControl extends JPanel {

	private L1807_Ball ball = new L1807_Ball();
	private JButton jbtResume = new JButton("Resume");
	private JButton jbtSuspend = new JButton("Suspend");
	private JScrollBar jsbDelay = new JScrollBar(JScrollBar.HORIZONTAL);
	
	public L1808_BallControl() {
		// TODO Auto-generated constructor stub
		// Group buttons in a panel
		ball.addBall();
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);
		
		// Add ball and the buttons to the panel
		ball.setBorder(new LineBorder(Color.RED));
		ball.setDelay(jsbDelay.getMaximum());
		
		setLayout(new BorderLayout());
		add(jsbDelay, BorderLayout.NORTH);
		add(ball, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		// Register listeners
		jbtSuspend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.suspend();
			}
		});
		jbtResume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.resume();
			}
		});
		jsbDelay.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				ball.setDelay(jsbDelay.getMaximum() - jsbDelay.getValue());
			}
		});
	}
}
