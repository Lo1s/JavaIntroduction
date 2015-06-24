/**
 * 
 */
package chapter15_JavaFX;


import chapter10.L1002_Loan;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 12:52:27 
 */
public class L1506_LoanCalculator extends Application {

	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumberOfYears = new TextField();
	private TextField tfLoanAmount = new TextField();
	private TextField tfMonthlyPayment = new TextField();
	private TextField tfTotalPayment = new TextField();
	private Button btCalculate = new Button("Calculate");
	
	@Override
	public void start(Stage primaryStage) {
		// Create UI
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
		gridPane.add(tfAnnualInterestRate, 1, 0);
		gridPane.add(new Label("Number of Years:"), 0, 1);
		gridPane.add(tfNumberOfYears, 1, 1);
		gridPane.add(new Label("Loan Amount:"), 0, 2);
		gridPane.add(tfLoanAmount, 1, 2);
		gridPane.add(new Label("Monthly Payment:"), 0, 3);
		gridPane.add(tfMonthlyPayment, 1, 3);
		gridPane.add(new Label("Total Payment:"), 0, 4);
		gridPane.add(tfTotalPayment, 1, 4);
		gridPane.add(btCalculate, 1, 5);
		
		// Set properties to UI
		gridPane.setAlignment(Pos.CENTER);
		tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
		tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
		tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
		tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
		tfMonthlyPayment.setEditable(false);
		tfTotalPayment.setEditable(false);
		GridPane.setHalignment(btCalculate, HPos.RIGHT);
		
		// Register handler in order to process events
		btCalculate.setOnAction(e -> calculatePayment());
		
		Scene scene = new Scene(gridPane, 300, 250);
		primaryStage.setTitle("LoanCalculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void calculatePayment() {
		double interest = Double.parseDouble(tfAnnualInterestRate.getText());
		int year = Integer.parseInt(tfNumberOfYears.getText());
		double loanAmount = Double.parseDouble(tfLoanAmount.getText());
		
		// Create a loan object defined in listing 10.2
		L1002_Loan loan = new L1002_Loan(interest, year, loanAmount);
		
		// Display monthly payment and total payment
		tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
		tfTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
