/**
 * 
 */
package chapter15_JavaFX;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 15:01:23 
 */
public class L1509_ControlCircleWithMouseAndKey extends Application {
	
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
		btEnlarge.setOnAction(e -> circlePane.enlarge());
		btShrink.setOnAction(e -> circlePane.shrink());
		circlePane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				circlePane.enlarge();				
			} else if (e.getButton() == MouseButton.SECONDARY) {
				circlePane.shrink();
			}
		});
		
		circlePane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.U) {
				circlePane.enlarge();
			} else if (e.getCode() == KeyCode.D) {
				circlePane.shrink();
			}
		});
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);

		Scene scene = new Scene(borderPane, 200, 150);
		primaryStage.setTitle("ControlCircle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		circlePane.requestFocus();
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
			requestFocus();
		}
		
		public void shrink() {
			circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
			requestFocus();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
