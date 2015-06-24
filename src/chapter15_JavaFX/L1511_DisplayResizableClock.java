/**
 * 
 */
package chapter15_JavaFX;

import chapter14_JavaFX.L1421_ClockPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 15:23:54 
 */
public class L1511_DisplayResizableClock extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		L1421_ClockPane clock = new L1421_ClockPane();
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("DisplayClock");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		pane.widthProperty().addListener(ov -> clock.setW(pane.getWidth()));
		pane.heightProperty().addListener(ov -> clock.setH(pane.getHeight()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
