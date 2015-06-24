/**
 * 
 */
package chapter13;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 7:58:32 
 */
public class L1302_TestFigurePanel extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public L1302_TestFigurePanel() {
		setLayout(new GridLayout(2, 3, 5, 5));
		add(new L1303_FigurePanel(L1303_FigurePanel.LINE));
		add(new L1303_FigurePanel(L1303_FigurePanel.RECTANGLE));
		add(new L1303_FigurePanel(L1303_FigurePanel.ROUND_RECTANGLE));
		add(new L1303_FigurePanel(L1303_FigurePanel.OVAL));
		add(new L1303_FigurePanel(L1303_FigurePanel.RECTANGLE, true));
		add(new L1303_FigurePanel(L1303_FigurePanel.ROUND_RECTANGLE, true));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1302_TestFigurePanel frame = new L1302_TestFigurePanel();
		frame.setSize(400, 200);
		frame.setTitle("TestFigurePanel");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
