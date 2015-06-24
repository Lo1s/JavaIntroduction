/**
 * 
 */
package chapter15_JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 5. 1. 2015 2015 14:45:44 
 */
public class L1503_ControlCircle extends L1502_ControlCircleWithoutEventHandling {

	private CirclePane circlePane = new CirclePane();
	
	@Override
	public void start(Stage primaryStage) {

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btEnlarge = new Button("Enlarge");
		Button btShrink = new Button("Shrink");
		hBox.getChildren().addAll(btEnlarge, btShrink);

		// Create and register the handler
		btEnlarge.setOnAction(new EnlargeHandler());
		btShrink.setOnAction(new ShrinkHandler());
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);

		Scene scene = new Scene(borderPane, 200, 150);
		primaryStage.setTitle("ControlCircle");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

	class EnlargeHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			circlePane.enlarge();
		}
	}
	
	class ShrinkHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent e) {
			circlePane.shrink();
		}
	}

	class CirclePane extends StackPane {
		private Circle circle = new Circle(50);

		public CirclePane() {
			// TODO Auto-generated constructor stub
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
			getChildren().add(circle);
		}
		
		public void enlarge() {
			circle.setRadius(circle.getRadius() + 2);
		}
		
		public void shrink() {
			circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
