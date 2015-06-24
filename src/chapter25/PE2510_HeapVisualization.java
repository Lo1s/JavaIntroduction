/**
 * 
 */
package chapter25;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 23. 6. 2015 2015 10:33:23 
 */
public class PE2510_HeapVisualization extends Application {

	Label lblKey = new Label("Enter a key: ");
	TextField tfKey = new TextField();
	Button btnInsert = new Button("Insert");
	Button btnRemoveRoot = new Button("Remove the root");
	Canvas canvas = new Canvas();

	public void start(Stage primaryStage) {
		// Default properties
		tfKey.setMaxWidth(50);

		HBox tools = new HBox(2);
		tools.getChildren().addAll(lblKey, tfKey, btnInsert, btnRemoveRoot);
		tools.setAlignment(Pos.CENTER);

		// Listeners for buttons
		btnInsert.setOnAction((ActionEvent e) -> {
			canvas.add(Integer.parseInt(tfKey.getText()));
		});

		BorderPane pane = new BorderPane();
		pane.setCenter(canvas);
		pane.setBottom(tools);

		Scene scene = new Scene(pane, 500, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise23_10");
		primaryStage.show();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	class Canvas<E extends Comparable<E>> extends Pane {
		L2509_Heap<E> heap = new L2509_Heap<E>();
		ArrayList<E> list = new ArrayList<E>();
		ArrayList<Circle> circles = new ArrayList<Circle>();
		ArrayList<Text> titles = new ArrayList<Text>();
		
		public Canvas() {
			// TODO Auto-generated constructor stub
		}

		public void add(E value) {
			// Heap + UI
			list.add(value); // Append to the heap
			circles.add(new Circle(20));
			titles.add(new Text(value.toString()));
			int currentIndex = list.size() - 1; // The index of the last node
			
			while (currentIndex > 0) {
				int parentIndex = (currentIndex - 1) / 2;
				// Swap if the current object is greater than its parent
				if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
					E temp = list.get(currentIndex);
					list.set(currentIndex, list.get(parentIndex));
					list.set(parentIndex, temp);
					Circle tempCircle = circles.get(currentIndex);
					circles.set(currentIndex, circles.get(parentIndex));
					circles.set(parentIndex, tempCircle);
					Text tempText = titles.get(currentIndex);
					titles.set(currentIndex, titles.get(parentIndex));
					titles.set(parentIndex, tempText);
				} else {
					break; // The tree is a heap now
				}
				
				currentIndex = parentIndex;
			}
			
			repaint();
		}

		public void repaint() {
			for (int i = 0; i < circles.size(); i++) {
				circles.get(i).setFill(Color.WHEAT);
				circles.get(i).setStroke(Color.BLACK);
				if (i < 1) {
					circles.get(i).setCenterX(getWidth() / 2);
					circles.get(i).setCenterY(30);
					titles.get(i).setX(circles.get(i).getCenterX() - 3);
					titles.get(i).setY(circles.get(i).getCenterY() + 3);
				} else if (i % 2 != 0) {
					goLeft(i);
				} else if (i % 2 == 0) {
					goRight(i);
				}
				getChildren().clear();
				getChildren().addAll(circles);
				getChildren().addAll(titles);
			}
		}
		
		public void goLeft(int i) {
			circles.get(i).setCenterX(circles.get(i - 1).getCenterX() / 2);
			circles.get(i).setCenterY(circles.get(i - 1).getCenterY() + 50);
			titles.get(i).setX(titles.get(i - 1).getX() / 2);
			titles.get(i).setY(titles.get(i - 1).getY() + 50);
		}
		
		public void goRight(int i) {
			circles.get(i).setCenterX(circles.get(i - 1).getCenterX() + (circles.get(i - 1).getCenterX() / 2));
			circles.get(i).setCenterY(circles.get(i - 1).getCenterY() + (circles.get(i - 1).getCenterY() + 50));
			titles.get(i).setX(titles.get(i - 1).getX() + (titles.get(i - 1).getX() / 2));
			titles.get(i).setY(titles.get(i - 1).getY() + (titles.get(i - 1).getY() + 50));
		}
	}

}
