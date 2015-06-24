/**
 * 
 */
package chapter15_JavaFX;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 13:16:17 
 */
public class L1507_MouseEventDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		Text text = new Text(20, 20, "Programming is fun !");
		pane.getChildren().addAll(text);
		text.setOnMouseDragged(e -> {
			text.setX(e.getX());
			text.setY(e.getY());
		});
		
		Scene scene = new Scene(pane, 300, 100);
		primaryStage.setTitle("MouseEventDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
