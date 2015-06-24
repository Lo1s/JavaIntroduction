/**
 * 
 */
package chapter16_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 7. 1. 2015 2015 16:25:13 
 */
public class L1603_Client extends Application {

	private L1603_CheckBoxDemo test = new L1603_CheckBoxDemo();
	
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(test.getPane(), 450, 200);
		primaryStage.setTitle("CheckBoxDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
