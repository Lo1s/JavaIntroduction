/**
 * 
 */
package chapter15_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 7. 1. 2015 2015 8:12:56 
 */
public class L1518_BounceBallControl extends Application {

	@Override
	public void start(Stage primaryStage) {
		L1517_BallPane ballPane = new L1517_BallPane();
		
		// Pause and resume the animation
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		
		// Increase and decrease animation
		ballPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				ballPane.increaseSpeed();
			} 
			else if (e.getCode() == KeyCode.DOWN) {
				ballPane.decreaseSpeed();
			}
		});
		
		Scene scene = new Scene(ballPane, 250, 150);
		primaryStage.setTitle("BounceBallControl");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Must request focus after the primary stage is displayed
		ballPane.requestFocus();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
