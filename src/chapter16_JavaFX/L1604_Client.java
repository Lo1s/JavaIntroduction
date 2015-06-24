/**
 * 
 */
package chapter16_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 9:20:58 
 */
public class L1604_Client extends Application {

	L1604_RadioButtonDemo rbDemo = new L1604_RadioButtonDemo();
	
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(rbDemo.getPane(), 400, 150);
		primaryStage.setTitle("RadioButtonDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
