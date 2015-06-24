/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 6. 2. 2015 2015 16:16:24 
 */
public class PE2425_Sudoku extends Application {

	private Button btSolve = new Button("Solve");
	private Button btClear = new Button("Clear");
	private Button btRead = new Button("Read");
	private Button btDisplay = new Button("Display");
	private Button btValid = new Button("Validate");
	private Button btRefresh = new Button("Refresh");
	private Button btNext = new Button("Next");

	private Label lblStatus = new Label("");
	private TextField[][] tfArray = new TextField[9][9];
	private ArrayList<int[]> freeCellList = new ArrayList<int[]>();
	private ArrayList<int[]> filledCellList = new ArrayList<int[]>();
	private GridPane gridPane = new GridPane();
	private GridPane block1 = new GridPane();
	private GridPane block2 = new GridPane();
	private GridPane block3 = new GridPane();
	private GridPane block4 = new GridPane();
	private GridPane block5 = new GridPane();
	private GridPane block6 = new GridPane();
	private GridPane block7 = new GridPane();
	private GridPane block8	= new GridPane();
	private GridPane block9 = new GridPane();
	private ArrayList<int[][]> solutions = new ArrayList<int[][]>();
	private int[][] grid = new int[9][9];
	private int nextCounter = 0;
	private int count = 0;

