/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

/**
 * @author jslapnicka
 * @Date & @Time 24. 10. 2014 2014 8:32:58 
 */
@SuppressWarnings("serial")
public class PE1826_MathQuiz extends JApplet {

	// Create the UI
	TitledBorder borderType = new TitledBorder("Choose a type");
	TitledBorder borderLevel = new TitledBorder("Choose a level");
	TitledBorder borderCount = new TitledBorder("Correct Count");
	TitledBorder borderTime = new TitledBorder("Time Spent");
	
	JRadioButton jrbAdd = new JRadioButton("Add");
	JRadioButton jrbSubtract = new JRadioButton("Subtract");
	JRadioButton jrbMultiply = new JRadioButton("Multiply");
	JRadioButton jrbDivide = new JRadioButton("Divide");
	JPanel jpType = new JPanel(new GridLayout(4, 1));
	
	JRadioButton jrb0to5 = new JRadioButton("Numbers from 0 to 5");
	JRadioButton jrb3to9 = new JRadioButton("Numbers from 3 to 9");
	JRadioButton jrb0to20 = new JRadioButton("Numbers from 0 to 20");
	JRadioButton jrbAny = new JRadioButton("Any two digits");
	JPanel jpLevel = new JPanel(new GridLayout(4, 1));
	
	JLabel jlblQuestionTitle = new JLabel("Question:");
	JLabel jlblQuestion = new JLabel("Question will be shown");
	JPanel jpQuestionAnswer = new JPanel(new GridLayout(2, 2));
	
	JLabel jlblAnswerTitle = new JLabel("Answer:");
	JTextField jtfAnswer = new JTextField(10);
	JButton jbtStart = new JButton("Start");
	JButton jbtStop = new JButton("Stop");
	JPanel jpButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel jpAnswer = new JPanel(new GridLayout(3, 1));
	
	JLabel jlblCount = new JLabel("Correct count will be shown");
	JLabel jlblTime = new JLabel("Time spent will be shown");
	JPanel jpStatus = new JPanel(new GridLayout(1, 2));
	
	JPanel jpSettings = new JPanel(new GridLayout(1, 2));
	JPanel jpBottomPanel = new JPanel(new BorderLayout());
	
	// Data field
	private char operation;
	private int result;
	private int count = 0;
	private int op1;
	private int op2;
	private Timer timer;
	private int seconds;
	
	public PE1826_MathQuiz() {
		// TODO Auto-generated constructor stub
		ButtonGroup groupType = new ButtonGroup();
		groupType.add(jrbAdd);
		groupType.add(jrbSubtract);
		groupType.add(jrbMultiply);
		groupType.add(jrbDivide);
		jpType.add(jrbAdd);
		jpType.add(jrbSubtract);
		jpType.add(jrbMultiply);
		jpType.add(jrbDivide);
		jpType.setBorder(borderType);
		
		ButtonGroup groupLevel = new ButtonGroup();
		groupLevel.add(jrb0to5);
		groupLevel.add(jrb3to9);
		groupLevel.add(jrb0to20);
		groupLevel.add(jrbAny);
		jpLevel.add(jrb0to5);
		jpLevel.add(jrb3to9);
		jpLevel.add(jrb0to20);
		jpLevel.add(jrbAny);
		jpLevel.setBorder(borderLevel);
		
		jpSettings.add(jpType);
		jpSettings.add(jpLevel);
		
		jlblQuestionTitle.setHorizontalAlignment(JLabel.LEFT);
		jlblQuestion.setHorizontalAlignment(JLabel.RIGHT);
		jpQuestionAnswer.add(jlblQuestionTitle);
		jlblAnswerTitle.setHorizontalAlignment(JLabel.LEFT);
		jpQuestionAnswer.add(jlblAnswerTitle);
		jpQuestionAnswer.add(jlblQuestion);
		jpQuestionAnswer.add(jtfAnswer);
				
		jlblCount.setBorder(borderCount);
		jlblTime.setBorder(borderTime);
		jpStatus.add(jlblCount);
		jpStatus.add(jlblTime);
		
		jpButtons.add(jbtStart);
		jpButtons.add(jbtStop);
		
		jpBottomPanel.add(jpButtons, BorderLayout.NORTH);
		jpBottomPanel.add(jpStatus, BorderLayout.CENTER);

		
		// Register listeners
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				seconds++;
				jlblTime.setText(seconds + "");
				repaint();
			}
		});
		
		RadioButtonsListener rBListener = new RadioButtonsListener();
		/** 
		 * jrbAdd.addActionListener(rBListener);
		 * jrbSubtract.addActionListener(rBListener);
		 * jrbMultiply.addActionListener(rBListener);
		 * jrbDivide.addActionListener(rBListener);
		 * jrb0to5.addActionListener(rBListener);
		 * jrb3to9.addActionListener(rBListener);
		 * jrb0to20.addActionListener(rBListener);
		 * jrbAny.addActionListener(rBListener); */
		jbtStart.addActionListener(rBListener);
		jtfAnswer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(jtfAnswer.getText()) == result) {
					count++;
					jlblCount.setText(count + "");
					repaint();
				}
			}
		});
		jbtStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer.stop();
			}
		});
		
		// Add items to the frame
		add(jpSettings, BorderLayout.NORTH);
		add(jpQuestionAnswer, BorderLayout.CENTER);
		add(jpBottomPanel, BorderLayout.SOUTH);
	}
	
	class RadioButtonsListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			timer.start();
			if (jrbAdd.isSelected())
				operation = '+';
			else if (jrbSubtract.isSelected())
				operation = '-';
			else if (jrbMultiply.isSelected())
				operation = '*';
			else if (jrbDivide.isSelected())
				operation = '/';
			
			if (jrb0to5.isSelected()) {
				op1 = hdR.mtd.getRandomNumber(0, 5);
				op2 = hdR.mtd.getRandomNumber(0, 5);
			} else if (jrb3to9.isSelected()) {
				op1 = hdR.mtd.getRandomNumber(3, 9);
				op2 = hdR.mtd.getRandomNumber(3, 9);
			} else if (jrb0to20.isSelected()) {
				op1 = hdR.mtd.getRandomNumber(0, 20);
				op1 = hdR.mtd.getRandomNumber(0, 20);
			} else if (jrbAny.isSelected()) {
				op1 = hdR.mtd.getRandomNumber(0, (int)(Math.sqrt(Integer.MAX_VALUE - 1)));
				op2 = hdR.mtd.getRandomNumber(0, (int)(Math.sqrt(Integer.MAX_VALUE - 1)));
			}
			result(op1, op2);				
			jlblQuestion.setText(op1 + " " + operation + " " + op2 + " = ");
			repaint();
		}
	}
	
	public void result(int op1, int op2) {
		switch(operation) {
		case '+' : result = op1 + op2; break;
		case '-' : result = op1 - op2; break;
		case '*' : result = op1 * op2; break;
		case '/' : result = op1 / op2; break;
		}
	}
	
	@Override
	public void init() {
		setSize(350, 270);
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
		JFrame frame = new JFrame();
		PE1826_MathQuiz applet = new PE1826_MathQuiz();
		
		frame.add(applet);
		frame.setTitle("Exercise18_26");
		frame.setSize(350, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
