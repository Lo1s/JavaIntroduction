/**
 * 
 */
package chapter13;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 13:10:34 
 */
public class L1308_MessagePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private String message = "Welcome to Java !";
	private int xCoordinate = 20;
	private int yCoordinate = 20;
	private boolean centered;
	private int interval = 10;
	private String fontName = "TimesRoman";
	private int fontStyle = Font.PLAIN;
	private int fontSize = 14;
	private Font font = new Font(fontName, fontStyle, fontSize);
	
	
	public L1308_MessagePanel() {
		
	}
	
	public L1308_MessagePanel(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
		repaint();
	}
	
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	public void setXCoordinate(int x) {
		this.xCoordinate = x;
		repaint();
	}
	
	public int YCoordinate() {
		return yCoordinate;
	}
	
	public void setYCoordinate(int y) {
		this.yCoordinate = y;
		repaint();
	}
	
	public boolean isCentered() {
		return centered;
	}
	
	public void setCentered(boolean centered) {
		this.centered = centered;
		repaint();
	}
	
	public int getInterval() {
		return interval;
	}
	
	public void setInterval(int interval) {
		this.interval = interval;
		repaint();
	}
	
	public void setFontName(String newFontName) {
		this.fontName = newFontName;
	}
	
	public void setFontStyle(int newFontStyle) {
		this.fontStyle += newFontStyle;
	}
	
	public void setFontSize(int newFontSize) {
		this.fontSize = newFontSize;
	}
	
	public void setFont(Font newFont) {
		this.font = newFont;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		
		font = new Font(fontName, fontStyle, fontSize);
		g.setFont(font);
		
		System.out.println(fontName);
		System.out.println(fontStyle);
		System.out.println(fontSize);
		
		if (centered) {
			FontMetrics fm = g.getFontMetrics();
			
			int stringWidth = fm.stringWidth(message);
			int stringAscent = fm.getAscent();
			
			xCoordinate = getWidth() / 2 - stringWidth /2;
			yCoordinate = getHeight() / 2 + stringAscent / 2;
		}
		
		g.drawString(message, xCoordinate, yCoordinate);
	}
	
	public void moveLeft() {
		xCoordinate -= interval;
		repaint();
	}
	
	public void moveRight() {
		xCoordinate += interval;
		repaint();
	}
	
	public void moveUp() {
		yCoordinate -= interval;
		repaint();
	}
	
	public void moveDown() {
		yCoordinate += interval;
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 30);
	}
}
