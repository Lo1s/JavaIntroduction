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
import javafx.scene.shape.Line;
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
	Canvas<Integer> canvas = new Canvas<Integer>();

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
		btnRemoveRoot.setOnAction((ActionEvent e) -> {
			canvas.remove();
		});

		BorderPane pane = new BorderPane();
		pane.setCenter(canvas);
		pane.setBottom(tools);

		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise23_10");
		primaryStage.show();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	class Canvas<E extends Comparable<E>> extends Pane {
		ArrayList<E> list = new ArrayList<E>();
		ArrayList<Circle> circles = new ArrayList<Circle>();
		ArrayList<Text> titles = new ArrayList<Text>();
		ArrayList<Line> lines = new ArrayList<Line>();

		public Canvas() {
			// TODO Auto-generated constructor stub
		}

		public E remove() {
			if (list.size() == 0) return null;

			E removedObject = list.get(0);
			list.set(0, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			circles.set(0, circles.get(circles.size() - 1));
			circles.remove(circles.size() - 1);
			titles.set(0, titles.get(titles.size() - 1));
			titles.remove(titles.size() - 1);
			if (lines.size() != 0)
				lines.remove(lines.size() - 1);

			int currentIndex = 0;
			while (currentIndex < list.size()) {
				int leftChildIndex = 2 * currentIndex + 1;
				int rightChildIndex = 2 * currentIndex + 2;

				// Find the maximum between two children
				if (leftChildIndex >= list.size()) break; // The tree is a heap
				int maxIndex = leftChildIndex;
				if (rightChildIndex < list.size()) {
					if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
						maxIndex = rightChildIndex;
					}
				}

				// Swap if the current node is less than maximum
				if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
					E temp = list.get(maxIndex);
					Circle tempCircle = circles.get(maxIndex);
					Text tempText = titles.get(maxIndex);
					list.set(maxIndex, list.get(currentIndex));
					list.set(currentIndex, temp);
					circles.set(maxIndex, circles.get(currentIndex));
					circles.set(currentIndex, tempCircle);
					titles.set(maxIndex, titles.get(currentIndex));
					titles.set(currentIndex, tempText);
					currentIndex = maxIndex;
				} else {
					break; // The tree is a heap
				}
			}
			repaint();
			return removedObject;
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
			if (lines.size() != 0)
				lines.clear();
			
			int index = 0;
			double distance = getWidth();
			for (int i = 0; i < circles.size(); i++) {
				circles.get(i).setFill(Color.WHEAT);
				circles.get(i).setStroke(Color.BLACK);
				// Get the location of the leftmost node for calc distance
				if (i == (int)(Math.pow(2, index) - 1)) {
					index++;
					distance = distance / 2;
				}
				if (i < 1) {
					circles.get(i).setCenterX(distance);
					circles.get(i).setCenterY(30);
					titles.get(i).setX(circles.get(i).getCenterX() - 3);
					titles.get(i).setY(circles.get(i).getCenterY() + 3);
				} else if (i % 2 != 0) {
					goLeft(i, distance);
					connect(i);
				} else if (i % 2 == 0) {
					goRight(i, distance);
					connect(i);
				}
				getChildren().clear();
				getChildren().addAll(lines);
				getChildren().addAll(circles);
				getChildren().addAll(titles);

			}
		}

		public void goLeft(int i, double hGap) {
			circles.get(i).setCenterX(circles.get((i - 1) / 2).getCenterX() - hGap);
			circles.get(i).setCenterY(circles.get((i - 1) / 2).getCenterY() + 50);
			titles.get(i).setX(titles.get((i - 1) / 2).getX() - hGap);
			titles.get(i).setY(titles.get((i - 1) / 2).getY() + 50);
		}

		public void goRight(int i, double hGap) {
			circles.get(i).setCenterX(circles.get((i - 1) / 2).getCenterX() + hGap);
			circles.get(i).setCenterY(circles.get((i - 1) / 2).getCenterY() + 50);
			titles.get(i).setX(titles.get((i - 1) / 2).getX() + hGap);
			titles.get(i).setY(titles.get((i - 1) / 2).getY() + 50);
		}

		public void connect(int i) {
			System.out.println(lines.size());
			double parentX = circles.get((i - 1) / 2).getCenterX();
			double parentY = circles.get((i - 1) / 2).getCenterY();
			double childX = circles.get(i).getCenterX();
			double childY = circles.get(i).getCenterY();

			lines.add(new Line(parentX, parentY, childX, childY));

		}
	}

}
