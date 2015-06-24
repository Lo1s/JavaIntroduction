/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 10:26:55 
 */
public class L1404_ShowCircle extends Application {

	@Override
	public void start(Stage primaryStage) {
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setStroke(Color.BLUE);
		circle.setFill(Color.WHITE);
		
		Pane pane = new Pane();
		pane.getChildren().add(circle);
		
		// Create a Scene and place it in the stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("ShowCircle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
