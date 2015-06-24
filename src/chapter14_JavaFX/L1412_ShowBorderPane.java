/**
 * 
 */
package chapter14_JavaFX;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 14:29:57 
 */
public class L1412_ShowBorderPane extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		pane.setTop(new CustomPane("Top"));
		pane.setLeft(new CustomPane("Left"));
		pane.setRight(new CustomPane("Right"));
		pane.setBottom(new CustomPane("Bottom"));
		pane.setCenter(new CustomPane("Center"));
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowBorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	class CustomPane extends StackPane {
		
		public CustomPane(String title) {
			getChildren().add(new Label(title));
			setStyle("-fx-border-color: red");
			setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