	@Override
	public void start(Stage primaryStage) {
		// Set up preferences for the nodes
		lblStatus.setStyle("-fx-text-fill: red; -fx-font-weight: bold"); 
		btClear.setPrefWidth(59);
		btDisplay.setPrefWidth(59);
		btRead.setPrefWidth(59);
		btRefresh.setPrefWidth(59);
		btSolve.setPrefWidth(59);
		btValid.setPrefWidth(59);

		refresh();		
		GridPane toolBar = new GridPane();
		toolBar.add(btRead, 0, 0);
		toolBar.add(btRefresh, 1, 0);
		toolBar.add(btDisplay, 2, 0);
		toolBar.add(btSolve, 0, 1);
		toolBar.add(btValid, 1, 1);
		toolBar.add(btClear, 2, 1);
		toolBar.setAlignment(Pos.CENTER);

		BorderPane pane = new BorderPane();
		pane.setTop(lblStatus);
		pane.setCenter(gridPane);
		pane.setBottom(toolBar);
		BorderPane.setAlignment(lblStatus, Pos.CENTER);
		// Register listeners
		btRefresh.setOnAction(e -> {
			for (int i = 0; i < tfArray.length; i++) {
				for (int j = 0; j < tfArray[i].length; j++) {
					if (tfArray[i][j].getText().equals(""))
						grid[i][j] = 0;
					else
						grid[i][j] = Integer.parseInt(tfArray[i][j].getText());
				}
			}
			displayGrid();
		});
		btSolve.setOnAction(e -> {
			count = search(grid);
			System.out.println("Total number of solutions:  " + count);
			if (count == 0) 
				lblStatus.setText("No solution found !");
			else {
				nextCounter++;
				lblStatus.setText(nextCounter + "/" + count + " solutions");
				toolBar.setAlignment(Pos.CENTER_LEFT);
				toolBar.add(btNext, 3, 0);
			}
		});

		btNext.setOnAction(e -> {
			nextCounter++;
			lblStatus.setText(nextCounter + "/" + count + " solutions");
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					 grid[i][j] = solutions.get(nextCounter)[i][j];
				}
			}
			displayGrid();
		});

		btRead.setOnAction(e -> {
			readAPuzzle();
		});

		btDisplay.setOnAction(e -> {
			displayGrid();
		});

		btValid.setOnAction(e -> {
			if (isValid(grid)) {
				lblStatus.setText("Solution is valid so far !");
			} else {
				lblStatus.setText("Invalid input !");
			}
		});
		btClear.setOnAction(e -> {
			nextCounter = 0;
			count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					tfArray[i][j].setStyle("-fx-text-fill: black; -fx-font-weight: normal");
					tfArray[i][j].setText("");
					grid[i][j] = 0;
					lblStatus.setText("");
				}
			}
			toolBar.setAlignment(Pos.CENTER);
			toolBar.getChildren().clear();
			toolBar.add(btRead, 0, 0);
			toolBar.add(btRefresh, 1, 0);
			toolBar.add(btDisplay, 2, 0);
			toolBar.add(btSolve, 0, 1);
			toolBar.add(btValid, 1, 1);
			toolBar.add(btClear, 2, 1);
		});

		Scene scene = new Scene(pane, 250, 300);
		primaryStage.setTitle("Exercise24_20");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

	// Get the free cells
	public void getFreeCells() {
		// Fill up the list with free cells
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					freeCellList.add(new int[] {i, j});
					tfArray[i][j].setStyle("-fx-text-fill: green"); 
				}
			}
		}
	}

	// Search for a solution
	public int search(int[][] grid) {
		// Fill up the list with free cells
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					freeCellList.add(new int[] {i, j});
					tfArray[i][j].setStyle("-fx-text-fill: green"); 
				}
			}
		}

		// Search through free cells
		int k = 0; // Start from the first cell
		int count = 0;
		boolean done = false;
		while (!done) {
			int i = freeCellList.get(k)[0];
			int j = freeCellList.get(k)[1];
			if (grid[i][j] == 0)
				grid[i][j] = 1; // Fill the free cell with number 1

			if (isValid(i, j, grid)) {
				if (k + 1 == freeCellList.size()) { // No more free cells
					count++; // A solution is found
					int[][] saveSolution = new int [9][9];
					for (int row = 0; row < grid.length; row++) {
						for (int column = 0; column < grid[row].length; column++) {
							saveSolution[row][column] = grid[row][column];
						}
					}
					solutions.add(saveSolution);
					if (count == 1) {
						System.out.println("**** " + count + ". solution ****");
						displayGrid();
						printSolution();
					}
					// Now search for the next possible solution
					if (grid[i][j] < 9) {
						grid[i][j] = grid[i][j] + 1; // Check the next possible value
					} else {
						while (grid[i][j] == 9) {
							grid[i][j] = 0; // Reset to free cell
							if (k == 0) {
								done = true;
								return count;
							}
							k--; // Backtrack
							i = freeCellList.get(k)[0];
							j = freeCellList.get(k)[1];
						}

						grid[i][j]++;
					}

				} else
					k++; // Move to the next free cell
			} else if (grid[i][j] < 9){
				// Fill the free cell with the next possible value
				grid[i][j]++;
			} else  { // Free cell grid[i][j] is 9, backtrack
				while (grid[i][j] == 9) {
					if (k == 0)
						return count; // No possible value
					grid[i][j] = 0; // Reset to free cell
					k--; // Backtrack to the preceding free cell
					i = freeCellList.get(k)[0];
					j = freeCellList.get(k)[1];
				}

				// Fill the free cell with the next possible value,
				// search continues from this free cell at k
				grid[i][j]++;
			}
		} 

		return count; // A solution is found
	}

	public void printSolution() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}


	public void refresh() {
		for (int row = 0; row < tfArray.length; row++) {
			for (int column = 0; column < tfArray[row].length; column++) {
				tfArray[row][column] = new TextField("");
				tfArray[row][column].setPrefSize(30, 1);
				tfArray[row][column].setAlignment(Pos.CENTER);
				if (row < 3 && column < 3)
					block1.add(tfArray[row][column], column, row);
				else if (row < 3 && column >= 3 && column < 6)
					block2.add(tfArray[row][column], column, row);
				else if (row < 3 && column >= 6 && column < 9)
					block3.add(tfArray[row][column], column, row);
				else if (row >= 3 && row < 6 && column < 3)
					block4.add(tfArray[row][column], column, row);
				else if (row >= 3 && row < 6 && column >= 3 && column < 6)
					block5.add(tfArray[row][column], column, row);
				else if (row >= 3 && row < 6 && column >= 6 && column < 9)
					block6.add(tfArray[row][column], column, row);
				else if (row >= 6 && row < 9 && column < 3)
					block7.add(tfArray[row][column], column, row);
				else if (row >= 6 && row < 9 && column >= 3 && column < 6)
					block8.add(tfArray[row][column], column, row);
				else if (row >= 6 && row < 9 && column >= 6 && column < 9)
					block9.add(tfArray[row][column], column, row);
				if (tfArray[row][column].getText().equals(""))
					grid[row][column] = 0;
				else {
					grid[row][column] = Integer.parseInt(tfArray[row][column].getText());
					filledCellList.add(new int[] {row, column});
				}

			}
		}
		block1.setStyle("-fx-border-color: black");
		block2.setStyle("-fx-border-color: black");
		block3.setStyle("-fx-border-color: black");
		block4.setStyle("-fx-border-color: black");
		block5.setStyle("-fx-border-color: black");
		block6.setStyle("-fx-border-color: black");
		block7.setStyle("-fx-border-color: black");
		block8.setStyle("-fx-border-color: black");
		block9.setStyle("-fx-border-color: black");
		gridPane.add(block1, 0, 0);
		gridPane.add(block2, 1, 0);
		gridPane.add(block3, 2, 0);
		gridPane.add(block4, 0, 1);
		gridPane.add(block5, 1, 1);
		gridPane.add(block6, 2, 1);
		gridPane.add(block7, 0, 2);
		gridPane.add(block8, 1, 2);
		gridPane.add(block9, 2, 2);
	}

	public void displayGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] > 0) {
					tfArray[i][j].setText(grid[i][j] + "");
				}
			}
		}
	}

	@SuppressWarnings("resource")
	public void readAPuzzle () {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a grid: ");


		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				filledCellList.add(new int[] {i, j});
				tfArray[i][j].setStyle("-fx-text-fill: red; -fx-font-weight: bold");
				grid[i][j] = input.nextInt();
			}
		}
	}

	// Checks if the given values in the input grid for sudoku is correct
	public boolean isValid(int i, int j, int[][] grid) {
		// Check the i'th row
		for (int column = 0; column < grid.length; column++) {
			if (j != column && grid[i][column] == grid[i][j])
				return false;
		}

		// Check the j'th column
		for (int row = 0; row < grid[i].length; row++) {
			if (row != i && grid[row][j] == grid[i][j])
				return false;
		}

		// Check i'th the block
		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
			for (int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++) {
				if (row != i && column != j && grid[row][column] == grid[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	// Check for the fixed cells
	public boolean isValid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] < 0 || grid[i][j] > 9 || (grid[i][j] != 0 && !isValid(i, j, grid))) {
					System.out.println("Row: " + i + "\nColumn: " + j);					
					return false;
				}
			}
		}
		return true;
	}

	// Displays the grid into the textfields
	public void printGrid() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
