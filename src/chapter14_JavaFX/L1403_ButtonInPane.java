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
 * @Date & @Time 2. 1. 2015 2015 10:20:50 
 */
public class L1403_ButtonInPane extends Application {

	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		pane.getChildren().add(new Button("OK"));
		Scene scene = new Scene(pane, 200, 50);
		primaryStage.setTitle("ButtonInPane");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
