/**
 * 
 */
package chapter14;

import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 27. 8. 2014 2014 8:58:00 
 */
public class PE1421_DisplayGraph extends JFrame {

	int numberOfVertices;
	int[] vertices;
	int[] xCoordination;
	int[] yCoordination;
	int[] v1;
	int[] v2;
	int[] v3;
	int[] v4;
	int[] numberOfItems;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1421_DisplayGraph() {
		// TODO Auto-generated constructor stub

	}

	public PE1421_DisplayGraph(int numberOfVertices, int[] vertices, int[] xCoordination, int[] yCoordination, 
			int[] v1, int[] v2, int[] v3, int[] v4, int[] numberOfItems) {
		this.numberOfVertices = numberOfVertices;
		this.vertices = vertices;
		this.xCoordination = xCoordination;
		this.yCoordination = yCoordination;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.numberOfItems = numberOfItems;

		add(new drawGraph(numberOfVertices, vertices, xCoordination, yCoordination, v1, v2, v3, v4, numberOfItems));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		// Read the url site
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a URL: ");
		String URLString = input.next();
		input.close();

		// Read the data from the file 
		try {
			URL url = new URL(URLString);
			input = new Scanner(url.openStream());
		}
		catch (MalformedURLException ex) {
			System.out.println("URL is not in the right format. Please use \"http://www.YourWebsite.com");
		}
		catch (IOException ex) {
			System.out.println("I/O exception. No such file");
		}

		// Create arrays for storing values from the URL site
		int numberOfVertices = input.nextInt();
		input.nextLine();
		int[] vertices = new int[numberOfVertices];
		int[] xCoordination = new int[numberOfVertices];
		int[] yCoordination = new int[numberOfVertices];
		int[] v1 = new int[numberOfVertices];
		int[] v2 = new int[numberOfVertices];
		int[] v3 = new int[numberOfVertices];
		int[] v4 = new int[numberOfVertices];
		int[] numberOfItems = new int[numberOfVertices];

		// Store the data
		for (int i = 0; i < numberOfVertices; i++) {
			// Check how many items in the line
			String s = input.nextLine();
			String[] tempString = s.split(" ");
			if (tempString.length > 3) {
				numberOfItems[i] = tempString.length - 3;
				vertices[i] = Integer.valueOf(tempString[0]);
				xCoordination[i] = Integer.valueOf(tempString[1]);
				yCoordination[i] = Integer.valueOf(tempString[2]);
				v1[i] = Integer.valueOf(tempString[3]);
				v2[i] = Integer.valueOf(tempString[4]);
				if (numberOfItems[i] == 3)
					v3[i] = Integer.valueOf(tempString[5]);
				if (numberOfItems[i] == 4) {
					v3[i] = Integer.valueOf(tempString[5]);
					v4[i] = Integer.valueOf(tempString[6]);	
				}
			}
		}


		// Creating the frame
		JFrame frame = new PE1421_DisplayGraph(numberOfVertices, vertices, xCoordination, yCoordination, v1, v2, v3, v4, numberOfItems);
		frame.setTitle("Exercise14_21");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

}

class drawGraph extends JPanel {

	int numberOfVertices;
	int[] vertices;
	int[] xCoordination;
	int[] yCoordination;
	int[] v1;
	int[] v2;
	int[] v3;
	int[] v4;
	int[] numberOfItems;

	public drawGraph() {
		// TODO Auto-generated constructor stub
	}

	public drawGraph(int numberOfVertices, int[] vertices, int[] xCoordination, int[] yCoordination,
			int[] v1, int[] v2, int[] v3, int[] v4, int[] numberOfItems) {
		this.numberOfVertices = numberOfVertices;
		this.vertices = vertices;
		this.xCoordination = xCoordination;
		this.yCoordination = yCoordination;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.numberOfItems = numberOfItems;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (int i = 0; i < numberOfVertices; i++) {
			g.fillOval(xCoordination[i] - 10, yCoordination[i] - 10, 20, 20);
			g.drawString(String.valueOf(vertices[i]), xCoordination[i] - 15, yCoordination[i] - 15);
			switch (numberOfItems[i]) {
				case 2: g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v1[i]], yCoordination[v1[i]]);
						g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v2[i]], yCoordination[v2[i]]); break;
				case 3: g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v1[i]], yCoordination[v1[i]]);
						g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v2[i]], yCoordination[v2[i]]);
						g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v3[i]], yCoordination[v3[i]]); break;
				case 4: g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v1[i]], yCoordination[v1[i]]);
						g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v2[i]], yCoordination[v2[i]]);
						g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v3[i]], yCoordination[v3[i]]);
						g.drawLine(xCoordination[i], yCoordination[i], xCoordination[v4[i]], yCoordination[v4[i]]); break;
			}



		}
	}

}
