/**
 * 
 */
package chapter22;

import java.util.Stack;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 13. 1. 2015 2015 13:57:37 
 */
public class PE2217_24PointCardGame extends Application {

	private int number1;
	private int number2;
	private int number3;
	private int number4;

	private TextField tfNumber1 = new TextField();
	private TextField tfNumber2 = new TextField();
	private TextField tfNumber3 = new TextField();
	private TextField tfNumber4 = new TextField();

	private Label lblSolution = new Label();
	private Button btSolution = new Button("Find a solution");
	
	public void start(Stage primaryStage) {
		// Set up properties
		Font font = new Font("Times New Roman", 20);
		lblSolution.setPrefSize(140, 40);
		lblSolution.setTextAlignment(TextAlignment.CENTER);
		lblSolution.setAlignment(Pos.CENTER);
		lblSolution.setFont(font);
		btSolution.setAlignment(Pos.CENTER_RIGHT);
		tfNumber1.setPrefSize(60, 40);
		tfNumber1.setFont(font);
		tfNumber1.setAlignment(Pos.CENTER);
		tfNumber2.setPrefSize(60, 40);
		tfNumber2.setFont(font);
		tfNumber2.setAlignment(Pos.CENTER);
		tfNumber3.setPrefSize(60, 40);
		tfNumber3.setFont(font);
		tfNumber3.setAlignment(Pos.CENTER);
		tfNumber4.setPrefSize(60, 40);
		tfNumber4.setFont(font);		
		tfNumber4.setAlignment(Pos.CENTER);
		
		GridPane solution = new GridPane();
		solution.add(btSolution, 1, 0);
		solution.add(lblSolution, 0, 0);
		
		HBox numbers = new HBox(5);
		numbers.getChildren().addAll(tfNumber1, tfNumber2, tfNumber3, tfNumber4);
		
		GridPane pane = new GridPane();
		pane.add(solution, 0, 0);
		pane.add(numbers, 0, 1);
		
		// Register listeners
		btSolution.setOnAction(e -> {
			findSolution();
		});
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise22_17");
		primaryStage.show();
	}
	

	public void findSolution() {
		// Get modulus = rank of the cards (King is 13 instead of 0)
		// Create arrays for all possible combinations of operators, brackets and sequences of the cards
		// + - / *
		
		number1 = Integer.parseInt(tfNumber1.getText());
		number2 = Integer.parseInt(tfNumber2.getText());
		number3 = Integer.parseInt(tfNumber3.getText());
		number4 = Integer.parseInt(tfNumber4.getText());
		
		char[][] operators = {
				{'+', '+', '+'},
				{'+', '+', '-'},
				{'+', '+', '*'},
				{'+', '+', '/'},
				{'+', '-', '+'},
				{'+', '-', '-'},
				{'+', '-', '*'},
				{'+', '-', '/'},
				{'+', '*', '+'},
				{'+', '*', '-'},
				{'+', '*', '*'},
				{'+', '*', '/'},
				{'+', '/', '+'},
				{'+', '/', '-'},
				{'+', '/', '*'},
				{'+', '/', '/'},
				{'-', '+', '+'},
				{'-', '+', '-'},
				{'-', '+', '*'},
				{'-', '+', '/'},
				{'-', '-', '+'},
				{'-', '-', '-'},
				{'-', '-', '*'},
				{'-', '-', '/'},
				{'-', '*', '+'},
				{'-', '*', '-'},
				{'-', '*', '*'},
				{'-', '*', '/'},
				{'-', '/', '+'},
				{'-', '/', '-'},
				{'-', '/', '*'},
				{'-', '/', '/'},
				{'*', '+', '+'},
				{'*', '+', '-'},
				{'*', '+', '*'},
				{'*', '+', '/'},
				{'*', '-', '+'},
				{'*', '-', '-'},
				{'*', '-', '*'},
				{'*', '-', '/'},
				{'*', '*', '+'},
				{'*', '*', '-'},
				{'*', '*', '*'},
				{'*', '*', '/'},
				{'*', '/', '+'},
				{'*', '/', '-'},
				{'*', '/', '*'},
				{'*', '/', '/'},
				{'/', '+', '+'},
				{'/', '+', '-'},
				{'/', '+', '*'},
				{'/', '+', '/'},
				{'/', '-', '+'},
				{'/', '-', '-'},
				{'/', '-', '*'},
				{'/', '-', '/'},
				{'/', '*', '+'},
				{'/', '*', '-'},
				{'/', '*', '*'},
				{'/', '*', '/'},
				{'/', '/', '+'},
				{'/', '/', '-'},
				{'/', '/', '*'},
				{'/', '/', '/'},
		};
		String[][][] brackets = {
				{{"", ""}, {"", ""}, {"", ""}, {"", ""}},
				{{"(", ""}, {"", ")"}, {"", ""}, {"", ""}},
				{{"", ""}, {"(", ""}, {"", ")"}, {"", ""}},
				{{"", ""}, {"", ""}, {"(", ""}, {"", ")"}},
				{{"(", ""}, {"", ")"}, {"(", ""}, {"", ")"}},
				{{"(", ""}, {"", ""}, {"", ")"}, {"", ""}},
				{{"(", ""}, {"(", ""}, {"", "))"}, {"", ""}},
				{{"((", ""}, {"", ")"}, {"", ")"}, {"", ""}},
				{{"", ""}, {"(", ""}, {"", ""}, {"", ")"}},
				{{"", ""}, {"((", ""}, {"", ")"}, {"", ")"}},
				{{"", ""}, {"(", ""}, {"(", ""}, {"", "))"}},			
		};
		int[][] combinations = {
				{number1, number2, number3, number4},
				{number4, number1, number2, number3},
				{number3, number4, number1, number2},
				{number2, number3, number4, number1},
				{number1, number2, number4, number3},
				{number3, number1, number2, number4},
				{number4, number3, number1, number2},
				{number2, number4, number3, number1},
				{number1, number4, number3, number2},
				{number2, number1, number4, number3},
				{number3, number2, number1, number4},
				{number4, number3, number2, number1},
				{number1, number3, number2, number4},
				{number4, number1, number3, number2},
				{number2, number4, number1, number3},
				{number3, number2, number4, number1},
				{number2, number1, number3, number4},
				{number4, number2, number1, number3},
				{number3, number4, number2, number1},
				{number1, number3, number4, number2},
				{number1, number4, number2, number3},
				{number3, number1, number4, number2},
				{number2, number3, number1, number4},
				{number4, number2, number3, number1}
		};

		findSolution(combinations, operators, brackets);

	}

