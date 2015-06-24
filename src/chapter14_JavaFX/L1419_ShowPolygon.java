/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 5. 1. 2015 2015 10:22:23 
 */
public class L1419_ShowPolygon extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Polygon polygon = new Polygon();
		pane.getChildren().add(polygon);
		
		polygon.setStroke(Color.BLACK);
		polygon.setFill(Color.BLUE);
		
		// Get list of points for polygon
		ObservableList<Double> points = polygon.getPoints();
		final double WIDTH = 200, HEIGHT = 200;
		double centerX = WIDTH / 2, centerY = HEIGHT / 2;
		double radius = Math.min(HEIGHT, WIDTH) * 0.4;
		
		
		
		// Add points to the polygon
		for (int i = 0; i < 6; i++) {
			points.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
			points.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
		}
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setTitle("ShowPolygon");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
