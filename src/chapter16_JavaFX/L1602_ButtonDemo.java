/**
 * 
 */
package chapter16_JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 7. 1. 2015 2015 11:15:08 
 */
public class L1602_ButtonDemo extends Application {

	protected Text text = new Text(50, 50, "JavaFX Programming");
	
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(getPane(), 450, 200);
		primaryStage.setTitle("ButtonDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	protected BorderPane getPane() {
		HBox paneForButtons = new HBox(20);
		Button btLeft = new Button("Left", new ImageView("File:C:/Java/site/image/left.gif"));
		Button btRight = new Button("Right", new ImageView("File:C:/Java/site/image/right.gif"));
		paneForButtons.getChildren().addAll(btLeft, btRight);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: blue");
		
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		
		btLeft.setOnAction(e -> text.setX(text.getX() - 10));
		btRight.setOnAction(e -> text.setX(text.getX() + 10));
		
		return pane;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
