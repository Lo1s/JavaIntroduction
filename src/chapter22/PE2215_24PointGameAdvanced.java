/**
 * 
 */
package chapter22;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author jslapnicka
 * @Date & @Time 9. 1. 2015 2015 10:54:09 
 */
public class PE2215_24PointGameAdvanced extends Application {

	private int card1;
	private int card2;
	private int card3;
	private int card4;

	private String card1Path;
	private String card2Path;
	private String card3Path;
	private String card4Path;

	private ImageView imageView1 = new ImageView();
	private ImageView imageView2 = new ImageView();
	private ImageView imageView3 = new ImageView();
	private ImageView imageView4 = new ImageView();

	private TextField tfSolution;
	private TextField tfEnterExpression;

	private int card1Rank;
	private int card2Rank;
	private int card3Rank;
	private int card4Rank;

	private ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
	private ArrayList<Integer> cardsNumbers = new ArrayList<Integer>();

	// Create UI in JavaFX
	@Override
	public void start(Stage primaryStage) {
		refresh();
		Button btRefresh = new Button("Refresh");
		Button btFindSolution = new Button("Find a Solution");
		Button btVerify = new Button("Verify");

		tfSolution = new TextField();
		tfSolution.setPrefSize(120, 10);
		tfEnterExpression = new TextField();
		tfEnterExpression.setPrefSize(150, 10);

		Label lblExpression = new Label("Enter an expression:");
		Font lblFont = Font.font("Arial", FontWeight.BOLD, 11);
		lblExpression.setFont(lblFont);

		HBox hBoxRefresh = new HBox(10);
		hBoxRefresh.getChildren().addAll(btFindSolution, tfSolution, btRefresh);
		hBoxRefresh.setAlignment(Pos.BOTTOM_CENTER);

		HBox hBoxCards = new HBox(5);
		hBoxCards.setAlignment(Pos.CENTER);
		hBoxCards.getChildren().addAll(imageView1, imageView2, imageView3, imageView4);

		HBox hBoxVerify = new HBox(10);
		hBoxVerify.getChildren().addAll(lblExpression, tfEnterExpression, btVerify);

		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(5, 10, 5, 10));
		pane.setTop(hBoxRefresh);
		pane.setCenter(hBoxCards);
		pane.setBottom(hBoxVerify);

		// Register listeners
		btRefresh.setOnAction(e -> {
			refresh();
		});

		Scene scene = new Scene(pane, 350, 200);
		primaryStage.setTitle("PE2215_24PointGameAdvanced");
		primaryStage.setScene(scene);
		primaryStage.show();

		btFindSolution.setOnAction(e -> {
			findSolution();
		});

		btVerify.setOnAction(e -> {
			if (tfEnterExpression.getText().length() > 0) {
				double evaluate = evaluateExpression((tfEnterExpression.getText()));

				Collections.sort(inputNumbers);
				Collections.sort(cardsNumbers);
				System.out.println(inputNumbers);
				System.out.println(cardsNumbers);
				
				if (inputNumbers.equals(cardsNumbers)) {
					if (evaluate == 24)
						JOptionPane.showMessageDialog(null, "Correct result");
					else
						JOptionPane.showMessageDialog(null, "Incorrect result");
				} else
					JOptionPane.showMessageDialog(null, "The numbers in the expression don't match\n with the numbers in the set !", 
							"Input expression does not match !", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	public void refresh() {
		card1 = hdR.mtd.getRandomNumber(1, 52);
		card2 = hdR.mtd.getRandomNumber(1, 52);
		card3 = hdR.mtd.getRandomNumber(1, 52);
		card4 = hdR.mtd.getRandomNumber(1, 52);

		card1Path = "File:C:/Java/site/image/card/" + card1 + ".png";
		card2Path = "File:C:/Java/site/image/card/" + card2 + ".png";
		card3Path = "File:C:/Java/site/image/card/" + card3 + ".png";
		card4Path = "File:C:/Java/site/image/card/" + card4 + ".png";

		imageView1.setImage(new Image(card1Path));
		imageView2.setImage(new Image(card2Path));
		imageView3.setImage(new Image(card3Path));
		imageView4.setImage(new Image(card4Path));

		card1Rank = (card1 % 13 == 0) ? 13 : card1 % 13;
		card2Rank = (card2 % 13 == 0) ? 13 : card2 % 13;
		card3Rank = (card3 % 13 == 0) ? 13 : card3 % 13;
		card4Rank = (card4 % 13 == 0) ? 13 : card4 % 13;

		cardsNumbers.clear();
		cardsNumbers.add(card1Rank);
		cardsNumbers.add(card2Rank);
		cardsNumbers.add(card3Rank);
		cardsNumbers.add(card4Rank);
	}

	public void findSolution() {
		// Get modulus = rank of the cards (King is 13 instead of 0)
		// Create arrays for all possible combinations of operators, brackets and sequences of the cards
		// + - / *
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
				{card1Rank, card2Rank, card3Rank, card4Rank},
				{card4Rank, card1Rank, card2Rank, card3Rank},
				{card3Rank, card4Rank, card1Rank, card2Rank},
				{card2Rank, card3Rank, card4Rank, card1Rank},
				{card1Rank, card2Rank, card4Rank, card3Rank},
				{card3Rank, card1Rank, card2Rank, card4Rank},
				{card4Rank, card3Rank, card1Rank, card2Rank},
				{card2Rank, card4Rank, card3Rank, card1Rank},
				{card1Rank, card4Rank, card3Rank, card2Rank},
				{card2Rank, card1Rank, card4Rank, card3Rank},
				{card3Rank, card2Rank, card1Rank, card4Rank},
				{card4Rank, card3Rank, card2Rank, card1Rank},
				{card1Rank, card3Rank, card2Rank, card4Rank},
				{card4Rank, card1Rank, card3Rank, card2Rank},
				{card2Rank, card4Rank, card1Rank, card3Rank},
				{card3Rank, card2Rank, card4Rank, card1Rank},
				{card2Rank, card1Rank, card3Rank, card4Rank},
				{card4Rank, card2Rank, card1Rank, card3Rank},
				{card3Rank, card4Rank, card2Rank, card1Rank},
				{card1Rank, card3Rank, card4Rank, card2Rank},
				{card1Rank, card4Rank, card2Rank, card3Rank},
				{card3Rank, card1Rank, card4Rank, card2Rank},
				{card2Rank, card3Rank, card1Rank, card4Rank},
				{card4Rank, card2Rank, card3Rank, card1Rank}
		};

		findSolution(combinations, operators, brackets);

	}

	public void findSolution(int[][] combinations, char[][] operators, String[][][] brackets) {
		// Check every combinations of card ranks
		tfSolution.setText("");
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
					if (evaluateExpression(expression) == 24)
						tfSolution.setText(expression);
				}
			}
		}
		if (tfSolution.getText().length() == 0)
			tfSolution.setText("No solution found !");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public double evaluateExpression(String expression)	{
		Stack operandStack = new Stack();
		Stack operatorStack = new Stack();
		inputNumbers.clear();
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
								inputNumbers.add(new Integer(token));
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
