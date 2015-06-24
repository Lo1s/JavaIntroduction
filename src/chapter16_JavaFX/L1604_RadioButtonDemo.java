/**
 * 
 */
package chapter16_JavaFX;



import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 9:04:38 
 */
public class L1604_RadioButtonDemo extends L1603_CheckBoxDemo {
	
	@Override
	protected BorderPane getPane() {
		BorderPane pane = super.getPane();
		
		VBox paneForRadioButtons = new VBox(20);
		paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
		paneForRadioButtons.setStyle("-fx-border-color: green");
		paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color:green");
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlue = new RadioButton("Blue");
		paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
		pane.setLeft(paneForRadioButtons);
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbBlue.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		
		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});
		
		rbBlue.setOnAction(e -> {
			if (rbBlue.isSelected()) {
				text.setFill(Color.BLUE);
			}
		});
		
		return pane;
	}

}
