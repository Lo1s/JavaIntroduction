/**
 * 
 */
package chapter16_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 9:30:05 
 */
public class L1605_Client extends Application {

	L1605_TextFieldDemo tfDemo = new L1605_TextFieldDemo();
	
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(tfDemo.getPane(), 400, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TextFieldDemo");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
