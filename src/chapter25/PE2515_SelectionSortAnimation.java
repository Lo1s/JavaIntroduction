/**
 * 
 */
package chapter25;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 2. 7. 2015 2015 11:21:12 
 */
public class PE2515_SelectionSortAnimation extends Application {

	
	Button btnStep = new Button("Step");
	Button btnReset = new Button("Reset");
	int[] array = new int[20];
	
	public void start(Stage primaryStage) {
		Canvas canvas = new Canvas();
		btnStep.setPrefWidth(60);
		btnReset.setPrefWidth(60);
		HBox hBox = new HBox(btnStep, btnReset);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(canvas);
		borderPane.setBottom(hBox);
		
		Scene scene = new Scene(borderPane, 500, 260);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise25_15");
		primaryStage.show();
	}
	
	class Canvas extends Pane {
		Rectangle[] rectangles = new Rectangle[20];
		Text[] titles = new Text[20];
		
		public Canvas() {
			setWidth(500);
			setHeight(250);
			paintHistogram(createArray());
		}
		
		public void paintHistogram(int[] array) {
			double width = getWidth();
			double height = getHeight();
			double hGap = 0;
			for (int i = 0; i < array.length; i++) {
				rectangles[i] = new Rectangle(10 + hGap, 15 + (200 / array.length) * (array.length - array[i]), 
						((width - 20) / 20), 15 + (200 / array.length) * array[i]);
				rectangles[i].setFill(Color.WHITE);
				rectangles[i].setStroke(Color.BLACK);
				titles[i] = new Text(15 + hGap, 13 + (200 / array.length) * (array.length - array[i]), array[i] + "");
				hGap += ((width - 20) / 20);
			}
			getChildren().addAll(rectangles);
			getChildren().addAll(titles);
		}
	}
	
	public static int[] selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		return list;
	}
	
	public static int[] createArray() {
		int[] array = new int[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = 1 + (int)(Math.random() * ((20 - 1) + 1));
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();
	}

}
