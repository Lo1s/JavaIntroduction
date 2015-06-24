/**
 * 
 */
package chapter18;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import chapter16.PE1615_RacingCar;

/**
 * @author jslapnicka
 * @Date & @Time 17. 10. 2014 2014 8:01:41 
 */
@SuppressWarnings("serial")
public class PE1817_RacingCars extends JApplet {

	PE1615_RacingCar.RacingCar car1 = new PE1615_RacingCar().new RacingCar();
	PE1615_RacingCar.RacingCar car2 = new PE1615_RacingCar().new RacingCar();
	PE1615_RacingCar.RacingCar car3 = new PE1615_RacingCar().new RacingCar();
	PE1615_RacingCar.RacingCar car4 = new PE1615_RacingCar().new RacingCar();
	
	
	JLabel jlblCar1 = new JLabel("Car 1:");
	JLabel jlblCar2 = new JLabel("Car 2:");
	JLabel jlblCar3 = new JLabel("Car 3:");
	JLabel jlblCar4 = new JLabel("Car 4:");
	
	JTextField jtfCar1 = new JTextField(5);
	JTextField jtfCar2 = new JTextField(5);
	JTextField jtfCar3 = new JTextField(5);
	JTextField jtfCar4 = new JTextField(5);
	
	public PE1817_RacingCars() {
		// TODO Auto-generated constructor stub
		LineBorder lineBorder = new LineBorder(Color.BLACK);
		car1.setBorder(lineBorder);
		car2.setBorder(lineBorder);
		car3.setBorder(lineBorder);
		car4.setBorder(lineBorder);
		
		JPanel jpToolbar = new JPanel();
		jpToolbar.add(jlblCar1);
		jpToolbar.add(jtfCar1);
		jpToolbar.add(jlblCar2);
		jpToolbar.add(jtfCar2);
		jpToolbar.add(jlblCar3);
		jpToolbar.add(jtfCar3);
		jpToolbar.add(jlblCar4);
		jpToolbar.add(jtfCar4);
		
		// Register listeners
		CarListener carListener = new CarListener();
		jtfCar1.addActionListener(carListener);
		jtfCar2.addActionListener(carListener);
		jtfCar3.addActionListener(carListener);
		jtfCar4.addActionListener(carListener);
		
		setLayout(new GridLayout(5, 1));
		add(jpToolbar);
		add(car1);
		add(car2);
		add(car3);
		add(car4);
		
		
	}
	
	class CarListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jtfCar1) 
				car1.setSpeed(Integer.parseInt(jtfCar1.getText()));
			else if (e.getSource() == jtfCar2)
				car2.setSpeed(Integer.parseInt(jtfCar2.getText()));
			else if (e.getSource() == jtfCar3)
				car3.setSpeed(Integer.parseInt(jtfCar3.getText()));
			else if (e.getSource() == jtfCar4)
				car4.setSpeed(Integer.parseInt(jtfCar4.getText()));
		}
	}
	
	@Override
	public void init() {
		setSize(450, 250);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1817_RacingCars applet = new PE1817_RacingCars();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("Exercise18_17");
		frame.setSize(450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
