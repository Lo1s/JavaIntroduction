/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 23. 10. 2014 2014 14:42:40 
 */
@SuppressWarnings("serial")
public class PE1825_GuessBirthday extends JApplet {

	private JLabel jlblTitle = new JLabel("Check the boxes if your birthday is in these sets");
	private JCheckBox jchkb1 = new JCheckBox();
	private JCheckBox jchkb2 = new JCheckBox();
	private JCheckBox jchkb3 = new JCheckBox();
	private JCheckBox jchkb4 = new JCheckBox();
	private JCheckBox jchkb5 = new JCheckBox();
	private JButton jbtGuessBirthday = new JButton("Guess Birthday");
	private JTextField jtfGuess = new JTextField(2);
	private LineBorder lineBorder = new LineBorder(Color.BLACK);
	private JPanel jp1 = new JPanel(new GridLayout(5, 4, 2, 0));
	private JPanel jp2 = new JPanel(new GridLayout(5, 4, 2, 0));
	private JPanel jp3 = new JPanel(new GridLayout(5, 4, 2, 0));
	private JPanel jp4 = new JPanel(new GridLayout(5, 4, 2, 0));
	private JPanel jp5 = new JPanel(new GridLayout(5, 4, 2, 0));
	
	private static int[][] set1 = {
		{ 1, 3, 5, 7},
		{ 9, 11, 13, 15},
		{17, 19, 21, 23},
		{25, 27, 29, 31}};
	private static int[][] set2 = {
		{ 2, 3, 6, 7},	
		{10, 11, 14, 15},
		{18, 19, 22, 23},
		{26, 27, 30, 31}};
	private static int[][] set3 = {	
		{ 4, 5, 6, 7},
		{12, 13, 14, 15},
		{20, 21, 22, 23},
		{28, 29, 30, 31}};
	private static int[][] set4 = {			
		{ 8, 9, 10, 11},
		{12, 13, 14, 15},
		{24, 25, 26, 27},
		{28, 29, 30, 31}};
	private static int[][] set5 = {
		{16, 17, 18, 19},
		{20, 21, 22, 23},
		{24, 25, 26, 27},
		{28, 29, 30, 31}};
	private int[] dates = {1, 2, 4, 8, 16};  
	private int guessDate = 0;
	
	public PE1825_GuessBirthday() {
		// Create sets UI
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				jp1.add(new JLabel(set1[i][j] + ""));
				jp2.add(new JLabel(set2[i][j] + ""));
				jp3.add(new JLabel(set3[i][j] + ""));
				jp4.add(new JLabel(set4[i][j] + ""));
				jp5.add(new JLabel(set5[i][j] + ""));
			}
		}
		jp1.add(jchkb1);
		jp1.setBorder(lineBorder);
		jp2.add(jchkb2);
		jp2.setBorder(lineBorder);
		jp3.add(jchkb3);
		jp3.setBorder(lineBorder);
		jp4.add(jchkb4);
		jp4.setBorder(lineBorder);
		jp5.add(jchkb5);
		jp5.setBorder(lineBorder);
		
		JPanel jpSets = new JPanel(new FlowLayout(5));
		jpSets.add(jp1);
		jpSets.add(jp2);
		jpSets.add(jp3);
		jpSets.add(jp4);
		jpSets.add(jp5);
		
		// Add Guess panel
		JPanel jpGuess = new JPanel();
		jpGuess.add(jbtGuessBirthday);
		jpGuess.add(jtfGuess);
		
		jlblTitle.setHorizontalAlignment(JLabel.CENTER);
		
		// Register listeners
		jchkb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (jchkb1.isSelected())
					guessDate += dates[0];
			}
		});
		jchkb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jchkb2.isSelected())
					guessDate += dates[1];
			}
		});
		jchkb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jchkb3.isSelected())
					guessDate += dates[2];
			}
		});
		jchkb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jchkb4.isSelected())
					guessDate += dates[3];
			}
		});
		jchkb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guessDate += dates[4];
			}
		});
		jbtGuessBirthday.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtfGuess.setText(guessDate + ".");
			}
		});
		
		add(jlblTitle, BorderLayout.NORTH);
		add(jpSets, BorderLayout.CENTER);
		add(jpGuess, BorderLayout.SOUTH);
	}
	
	@Override
	public void init() {
		setSize(490, 180);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1825_GuessBirthday applet = new PE1825_GuessBirthday();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("Exercise18_25");
		frame.pack();;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
