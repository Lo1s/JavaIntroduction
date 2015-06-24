/**
 * 
 */
package chapter15_JavaFX;

import chapter14_JavaFX.L1421_ClockPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 17:58:05 
 */
public class L1516_ClockAnimation extends Application {

	@Override
	public void start(Stage primaryStage) {
		L1421_ClockPane clock = new L1421_ClockPane();
		
		EventHandler<ActionEvent> eventHandler = e -> {
			clock.setCurrentTime();
		};
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		Scene scene = new Scene(clock, 250, 250);
		primaryStage.setTitle("ClockAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
