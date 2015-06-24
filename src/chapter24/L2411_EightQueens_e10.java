/**
 * 
 */
package chapter24;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 22. 1. 2015 2015 15:36:47 
 */
public class L2411_EightQueens_e10 extends Application {

	public static final int SIZE = 8; // the size of the chessboard
	// queens are placed at (i, queens[i])
	// -1 indicates that no queen is currently placed in the ith row
	// Initially place a queen at (0,0) int the 0th row
	private int[] queens = {-1, -1, -1, -1, -1, -1, -1, -1};
	
	@Override
	public void start(Stage primaryStage) {
		search();
		
		// Display chess board
		GridPane chessBoard = new GridPane();
		chessBoard.setAlignment(Pos.CENTER);
		Label[][] labels = new Label[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				chessBoard.add(labels[i][j] = new Label(), j, i);
				labels[i][j].setStyle("-fx-border-color: black");
				labels[i][j].setPrefSize(55, 55);
			}
		
		// Display queens
		Image image = new Image("File:C:/Java/site/image/queen.jpg");
		for (int i = 0; i < SIZE; i++) {
			labels[i][queens[i]].setGraphic(new ImageView(image));
		}
		
		Scene scene = new Scene(chessBoard, 55 * SIZE, 55 * SIZE);
		primaryStage.setTitle("EightQueens");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/** Search for a solution */
	private boolean search() {
		// k - 1 indicates the number of queens placed so far
		// We are looking for a position in the kth row to place a queen
		int k = 0;
		while (k >= 0 && k < SIZE) {
			// Find a position to place a queen in the kth row
			int j = findPosition(k);
			if (j < 0) {
				queens[k] = -1;
				k--; // back track to the previous row
			} else {
				queens[k] = j;
				k++;
			}
		}
		
		if (k == -1)
			return false; // no solution
		else
			return true; // a solution is found
	}
	
	public int findPosition(int k) {
		int start = queens[k] + 1; // search for a new element
		
		for (int j = start; j < SIZE; j++) {
			if (isValid(k, j))
				return j; // (k, j) is the place to put the queen now
		}
		
		return -1;
	}
	
	/** Return true if a queen can be placed at (row, column) */
	public boolean isValid(int row, int column) {
		for (int i = 1; i <= row; i++)
			if (queens[row - i] == column // check column
			|| queens[row - i] == column - i // check upleft diagonal
			|| queens[row - i] == column + i) // check upright diagonal
				return false;
		return true; // no conflict
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
