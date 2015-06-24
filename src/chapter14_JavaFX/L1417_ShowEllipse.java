/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 5. 1. 2015 2015 8:11:14 
 */
public class L1417_ShowEllipse extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		
		for (int i = 0; i < 32; i++) {
			// Create an ellipse and add it to pane
			Ellipse e1 = new Ellipse(150, 100, 100, 50);
			e1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			e1.setFill(null);
			e1.setRotate(i * 180 / 32);
			pane.getChildren().add(e1);
		}
		
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("ShowEllipse");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
