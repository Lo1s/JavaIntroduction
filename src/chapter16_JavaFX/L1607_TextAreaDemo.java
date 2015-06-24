/**
 * 
 */
package chapter16_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 12:49:18 
 */
public class L1607_TextAreaDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		L1606_DescriptionPane descriptionPane = new L1606_DescriptionPane();
		
		descriptionPane.setTitle("Canada");
		String description = "The Canadian national flag...";
		descriptionPane.setImageView(new ImageView("File:C:/Java/site/image/ca.gif"));
		descriptionPane.setDescription(description);
		
		Scene scene = new Scene(descriptionPane, 450, 200);
		primaryStage.setTitle("TextAreaDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
