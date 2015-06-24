
package chapter15_JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;

/**
 * @author jslapnicka
 * @Date & @Time 5. 1. 2015 2015 15:27:32 
 */
public class L1504_AnonymousHandlerDemo extends Application {

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
		
		btNew.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process New !");
			}
		});
		
		btOpen.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process Open !");
			}
		});
		
		btSave.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process Save !");
			}
		});
		
		btPrint.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process Print !");
			}
		});
		
		Scene scene = new Scene(hBox, 300, 50);
		primaryStage.setTitle("AnonymousHandlerDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
