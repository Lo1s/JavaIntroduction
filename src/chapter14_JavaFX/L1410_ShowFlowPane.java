/**
 * 
 */
package chapter14_JavaFX;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 1. 2015 2015 13:14:19 
 */
public class L1410_ShowFlowPane extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setHgap(5);
		pane.setVgap(5);
		
		pane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI: "));
		TextField tfMI = new TextField();
		tfMI.setPrefColumnCount(1);
		pane.getChildren().addAll(tfMI, new Label("Last Name:"), new TextField());
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowFlowPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
