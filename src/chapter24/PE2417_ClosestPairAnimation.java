/**
 * 
 */
package chapter24;

import java.util.ArrayList;



import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 4. 2. 2015 2015 8:24:10 
 */
public class PE2417_ClosestPairAnimation extends Application {

	// Horrible solution but I've felt kinda lazy
	private ArrayList<Circle> points = new ArrayList<Circle>();
	private Line line = new Line();
	
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
		paneCanvas.getChildren().addAll(circles);
		// Register listeners
		paneCanvas.setOnMouseClicked(e -> {
			// Add circles
			if (e.getButton() == MouseButton.PRIMARY) {
				Circle circle = new Circle(e.getX(), e.getY(), 5);
				circle.setFill(Color.BLACK);
				circles.add(circle);
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
			Pair closestPoints = closestPairBruteForce(points);
			if (closestPoints != null) {
				circles.remove(line);
				line.setStartX(closestPoints.p1.getCenterX());
				line.setStartY(closestPoints.p1.getCenterY());
				line.setEndX(closestPoints.p2.getCenterX());
				line.setEndY(closestPoints.p2.getCenterY());
				circles.add(line);
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
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
	
	public static double distance(Circle p1, Circle p2) {
		return distance(p1.getCenterX(), p1.getCenterY(), p2.getCenterX(), p2.getCenterY());
	}
	
	public static Pair closestPairBruteForce(ArrayList<Circle> points) {
		if (points.size() < 2)
			return null;
		Pair pair = new Pair();
		pair.p1 = points.get(0);
		pair.p2 = points.get(1);
		double shortestDistances = distance(pair.p1, pair.p2);
		for (int i = 0; i < points.size(); i++) {
			for (int j = i + 1; j < points.size(); j++) {
				double distance = distance(points.get(i), points.get(j));
				if (distance < shortestDistances) {
					pair.p1 = points.get(i);
					pair.p2 = points.get(j);
					shortestDistances = distance;
				}
			}
		}

		return pair;
	}
	
	public static class Pair {
		private Circle p1;
		private Circle p2;

		public Pair() {
			// TODO Auto-generated constructor stub
		}

		public Pair(Circle p1, Circle p2) {
			this.p1 = p1;
			this.p2 = p2;
		}

		public double getDistance() {
			return distance(p1, p2);
		}
		
		public String toString() {
            return (new StringBuilder("(")).append(p1.getCenterX()).append(", ").append(p1.getCenterY()).append(") and (").append(p2.getCenterX()).append(", ").append(p2.getCenterY()).append(")").toString();
        }
	}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Application.launch(args);

		}

	}
