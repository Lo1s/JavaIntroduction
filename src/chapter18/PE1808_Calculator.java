/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 8. 10. 2014 2014 17:14:35 
 */
@SuppressWarnings("serial")
public class PE1808_Calculator extends JApplet {

	// Create UI
	JTextField jtfDisplay = new JTextField(30);
	JLabel jlblEmpty = new JLabel();
	JButton jbtEmpty = new JButton();
	JButton jbtBack = new JButton("Back");
	JButton jbtCE = new JButton("CE");
	JButton jbtC = new JButton("C");
	JButton jbtMC = new JButton("MC");
	JButton jbtMR = new JButton("MR");
	JButton jbtMS = new JButton("MS");
	JButton jbtMplus = new JButton("M+");
	JButton jbtZero = new JButton("0");
	JButton jbtOne = new JButton("1");
	JButton jbtTwo = new JButton("2");
	JButton jbtThree = new JButton("3");
	JButton jbtFour = new JButton("4");
	JButton jbtFive = new JButton("5");
	JButton jbtSix = new JButton("6");
	JButton jbtSeven = new JButton("7");
	JButton jbtEight = new JButton("8");
	JButton jbtNine = new JButton("9");
	JButton jbtPlusMinus = new JButton("+/-");
	JButton jbtDecimal = new JButton(".");
	JButton jbtDivide = new JButton("/");
	JButton jbtMultiply = new JButton("*");
	JButton jbtMinus = new JButton("-");
	JButton jbtPlus = new JButton("+");
	JButton jbtSqrt = new JButton("sqrt");
	JButton jbtModulus = new JButton("%");
	JButton jbtMultiplicativeInverse = new JButton("1/x");
	JButton jbtEquals = new JButton("=");

	// Data field
	BigInteger number = BigInteger.ZERO;
	String sign = "";
	BigInteger previousNumber = BigInteger.ZERO;
	BigInteger result = BigInteger.ZERO;
	boolean firstTime = true;

