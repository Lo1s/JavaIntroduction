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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 30. 1. 2015 2015 15:11:00 
 */
public class PE2413_ConvexHullAnimation extends Application {

	// Horrible solution but I've felt kinda lazy
	private ArrayList<Circle> points = new ArrayList<Circle>();

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
				Circle circle = new Circle(e.getX(), e.getY(), 5);
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
			ArrayList<Circle> convexHullPoints = getConvexHull(points);
			Polygon p = new Polygon();
			for (int i = 0; i < convexHullPoints.size(); i++) {
				p.getPoints().add(convexHullPoints.get(i).getCenterX());
				p.getPoints().add(convexHullPoints.get(i).getCenterY());
			}
			p.setFill(null);
			p.setStroke(Color.BLACK);

			for (int i = 0; i < points.size(); i++) {
				paneCanvas.getChildren().add(points.get(i));
			}
			paneCanvas.getChildren().add(p);
		});

		BorderPane pane = new BorderPane();
		pane.setLeft(paneInstructions);
		pane.setCenter(paneCanvas);


		Scene scene = new Scene(pane, 350, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise24_13");
		primaryStage.show();
	}

	public static ArrayList<Circle> getConvexHull(ArrayList<Circle> s) {
		ArrayList<Circle> convexHull = new ArrayList<Circle>();

		// Find the rightmost lowest point
		Circle h0 = s.get(0);
		for (int i = 0; i < s.size(); i++) {
			if (h0.getCenterY() < s.get(i).getCenterY()) {
				h0 = s.get(i);
			} else if (h0.getCenterY() == s.get(i).getCenterY() && h0.getCenterX() < s.get(i).getCenterX())
				h0 = s.get(i);
		}
		convexHull.add(h0);
		Circle t0 = h0;
		// Find t1 to form the first line
		do {
			Circle t1 = s.get(0);
			for (int i = 1; i < s.size(); i++) {
				double side = whichSide(t0.getCenterX(), t0.getCenterY(), t1.getCenterX(), t1.getCenterY(), s.get(i).getCenterX(), s.get(i).getCenterY());
				if (side > 0.0D) {
					t1 = s.get(i);
				} else if (side == 0.0D && distance(s.get(i).getCenterX(), s.get(i).getCenterY(), t0.getCenterX(), t0.getCenterY()) > distance(t1.getCenterX(), t1.getCenterY(), t0.getCenterX(), t0.getCenterY())) {
					t1 = s.get(i);
				}
			}

			if (t1.getCenterX() != h0.getCenterX() || t1.getCenterY() != h0.getCenterY()) {
				convexHull.add(t1);
				t0 = t1;
			} else {
				return convexHull;
			}

		} while (true);
	}




	public static double whichSide(double x0, double y0, double x1, double y1, double x2, double y2) {
		return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
