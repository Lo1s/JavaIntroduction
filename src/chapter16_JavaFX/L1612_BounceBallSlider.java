/**
 * 
 */
package chapter16_JavaFX;

import chapter15_JavaFX.L1517_BallPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 14:52:30 
 */
public class L1612_BounceBallSlider extends Application {

	@Override
	public void start(Stage primaryStage) {
		L1517_BallPane ballPane = new L1517_BallPane();
		Slider slSpeed = new Slider();
		slSpeed.setMax(20);
		ballPane.rateProperty().bind(slSpeed.valueProperty());
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setBottom(slSpeed);
		
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("BounceBallSlider");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
