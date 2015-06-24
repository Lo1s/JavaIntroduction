/**
 * 
 */
package chapter16_JavaFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 8. 1. 2015 2015 14:20:23 
 */
public class L1609_ListViewDemo extends Application {

	private String[] flagTitles = {"Canada", "China", "Denmark",
		    "France", "Germany", "India", "Norway", "United Kingdom",
		    "United States of America"};
	
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
	
	@Override
	public void start(Stage primaryStage) {
		ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagTitles));
		lv.setPrefSize(100, 400);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		FlowPane imagePane = new FlowPane(10, 10);
		BorderPane pane = new BorderPane();
		pane.setLeft(new ScrollPane(lv));
		pane.setCenter(imagePane);
		
		lv.getSelectionModel().selectedIndexProperty().addListener(ov -> {
			imagePane.getChildren().clear();
			for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
				imagePane.getChildren().add(flagImage[i]);
			}
		});
		
		Scene scene = new Scene(pane, 550, 170);
		primaryStage.setTitle("ListViewDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
