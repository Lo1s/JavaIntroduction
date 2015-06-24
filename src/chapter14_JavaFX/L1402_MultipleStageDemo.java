/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 9:29:42 
 */
public class L1402_MultipleStageDemo extends Application {

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place a button in the scene
		Scene scene = new Scene(new Button("OK"), 200, 250);
		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Put the scene into the stage
		primaryStage.show(); // Display the stage
		
		Stage stage = new Stage(); // Create a new stage
		stage.setTitle("Second stage"); // Set the stage title
		// Set a scene with a button in the stage
		stage.setScene(new Scene(new Button("New Stage"), 100, 100));
		stage.show();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
