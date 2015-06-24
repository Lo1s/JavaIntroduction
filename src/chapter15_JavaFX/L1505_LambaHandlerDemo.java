/**
 * 
 */
package chapter15_JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 11:23:11 
 */
public class L1505_LambaHandlerDemo extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		
		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		Button btPrint = new Button("Print");
		
		hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);
		
		btNew.setOnAction((ActionEvent e) -> {
			System.out.println("Process New !");
		});
		
		btOpen.setOnAction((e) -> {
			System.out.println("Process Open !");
		});
		
		btSave.setOnAction(e -> {
			System.out.println("Process Save !");
		});
		
		btPrint.setOnAction(e -> System.out.println("Process Print !"));
		
		Scene scene = new Scene(hBox, 300, 50);
		primaryStage.setTitle("LambdaHandlerDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
