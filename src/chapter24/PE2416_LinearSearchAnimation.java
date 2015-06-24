/**
 * 
 */
package chapter24;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 3. 2. 2015 2015 8:54:33 
 */
public class PE2416_LinearSearchAnimation extends Application {

	private Label lblStatus = new Label();
	
	private Pane paneCanvas = new Pane();
	
	private Label lblkey = new Label("Key (in double):");
	private TextField tfKey = new TextField();
	private Button btStep = new Button("Step");
	private Button btReset = new Button("Reset");
	
	// Data field
	private final int NUMBER_OF_BARS = 20;
	private int[] numbers = new int[NUMBER_OF_BARS];
	private	Rectangle[] rectangles = new Rectangle[NUMBER_OF_BARS];
	private ObservableList<Node> nodes;
	
	@Override
	public void start(Stage primaryStage) {
		// Create UI
		/** Set up properties */
		tfKey.setPrefSize(190, 2);
		paneCanvas.setPrefSize(400, 150);
		paneCanvas.setStyle("-fx-border-color: black");
		nodes = paneCanvas.getChildren();
		
		/** Draw bars */
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		createHistogram();
		
		/** Set up status label */
		lblStatus.setText("Enter a key for the linear search");
		
		/** Toolbar */
		FlowPane paneToolbar = new FlowPane();
		paneToolbar.setAlignment(Pos.CENTER);
		paneToolbar.getChildren().addAll(lblkey, tfKey, btStep, btReset);
		paneToolbar.setHgap(5);
		paneToolbar.setPadding(new Insets(5, 0, 5, 0));
		
		/** Register listeners */
		btStep.setOnAction(e -> {
			tfKey.setEditable(false);
			int index = linearSearch(numbers, Integer.parseInt(tfKey.getText()));
			
			if (index == -1)
				lblStatus.setText("The key is not in the array");
			else {
				lblStatus.setText("The key is found in the array at index " + index);
				rectangles[index].setFill(Color.BLUEVIOLET);
			}
		});
		
		btReset.setOnAction(e -> {
			nodes.clear();
			createHistogram();
			tfKey.setEditable(true);
			tfKey.setText("");
			lblStatus.setText("Enter a key for the linear search");
		});
		
		/** Final pop-up window */
		BorderPane pane = new BorderPane();
		pane.setTop(lblStatus);
		pane.setCenter(paneCanvas);
		pane.setBottom(paneToolbar);
		BorderPane.setAlignment(lblStatus, Pos.CENTER);
		
		Scene scene = new Scene(pane, 400, 222);
		primaryStage.setTitle("Exercise24_16");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void createHistogram() {
		shuffle(numbers);
		for (int i = 0; i < NUMBER_OF_BARS; i++) {
			rectangles[i] = new Rectangle(i * 20, 25 +  (130 / NUMBER_OF_BARS) * (NUMBER_OF_BARS - numbers[i]), 
					20, 25 +  (130 / NUMBER_OF_BARS) * numbers[i]);
			rectangles[i].setStroke(Color.BLACK);
			rectangles[i].setFill(Color.CHARTREUSE);
			paneCanvas.getChildren().add(rectangles[i]);
			paneCanvas.getChildren().add(new Text(i * 20 + 5, 20 +  (130 / NUMBER_OF_BARS) * (NUMBER_OF_BARS - numbers[i]), numbers[i] + ""));
		}
	}
	
	public void shuffle(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			int random = 1 + (int)(Math.random() * (NUMBER_OF_BARS - 1) + 1);
			temp = array[i];
			array[i] = array[random - 1];
			array[random - 1] = temp;
		}
	}
	
	public static int linearSearch(int[] array, double key) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (key == array[i])
				index = i;
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