	public void findSolution(int[][] combinations, char[][] operators, String[][][] brackets) {
		// Check every combinations of card ranks
		String expression = "";
		for (int cardsComb = 0; cardsComb < combinations.length; cardsComb++) {
			// Check every combination of operators
			for (int opComb = 0; opComb < operators.length; opComb++) {
				// Check every combination of brackets repositioning in the expression
				for (int bracketComb = 0; bracketComb < brackets.length; bracketComb++) {
					expression = brackets[bracketComb][0][0] + combinations[cardsComb][0] + brackets[bracketComb][0][1] + operators[opComb][0]
							+ brackets[bracketComb][1][0] + combinations[cardsComb][1] + brackets[bracketComb][1][1] + operators[opComb][1]
									+ brackets[bracketComb][2][0] + combinations[cardsComb][2] + brackets[bracketComb][2][1] + operators[opComb][2]
											+ brackets[bracketComb][3][0] + combinations[cardsComb][3] + brackets[bracketComb][3][1];
					if (evaluateExpression(expression) == 24) {
						lblSolution.setText(expression);
					}
				}
			}
		}
		if (lblSolution.getText().length() == 0)
			lblSolution.setText("No solution found !");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public double evaluateExpression(String expression)	{
		Stack operandStack = new Stack();
		Stack operatorStack = new Stack();
		for(StringTokenizer tokens = new StringTokenizer(expression, "()+-/*", true); tokens.hasMoreTokens();)	{
			String token = tokens.nextToken().trim();
			if(token.length() != 0)	{
				if(token.charAt(0) == '+' || token.charAt(0) == '-') {
					for(; !operatorStack.isEmpty() && (((Character)operatorStack.peek()).equals(Character.valueOf('+')) || ((Character)operatorStack.peek()).equals(Character.valueOf('-')) || ((Character)operatorStack.peek()).equals(Character.valueOf('*')) || ((Character)operatorStack.peek()).equals(Character.valueOf('/'))); processAnOperator(operandStack, operatorStack)) { }
					operatorStack.push(new Character(token.charAt(0)));
				} else
					if(token.charAt(0) == '*' || token.charAt(0) == '/') {
						for(; !operatorStack.isEmpty() && (((Character)operatorStack.peek()).equals(Character.valueOf('*')) || ((Character)operatorStack.peek()).equals(Character.valueOf('/'))); processAnOperator(operandStack, operatorStack)) { }
						operatorStack.push(new Character(token.charAt(0)));
					} else
						if(token.trim().charAt(0) == '(') {
							operatorStack.push(new Character('('));
						} else
							if(token.trim().charAt(0) == ')') {
								for(; !((Character)operatorStack.peek()).equals(Character.valueOf('(')); processAnOperator(operandStack, operatorStack)) { }
								operatorStack.pop();
							} else {
								operandStack.push(new Double(token));
							}
			}
		}

		for(; !operatorStack.isEmpty(); processAnOperator(operandStack, operatorStack)) { }
		return ((Double)operandStack.pop()).doubleValue();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void processAnOperator(Stack operandStack, Stack operatorStack) {
		if(((Character)operatorStack.peek()).equals(Character.valueOf('+'))) {
			operatorStack.pop();
			double op1 = ((Double)operandStack.pop()).doubleValue();
			double op2 = ((Double)operandStack.pop()).doubleValue();
			operandStack.push(new Double(op2 + op1));
		} else
			if(((Character)operatorStack.peek()).equals(Character.valueOf('-'))) {
				operatorStack.pop();
				double op1 = ((Double)operandStack.pop()).doubleValue();
				double op2 = ((Double)operandStack.pop()).doubleValue();
				operandStack.push(new Double(op2 - op1));
			} else
				if(((Character)operatorStack.peek()).equals(Character.valueOf('*'))) {
					operatorStack.pop();
					double op1 = ((Double)operandStack.pop()).doubleValue();
					double op2 = ((Double)operandStack.pop()).doubleValue();
					operandStack.push(new Double(op2 * op1));
				} else
					if(((Character)operatorStack.peek()).equals(Character.valueOf('/'))) {
						operatorStack.pop();
						double op1 = ((Double)operandStack.pop()).doubleValue();
						double op2 = ((Double)operandStack.pop()).doubleValue();
						operandStack.push(new Double(op2 / op1));
					}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
