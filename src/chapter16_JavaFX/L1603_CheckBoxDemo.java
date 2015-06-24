/**
 * 
 */
package chapter16_JavaFX;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author jslapnicka
 * @Date & @Time 7. 1. 2015 2015 11:30:51 
 */
public class L1603_CheckBoxDemo extends L1602_ButtonDemo {
	
	@Override
	protected BorderPane getPane() {
		BorderPane pane = super.getPane();
		
		Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
		Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
		Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
		Font fontNormal = Font.font("Timmes New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
		
		text.setFont(fontNormal);
		VBox paneForCheckBoxes = new VBox(20);
		paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));
		paneForCheckBoxes.setStyle("-fx-border-color: green");
		CheckBox chkBold = new CheckBox("Bold");
		CheckBox chkItalic = new CheckBox("Italic");
		paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
		pane.setRight(paneForCheckBoxes);
		
		EventHandler<ActionEvent> handler = e -> {
			if (chkBold.isSelected() && chkItalic.isSelected()) {
				text.setFont(fontBoldItalic);
			} else if (chkBold.isSelected()) {
				text.setFont(fontBold);
			} else if (chkItalic.isSelected()) {
				text.setFont(fontItalic);
			} else {
				text.setFont(fontNormal);
			}
		};
		
		chkBold.setOnAction(handler);
		chkItalic.setOnAction(handler);
		
		return pane;
	}
		
}
