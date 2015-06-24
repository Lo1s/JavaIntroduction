/**
 * 
 */
package chapter14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 15:35:31 
 */
public class L1414_ShowText extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		pane.setPadding(new Insets(5, 5, 5, 5));
		Text text1 = new Text(20, 20, "Programming is fun !");
		text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 20));
		Text text2 = new Text(60, 60, "Programming is fun\nDisplay text");
		Text text3 = new Text(10, 100, "Programming is fun \nDisplay text");
		text3.setFill(Color.RED);
		text3.setUnderline(true);
		text3.setStrikethrough(true);
		pane.getChildren().addAll(text1, text2, text3);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowText");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
