/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 3. 2. 2015 2015 8:18:20 
 */
public class PE2415_NonCrossPolygon extends Application {

	// Horrible solution but I've felt kinda lazy
	private ArrayList<MyPoint> points = new ArrayList<MyPoint>();

	@Override
	public void start(Stage primaryStage) {
		// Create the instruction panel
		Pane paneInstructions = new Pane();
		Rectangle rectInstructions = new Rectangle(10, 10, 120, 75);
		rectInstructions.setStroke(Color.BLACK);
		rectInstructions.setFill(Color.WHITE);
		Text txtInstructions = new Text("INSTRUCTIONS");
		txtInstructions.setX(20);
		txtInstructions.setY(25);
		Text txtLeftClick = new Text(20, 50, "Add: Left Click");
		Text txtRightClick = new Text(20, 70, "Remove: Right Click");
		paneInstructions.getChildren().addAll(rectInstructions, txtInstructions, txtLeftClick, txtRightClick);

		// Area for drawing
		Pane paneCanvas = new Pane();
		paneCanvas.setPrefSize(350/2, 150);
		paneCanvas.setStyle("-fx-border-color: black");
		ObservableList<Node> circles = paneCanvas.getChildren();
		// Register listeners
		paneCanvas.setOnMouseClicked(e -> {
			// Add circles
			paneCanvas.getChildren().clear();
			if (e.getButton() == MouseButton.PRIMARY) {
				MyPoint circle = new MyPoint(e.getX(), e.getY());
				circle.setFill(Color.BLACK);
				points.add(circle);
			} else if (e.getButton() == MouseButton.SECONDARY) {
				for (int i = 0; i < circles.size(); i++) {
					if (circles.get(i).contains(e.getX(), e.getY())) {
						circles.remove(i);
					}
				}
				for (int i = 0; i < points.size(); i++) {
					if (points.get(i).contains(e.getX(), e.getY())) {
						points.remove(i);
					}
				}
			}

			// Draw convex hull
			ArrayList<MyPoint> convexHullPoints = getPolygon(points);
			if (convexHullPoints != null) {
				Polygon p = new Polygon();
				for (int i = 0; i < convexHullPoints.size(); i++) {
					p.getPoints().add(convexHullPoints.get(i).getX());
					p.getPoints().add(convexHullPoints.get(i).getY());
				}
				p.setFill(null);
				p.setStroke(Color.BLACK);

				for (int i = 0; i < points.size(); i++) {
					paneCanvas.getChildren().add(points.get(i));
				}
				paneCanvas.getChildren().add(p);
			}
		});

		BorderPane pane = new BorderPane();
		pane.setLeft(paneInstructions);
		pane.setCenter(paneCanvas);


		Scene scene = new Scene(pane, 350, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise24_15");
		primaryStage.show();
	}

	public static ArrayList<MyPoint> getPolygon(ArrayList<MyPoint> s) {
		ArrayList<MyPoint> P = new ArrayList<MyPoint>();
		for (int i = 0; i < s.size(); i++) {
			P.add(s.get(i));
		}
		placeP0(P);
		for (int i = 0; i < P.size(); i++) {
			P.get(i).setRightMostLowestPoint(P.get(0));
		}

		Collections.sort(P);
		P = discardTies(P);

		return P;

	}

	private static ArrayList<MyPoint> discardTies(ArrayList<MyPoint> p) {
		ArrayList<MyPoint> list = new ArrayList<MyPoint>();
		list.add((MyPoint)p.get(0));
		int k;
		for(int i = 1; i < p.size(); i = k)
		{
			double d = distance(((MyPoint)p.get(0)).x, ((MyPoint)p.get(0)).y, ((MyPoint)p.get(i)).x, ((MyPoint)p.get(i)).y);
			int indexOfLargest = i;
			for(k = i + 1; k < p.size() && ((MyPoint)p.get(i)).compareTo((MyPoint)p.get(k)) == 0; k++)
			{
				if(d < distance(((MyPoint)p.get(0)).x, ((MyPoint)p.get(0)).y, ((MyPoint)p.get(k)).x, ((MyPoint)p.get(k)).y))
				{
					d = distance(((MyPoint)p.get(0)).x, ((MyPoint)p.get(0)).y, ((MyPoint)p.get(k)).x, ((MyPoint)p.get(k)).y);
					indexOfLargest = k;
				}
			}

			list.add((MyPoint)p.get(indexOfLargest));
		}

		return list;
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public static double whichSide(double x0, double y0, double x1, double y1, double x2, double y2) {
		return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	}

	private static void placeP0(ArrayList<MyPoint> p) {
		int rightMostIndex = 0;
		double rightMostX = ((MyPoint)p.get(0)).x;
		double rightMostY = ((MyPoint)p.get(0)).y;
		for(int i = 1; i < p.size(); i++)
		{
			if(rightMostY < ((MyPoint)p.get(i)).y)
			{
				rightMostY = ((MyPoint)p.get(i)).y;
				rightMostX = ((MyPoint)p.get(i)).x;
				rightMostIndex = i;
			} else
				if(rightMostY == ((MyPoint)p.get(i)).y && rightMostX < ((MyPoint)p.get(i)).x)
				{
					rightMostX = ((MyPoint)p.get(i)).x;
					rightMostIndex = i;
				}
		}

		if(rightMostIndex != 0)
		{
			MyPoint temp = (MyPoint)p.get(0);
			p.set(0, (MyPoint)p.get(rightMostIndex));
			p.set(rightMostIndex, temp);
		}
	}

	public static class MyPoint extends Circle implements Comparable<MyPoint> {
		double x, y;
		MyPoint rightMostLowestPoint;
		double radius = 5;

		public MyPoint(double x, double y) {
			this.x = x;
			this.y = y;
			this.radius = 5;
		}

		public MyPoint(double x, double y, double radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		public void setRightMostLowestPoint(MyPoint p) {
			rightMostLowestPoint = p;
			rightMostLowestPoint.radius = 5;
		}
		
		public double getX() {
			return this.x;
		}
		
		public double getY() {
			return this.y;
		}
		
		@Override
		public int compareTo(MyPoint o) {
			if (o == this.rightMostLowestPoint && y == this.rightMostLowestPoint.y)
				return 1;

			double status = whichSide(rightMostLowestPoint.x, rightMostLowestPoint.y, o.x, o.y, this.x, this.y);
			if (status < 0.0D) {
				return 1;
			}
			return status != 0.0D ? -1 : 0;
		}

		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}
	}

}
