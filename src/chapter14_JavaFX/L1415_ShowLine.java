/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 15:42:14 
 */
public class L1415_ShowLine extends Application {

	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(new LinePane(), 200, 200);
		primaryStage.setTitle("ShowLine");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	class LinePane extends Pane {
		
		public LinePane() {
			// TODO Auto-generated constructor stub
			Line line1 = new Line(10, 10, 10, 10);
			line1.endXProperty().bind(widthProperty().subtract(10));
			line1.endYProperty().bind(heightProperty().subtract(10));
			line1.setStrokeWidth(5);
			line1.setStroke(Color.GREEN);
			getChildren().add(line1);
			
			Line line2 = new Line(10, 10, 10, 10);
			line2.startXProperty().bind(widthProperty().subtract(10));
			line2.endYProperty().bind(heightProperty().subtract(10));
			line2.setStrokeWidth(5);
			line2.setStroke(Color.RED);
			getChildren().add(line2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
