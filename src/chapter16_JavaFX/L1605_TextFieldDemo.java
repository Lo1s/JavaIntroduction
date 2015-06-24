/**
 * 
 */
package chapter16_JavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 9:24:11 
 */
public class L1605_TextFieldDemo extends L1604_RadioButtonDemo {

	@Override
	protected BorderPane getPane() {
		BorderPane pane = super.getPane();
		
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setStyle("-fx-border-color: green");
		paneForTextField.setLeft(new Label("Enter a new message: "));
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);
		pane.setTop(paneForTextField);
		
		tf.setOnAction(e -> text.setText(tf.getText()));
		
		return pane;
	}
	
}
