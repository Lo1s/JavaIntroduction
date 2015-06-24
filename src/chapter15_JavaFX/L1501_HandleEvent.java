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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 5. 1. 2015 2015 14:26:25 
 */
public class L1501_HandleEvent extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		HBox pane = new HBox(10);
		pane.setAlignment(Pos.CENTER);
		Button btOK = new Button("OK");
		Button btCancel = new Button("Cancel");
		OKHandlerClass handler1 = new OKHandlerClass();
		CancelHandlerClass handler2 = new CancelHandlerClass();
		btOK.setOnAction(handler1);
		btCancel.setOnAction(handler2);
		
		pane.getChildren().addAll(btOK, btCancel);
		
		Scene scene = new Scene(pane, 100, 50);
		primaryStage.setTitle("HandleEvent");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	class OKHandlerClass implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent e) {
			System.out.println("OK button clicked");
		}
	}
	
	class CancelHandlerClass implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent e) {
			System.out.println("Cancel button clicked");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
