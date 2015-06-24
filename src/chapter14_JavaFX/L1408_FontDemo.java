/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 12:41:03 
 */
public class L1408_FontDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new StackPane();
		
		Circle circle = new Circle();
		circle.setRadius(50);
		circle.setStroke(Color.BLUEVIOLET);
		circle.setStrokeWidth(5);
		circle.setFill(Color.YELLOW);
		pane.getChildren().add(circle);
		
		// Create a label and set its properties
		Label lbl = new Label("JavaFX");
		lbl.setFont(Font.font("TimesRoman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		pane.getChildren().add(lbl);
		
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("FontDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
