/**
 * 
 */
package chapter15_JavaFX;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 17:46:16 
 */
public class L1515_TimelineDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		Text text = new Text(20, 50, "Programming is fun !");
		text.setFill(Color.RED);
		pane.getChildren().add(text);
		
		// Create a handler for changing text
		EventHandler<ActionEvent> eventHandler = e -> {
			if (text.getText().length() != 0) {
				text.setText("");
			} else {
				text.setText("Programming is fun !");
			}
		};
		
		// Create an animation for alternating text
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		text.setOnMouseClicked(e -> {
			if (animation.getStatus() == Animation.Status.PAUSED) {
				animation.play();
			} else {
				animation.pause();
			}
		});
		
		Scene scene = new Scene(pane, 250, 100);
		primaryStage.setTitle("TimelineDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
