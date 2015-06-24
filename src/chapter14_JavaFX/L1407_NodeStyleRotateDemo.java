/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 11:06:00 
 */
public class L1407_NodeStyleRotateDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		Button btOK = new Button("OK");
		btOK.setStyle("-fx-border-color: blue");
		pane.getChildren().add(btOK);
		
		pane.setRotate(45);
		pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
		
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("NodeStyleRotateDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
