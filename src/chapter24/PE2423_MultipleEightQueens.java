/**
 * 
 */
package chapter24;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 18. 2. 2015 2015 10:58:24 
 */
public class PE2423_MultipleEightQueens extends Application {

	public static final int SIZE = 8; // the size of the chessboard
	// queens are placed at (i, queens[i])
	// -1 indicates that no queen is currently placed in the ith row
	// Initially place a queen at (0, 0) int the 0th row
	private	Label[][] labels = new Label[SIZE][SIZE];

	@Override
	public void start(Stage primaryStage) {

		HBox solutions = search();
		
		ScrollPane sP = new ScrollPane(solutions);
		Scene scene = new Scene(sP, 55 * SIZE, 60 * SIZE);
		primaryStage.setTitle("EightQueens");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	/** Search for a solution */
	public HBox search() {
		int[] grid = {0, -1, -1, -1, -1, -1, -1, -1};
		ArrayList<BorderPane> panes = new ArrayList<BorderPane>();
		HBox hBox = new HBox(5);
		// Put 8 queens on the grid
		int queens = 1;	// first queen at [0][0]
		int solutions = 0;
		while (queens >= 0) {
			int position = insertQueen(grid, queens);
			if (position > - 1) {
				grid[queens] = position;
				if (queens == 7) {
					solutions++;
					panes.add(displayGrid(solutions, grid));
				} else
					queens++;
			} else {
				grid[queens] = -1;
				queens--; // to the previous row
			}
		}
		hBox.getChildren().addAll(panes);
		return hBox;
	}

	// Insert queen into the grid
	public int insertQueen(int[] grid, int row) {
		int start = grid[row] == -1 ? 0 : grid[row] + 1;
		for (int column = start; column < grid.length; column++) {
			if (freePosition(grid, row, column))
				return column;
		}
		return -1;
	}

	// Check if there is a queen in the same row, column or diagonal
	public boolean freePosition(int[] grid, int rowInput, int columnInput) {
		// Check if column is possible
		for (int i = 0; i < grid.length; i++) {
			if (columnInput == grid[i])
				return false;
		}
		// c) Major Diagonal
		// - up
		for (int i = rowInput, j = columnInput; i >= 0 && j >= 0; i--, j--) {
			if (grid[i] == j)
				return false;
		}
		// - down
		for (int i = rowInput, j = columnInput; i < grid.length && j < grid.length; i++, j++) {
			if (grid[i] == j)
				return false;
		}
		// d) Minor Diagonal
		// - up
		for (int i = rowInput, j = columnInput; i >= 0 && j < grid.length; i--, j++) {
			if (grid[i] == j)
				return false;
		}
		// - down
		for (int i = rowInput, j = columnInput; i < grid.length && j >= 0; i++, j--) {
			if (grid[i] == j)
				return false;
		}
		return true;
	}

	// Displays the grid
	public BorderPane displayGrid(int solutions, int[] grid) {

		BorderPane solution = new BorderPane();
		solution.setStyle("-fx-border-color: black");
		Label lblSolution = new Label(solutions + ". solution");
		// Display chess board
		GridPane chessBoard = new GridPane();
		chessBoard.setAlignment(Pos.CENTER);
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				chessBoard.add(labels[i][j] = new Label(), j, i);
				labels[i][j].setStyle("-fx-border-color: black");
				labels[i][j].setPrefSize(55, 55);
			}

		// Display queens
		Image image = new Image("File:C:/Java/site/image/queen.jpg");
		for (int i = 0; i < SIZE; i++) {
			labels[i][grid[i]].setGraphic(new ImageView(image));
		}
		
		solution.setTop(lblSolution);
		solution.setCenter(chessBoard);
		BorderPane.setAlignment(lblSolution, Pos.CENTER);
		return solution;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
