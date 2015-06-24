/**
 * 
 */
package chapter16_JavaFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 12:53:46 
 */
public class L1608_ComboBoxDemo extends Application {

	private String[] flagTitles = 
		{"Canada", "China", "Denmark", 
			"France", "Germany", "India", 
			"Norway", "United Kingdom", "United States of America"
			};
	
	private ImageView[] flagImage = {
			new ImageView("File:C:/Java/site/image/ca.gif"),
			new ImageView("File:C:/Java/site/image/china.gif"),
			new ImageView("File:C:/Java/site/image/denmark.gif"),
			new ImageView("File:C:/Java/site/image/fr.gif"),
			new ImageView("File:C:/Java/site/image/germany.gif"),
			new ImageView("File:C:/Java/site/image/india.gif"),
			new ImageView("File:C:/Java/site/image/norway.gif"),
			new ImageView("File:C:/Java/site/image/uk.gif"),
			new ImageView("File:C:/Java/site/image/us.gif")};
	
	private String[] flagDescription = new String[9];
	
	private L1606_DescriptionPane descriptionPane = new L1606_DescriptionPane();
	
	private ComboBox<String> cbo = new ComboBox<String>();
	
	@Override
	public void start(Stage primaryStage) {
		flagDescription[0] = "Canada..............";
		flagDescription[1] = "China...............";
		flagDescription[2] = "Denmark.............";
		flagDescription[3] = "France..............";
		flagDescription[4] = "Germany.............";
		flagDescription[5] = "India...............";
		flagDescription[6] = "Norway..............";
		flagDescription[7] = "UK..................";
		flagDescription[8] = "US..................";
		
		setDisplay(0);
		
		BorderPane pane = new BorderPane();
		
		BorderPane paneForComboBox = new BorderPane();
		paneForComboBox.setLeft(new Label("Select a country: "));
		paneForComboBox.setCenter(cbo);
		pane.setTop(paneForComboBox);
		
		cbo.prefWidth(400);
		cbo.setValue("Canada");
		
		ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
		cbo.getItems().addAll(items);
		pane.setCenter(descriptionPane);
		
		cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));
		
		Scene scene = new Scene(pane, 450, 170);
		primaryStage.setTitle("ComboBoxDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void setDisplay(int index) {
		descriptionPane.setTitle(flagTitles[index]);
		descriptionPane.setImageView(flagImage[index]);
		descriptionPane.setDescription(flagDescription[index]);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
