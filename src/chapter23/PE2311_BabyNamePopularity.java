/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 11:01:27 
 */
public class PE2311_BabyNamePopularity extends Application {

	private Label lblYear = new Label("Select a year:");
	private Label lblGender = new Label("Boy or Girl ?");
	private Label lblName = new Label("Enter a name:");
	private Label lblResult = new Label("");
	private ComboBox<Integer> cboYear = new ComboBox<Integer>();
	private ComboBox<String> cboGender = new ComboBox<String>();
	private TextField tfName = new TextField("");
	private Button btRanking = new Button("Find Ranking");

	@Override
	public void start(Stage primaryStage) {

		GridPane gridPane = new GridPane();
		gridPane.add(lblYear, 0, 0);
		gridPane.add(cboYear, 1, 0);
		gridPane.add(lblGender, 0, 1);
		gridPane.add(cboGender, 1, 1);
		gridPane.add(lblName, 0, 2);
		gridPane.add(tfName, 1, 2);
		gridPane.add(btRanking, 1, 3);

		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(5, 10, 5, 10));
		pane.setCenter(gridPane);
		pane.setBottom(lblResult);
		

		// Set up combo boxes
		ArrayList<Integer> years = new ArrayList<Integer>();
		for (int i = 2001; i <= 2011; i++)
			years.add(i);
		cboYear.getItems().addAll(years);
		cboGender.getItems().addAll("Male", "Female");

		// Register listeners
		btRanking.setOnAction(e -> {
			if (cboYear.getValue() != null && cboGender.getValue() != null && !tfName.getText().equals("")) {
				String name = tfName.getText();
				int year = cboYear.getValue() - 2001;
				String gender = cboGender.getValue();

				findRanking(name, year, gender);
			}
		});

		Scene scene = new Scene(pane, 280, 130);
		lblResult.setPrefSize(pane.getWidth(), 10);
		lblResult.setAlignment(Pos.CENTER);
		primaryStage.setTitle("Exercise23_11");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void findRanking(String name, int year, String gender) {
		// Load files & initialize databases
		ArrayList<HashMap<String, Integer>> boys = new ArrayList<HashMap<String,Integer>>();
		ArrayList<HashMap<String, Integer>> girls = new ArrayList<HashMap<String,Integer>>();
		File[] files = new File[10];

		try {
			for (int i = 0; i < 10; i++) {
				files[i] = new File("C:/Java/Test/babynamesranking20" + ((i + 1) < 10 ? "0" + (i + 1) : i + 1)  + ".txt");
				boys.add(new HashMap<String, Integer>());
				girls.add(new HashMap<String, Integer>());
				Scanner input = new Scanner(files[i]);
				while (input.hasNextLine()) {
					Integer rank = input.nextInt();
					String nameBoys = input.next();
					input.next(); // skip the volume
					String nameGirls = input.next();
					boys.get(i).put(nameBoys, rank);
					girls.get(i).put(nameGirls, rank);
					input.nextLine();
				}
				input.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Problem with the input files !");
			ex.printStackTrace();
		}
		
		switch(gender) {
		case "Male": 
			if (boys.get(year).containsKey(name)) {
				lblResult.setText("Boy name " + name + " is ranked #" + boys.get(year).get(name) + " in year " + cboYear.getValue());
			} else {
				lblResult.setText("Boy name not found in the database !");
			}
			break;
		case "Female":
			if (girls.get(year).containsKey(name)) {
				lblResult.setText("Girl name " + name + " is ranked #" + girls.get(year).get(name) + " in year " + cboYear.getValue());
			} else {
				lblResult.setText("Girl name not found in the database !");
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