	public PE1808_Calculator() {
		// TODO Auto-generated constructor stub
		ButtonListener listener = new ButtonListener();
		//Create panel for the input correction
		JPanel jpCorrection = new JPanel(new GridLayout(1, 5, 5, 5));
		jpCorrection.add(jbtEmpty);
		jpCorrection.add(jlblEmpty);
		jpCorrection.add(jbtBack);
		jpCorrection.add(jbtCE);
		jbtCE.addActionListener(listener);
		jpCorrection.add(jbtC);
		jbtC.addActionListener(listener);

		JPanel jpKeyboard = new JPanel(new GridLayout(4, 6));
		jpKeyboard.add(jbtMC);
		jbtMC.addActionListener(listener);
		jpKeyboard.add(jbtSeven);
		jbtSeven.addActionListener(listener);
		jpKeyboard.add(jbtEight);
		jbtEight.addActionListener(listener);
		jpKeyboard.add(jbtNine);
		jbtNine.addActionListener(listener);
		jpKeyboard.add(jbtDivide);
		jbtDivide.addActionListener(listener);
		jpKeyboard.add(jbtSqrt);
		jbtSqrt.addActionListener(listener);
		jpKeyboard.add(jbtMR);
		jbtMR.addActionListener(listener);
		jpKeyboard.add(jbtFour);
		jbtFour.addActionListener(listener);
		jpKeyboard.add(jbtFive);
		jbtFive.addActionListener(listener);
		jpKeyboard.add(jbtSix);
		jbtSix.addActionListener(listener);
		jpKeyboard.add(jbtMultiply);
		jbtMultiply.addActionListener(listener);
		jpKeyboard.add(jbtModulus);
		jbtModulus.addActionListener(listener);
		jpKeyboard.add(jbtMS);
		jbtMS.addActionListener(listener);
		jpKeyboard.add(jbtOne);
		jbtOne.addActionListener(listener);
		jpKeyboard.add(jbtTwo);
		jbtTwo.addActionListener(listener);
		jpKeyboard.add(jbtThree);
		jbtThree.addActionListener(listener);
		jpKeyboard.add(jbtMinus);
		jbtMinus.addActionListener(listener);
		jpKeyboard.add(jbtMultiplicativeInverse);
		jbtMultiplicativeInverse.addActionListener(listener);
		jpKeyboard.add(jbtMplus);
		jbtMplus.addActionListener(listener);
		jpKeyboard.add(jbtZero);
		jbtZero.addActionListener(listener);
		jpKeyboard.add(jbtPlusMinus);
		jbtPlusMinus.addActionListener(listener);
		jpKeyboard.add(jbtDecimal);
		jbtDecimal.addActionListener(listener);
		jpKeyboard.add(jbtPlus);
		jbtPlus.addActionListener(listener);
		jpKeyboard.add(jbtEquals);
		jbtEquals.addActionListener(listener);

		// Add items to the frame
		add(jtfDisplay, BorderLayout.NORTH);
		add(jpCorrection, BorderLayout.CENTER);
		add(jpKeyboard, BorderLayout.SOUTH);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/** First number */
			if ((e.getSource() == jbtZero)) {
				number = new BigInteger((number.multiply(new BigInteger("10"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtOne) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(BigInteger.ONE)) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtTwo) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("2"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtThree) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("3"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtFour) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("4"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtFive) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("5"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtSix) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("6"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtSeven) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("7"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtEight) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("8"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			} else if (e.getSource() == jbtNine) {
				number = new BigInteger((number.multiply(new BigInteger("10")).add(new BigInteger("9"))) + "");
				jtfDisplay.setText(number + "");
				firstTime = true;
			}
			/** Sign */
			if (sign.length() != 0) {
				if (e.getSource() == jbtPlus || e.getSource() == jbtPlusMinus) {
					switch (sign.charAt(0)) {
					case '+' : result = previousNumber.add(number); sign = "+"; break;
					case '-' : result = previousNumber.subtract(number); sign = "+"; break;
					case '*' : result = previousNumber.multiply(number); sign = "+"; break;
					case '/' : result = previousNumber.divide(number); sign = "+"; break;
					case 's' : result = sqrt(previousNumber); sign = "+"; break;
					case '%' : result = previousNumber.remainder(number); sign = "+"; break;
					}
					previousNumber = result; 
					number = BigInteger.ZERO;
					jtfDisplay.setText(result + "");
				} else if (e.getSource() == jbtMinus) {
					switch (sign.charAt(0)) {
					case '+' : result = previousNumber.add(number); sign = "-"; break;
					case '-' : result = previousNumber.subtract(number); sign = "-"; break;
					case '*' : result = previousNumber.multiply(number); sign = "-"; break;
					case '/' : result = previousNumber.divide(number); sign = "-"; break;
					case 's' : result = sqrt(previousNumber); sign = "-"; break;
					case '%' : result = previousNumber.remainder(number); sign = "-"; break;
					}
					previousNumber = result; 
					number = BigInteger.ZERO;
					jtfDisplay.setText(result + "");
				} else if (e.getSource() == jbtMultiply) {
					switch (sign.charAt(0)) {
					case '+' : result = previousNumber.add(number); sign = "*"; break;
					case '-' : result = previousNumber.subtract(number); sign = "*"; break;
					case '*' : result = previousNumber.multiply(number); sign = "*"; break;
					case '/' : result = previousNumber.divide(number); sign = "*"; break;
					case 's' : result = sqrt(previousNumber); sign = "*"; break;
					case '%' : result = previousNumber.remainder(number); sign = "*"; break;
					}
					previousNumber = result; 
					number = BigInteger.ZERO;
					jtfDisplay.setText(result + "");
				} else if (e.getSource() == jbtDivide) {
					switch (sign.charAt(0)) {
					case '+' : result = previousNumber.add(number); sign = "/"; break;
					case '-' : result = previousNumber.subtract(number); sign = "/"; break;
					case '*' : result = previousNumber.multiply(number); sign = "/";; break;
					case '/' : result = previousNumber.divide(number); sign = "/"; break;
					case 's' : result = sqrt(previousNumber); sign = "/"; break;
					case '%' : result = previousNumber.remainder(number); sign = "/"; break;
					}
					previousNumber = result; 
					number = BigInteger.ZERO;
					jtfDisplay.setText(result + "");
				} else if (e.getSource() == jbtSqrt) {
					switch (sign.charAt(0)) {
					case '+' : result = previousNumber.add(number); sign = "sqrt"; break;
					case '-' : result = previousNumber.subtract(number); sign = "sqrt"; break;
					case '*' : result = previousNumber.multiply(number); sign = "sqrt"; break;
					case '/' : result = previousNumber.divide(number); sign = "sqrt"; break;
					case 's' : result = sqrt(previousNumber); sign = "sqrt"; break;
					case '%' : result = previousNumber.remainder(number); sign = "sqrt"; break;
					}
					previousNumber = result; 
					number = BigInteger.ZERO;
					jtfDisplay.setText(result + "");
				} else if (e.getSource() == jbtModulus) {
					switch (sign.charAt(0)) {
					case '+' : result = previousNumber.add(number); sign = "%"; break;
					case '-' : result = previousNumber.subtract(number); sign = "%"; break;
					case '*' : result = previousNumber.multiply(number); sign = "*"; break;
					case '/' : result = previousNumber.divide(number); sign = "%"; break;
					case 's' : result = sqrt(previousNumber); sign = "%"; break;
					case '%' : result = previousNumber.remainder(number); sign = "%"; break;
					}
					previousNumber = result; 
					number = BigInteger.ZERO;
					jtfDisplay.setText(result + "");
				}
			} else {
				if (e.getSource() == jbtPlusMinus || e.getSource() == jbtPlus) {
					sign = "+";
					previousNumber = (firstTime) ? number : result;
					number = BigInteger.ZERO;
				}
				if (e.getSource() == jbtMinus) {
					sign = "-";
					previousNumber = (firstTime) ? number : result;
					number = BigInteger.ZERO;
				}
				if (e.getSource() == jbtMultiply) {
					sign = "*";
					previousNumber = (firstTime) ? number : result;
					number = BigInteger.ZERO;
				}
				if (e.getSource() == jbtDivide) {
					sign = "/";
					previousNumber = (firstTime) ? number : result;
					number = BigInteger.ZERO;
				}				
				if (e.getSource() == jbtSqrt) {
					sign = "sqrt";
					previousNumber = (firstTime) ? number : result;
					number = BigInteger.ZERO;
				}
				if (e.getSource() == jbtModulus) {
					sign = "%";
					previousNumber = (firstTime) ? number : result;
					number = BigInteger.ZERO;
				}
			}
			System.out.println(sign);
			System.out.println("number: " + number);
			System.out.println("previousNumber: " + previousNumber);
			/** Delete & equals */
			if (e.getSource() == jbtEquals && sign.length() > 0) {
				firstTime = false;
				switch (sign.charAt(0)) {
				case '+' : result = previousNumber.add(number); sign = ""; break;
				case '-' : result = previousNumber.subtract(number); sign = ""; break;
				case '*' : result = previousNumber.multiply(number); sign = ""; break;
				case '/' : result = previousNumber.divide(number); sign = ""; break;
				case 's' : result = sqrt(previousNumber); sign = ""; break;
				case '%' : result = previousNumber.remainder(number); sign = ""; break;
				}
				previousNumber = result;
				number = BigInteger.ZERO;
				jtfDisplay.setText(result + "");
				System.out.println("Equals");
				System.out.println("--------");
				System.out.println(sign);
				System.out.println("number: " + number);
				System.out.println("previousNumber: " + previousNumber);
			}
			if (e.getSource() == jbtC || e.getSource() == jbtCE) {
				previousNumber = BigInteger.ZERO;
				number = BigInteger.ZERO;
				result = BigInteger.ZERO;
				firstTime = true;
				sign = "";
				System.out.println(result + " - result");
				jtfDisplay.setText(result + "");
			}
		}
	}
	// http://stackoverflow.com/questions/4407839/how-can-i-find-the-square-root-of-a-java-biginteger
	public static BigInteger sqrt(BigInteger x) {
		System.out.println("x.bitlength: " + x.bitLength());
		System.out.println("setbit for zero: " + x.bitLength()/2);
		BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1808_Calculator applet = new PE1808_Calculator();
		JFrame frame = new JFrame();
		frame.add(applet);

		frame.setTitle("Exercise18_08");
		frame.setSize(360, 190);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
