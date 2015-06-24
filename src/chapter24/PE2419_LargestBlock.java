/**
 * 
 */
package chapter24;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 4. 2. 2015 2015 14:15:14 
 */
public class PE2419_LargestBlock extends Application {

	private Button btRefresh = new Button("Refresh");
	private Button btFindLargestBlock = new Button("Find Largest Block");
	private TextField[][] tfArray = new TextField[10][10];

	private GridPane gridPane = new GridPane();
	private int[][] matrix = new int[10][10];
	private int[] result;

	@Override
	public void start(Stage primaryStage) {
		// Initiate the text fields
		gridPane.setAlignment(Pos.CENTER);
		refresh();

		FlowPane toolBar = new FlowPane();
		toolBar.getChildren().addAll(btRefresh, btFindLargestBlock);
		toolBar.setHgap(10);
		toolBar.setAlignment(Pos.CENTER);

		BorderPane pane = new BorderPane();
		pane.setCenter(gridPane);
		pane.setBottom(toolBar);
		BorderPane.setAlignment(toolBar, Pos.TOP_CENTER);

		// Register listeners
		btRefresh.setOnAction(e -> {
			refresh();
		});

		btFindLargestBlock.setOnAction(e -> {
			result = findLargest(matrix);
			for(int i = result[0]; i < result[0] + result[2]; i++) {
                for(int j = result[1]; j < result[1] + result[2]; j++) {
                    tfArray[i][j].setStyle("-fx-background-color: red; -fx-border-color: black");
                }

            }
		});

		Scene scene = new Scene(pane, 270, 295);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise24_19");
		primaryStage.show();
	}

	public static int[] findLargest(int m[][]) {
        int max = 0;
        int maxOfx = 0;
        int maxOfy = 0;
        int count[][] = new int[m.length][m.length];
        for(int i = m.length - 1; i >= 0; i--) {
            for(int j = m[i].length - 1; j >= 0; j--) {
                if(m[i][j] == 1 && i < m.length - 1 && j < m[i].length - 1) {
                    count[i][j] = 1 + Math.min(Math.min(count[i + 1][j + 1], count[i + 1][j]), count[i][j + 1]);
                    if(count[i][j] > max) {
                        max = count[i][j];
                        maxOfx = i;
                        maxOfy = j;
                    }
                }
            }

        }

        int result[] = new int[3];
        result[0] = maxOfx;
        result[1] = maxOfy;
        result[2] = max;
        return result;
    }

	public void refresh() {
		for (int row = 0; row < tfArray.length; row++) {
			for (int column = 0; column < tfArray[row].length; column++) {
				tfArray[row][column] = new TextField(0 + (int)(Math.random() * (1 - 0 + 1)) + "");
				tfArray[row][column].setPrefSize(30, 1);
				tfArray[row][column].setAlignment(Pos.CENTER);
				tfArray[row][column].setStyle("-fx-background-color: white; -fx-border-color: black");
				gridPane.add(tfArray[row][column], column, row);
				matrix[row][column] = Integer.parseInt(tfArray[row][column].getText());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
