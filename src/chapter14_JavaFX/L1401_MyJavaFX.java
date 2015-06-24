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
 * @Date & @Time 2. 1. 2015 2015 9:00:36 
 */
public class L1401_MyJavaFX extends Application {
	
	// Override the start method in the application class
	@Override
	public void start(Stage primaryStage) {
		// Create a scene and place a button in the scene
		Button btOK = new Button("OK");
		Scene scene = new Scene(btOK, 250, 250);
		
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
