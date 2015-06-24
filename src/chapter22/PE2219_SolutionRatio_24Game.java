/**
 * 
 */
package chapter22;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.JOptionPane;

/**
 * @author jslapnicka
 * @Date & @Time 14. 1. 2015 2015 8:01:08 
 */
public class PE2219_SolutionRatio_24Game extends Application {

	private int card1;
	private int card2;
	private int card3;
	private int card4;
	private int index1 = 0;
	private int index2 = 0;
	private int index3 = 0;
	private int index4 = 0;

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

	private	Timeline timer;
	ArrayList<Integer> card1Set = new ArrayList<Integer>();
	ArrayList<Integer> card2Set = new ArrayList<Integer>();
	ArrayList<Integer> card3Set	= new ArrayList<Integer>();
	ArrayList<Integer> card4Set = new ArrayList<Integer>();
	private int count = 0;
	private boolean stop = false;
	private long solutionCount = 0;
	private long noSolutionCount = 0;

	// Create UI in JavaFX
	@Override
	public void start(Stage primaryStage) throws IOException {

		setCard(1);
		setCard(2);
		setCard(3);
		setCard(4);
		count++;

		EventHandler<ActionEvent> eventHandler = e -> {
			autoRefresh();
		};

		timer = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		timer.setCycleCount(Timeline.INDEFINITE);

		Slider slSpeed = new Slider(0, 50, 1);
		slSpeed.setMajorTickUnit(10);
		slSpeed.setMinorTickCount(50);
		slSpeed.setShowTickMarks(true);
		slSpeed.setShowTickLabels(true);
		slSpeed.setOrientation(Orientation.VERTICAL);

		Button btRefresh = new Button("Refresh");
		Button btAutoRefresh = new Button("Auto-Refresh");
		Button btFindSolution = new Button("Find a Solution");
		Button btVerify = new Button("Verify");
		Button btStatistics = new Button("Statistics");

		tfSolution = new TextField();
		tfSolution.setPrefSize(120, 10);
		tfEnterExpression = new TextField();
		tfEnterExpression.setPrefSize(150, 10);

		Label lblExpression = new Label("Enter an expression:");
		Font lblFont = Font.font("Arial", FontWeight.BOLD, 11);
		lblExpression.setFont(lblFont);

		HBox hBoxRefresh = new HBox(10);
		hBoxRefresh.getChildren().addAll(btFindSolution, tfSolution, btRefresh, btAutoRefresh);
		hBoxRefresh.setAlignment(Pos.BOTTOM_CENTER);

		HBox hBoxCards = new HBox(5);
		hBoxCards.setAlignment(Pos.CENTER);
		hBoxCards.getChildren().addAll(imageView1, imageView2, imageView3, imageView4);

		HBox hBoxVerify = new HBox(10);
		hBoxVerify.getChildren().addAll(lblExpression, tfEnterExpression, btVerify, btStatistics);

		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(5, 10, 5, 10));
		pane.setTop(hBoxRefresh);
		pane.setCenter(hBoxCards);
		pane.setBottom(hBoxVerify);
		pane.setRight(slSpeed);

		// Register listeners
		btRefresh.setOnAction(e -> {
			refresh();
		});

		btAutoRefresh.setOnAction(e -> {
			card1 = 1;
			card2 = 2;
			card3 = 3;
			card4 = 4;		
			
			setImages();
			if (timer.getStatus() == Animation.Status.PAUSED || timer.getStatus() == Animation.Status.STOPPED)
				timer.play();
			else
				timer.pause();
		});
		
		btStatistics.setOnAction(e -> {
			while (!stop) {
				autoRefresh();
			}
		});

		slSpeed.valueProperty().addListener(ov -> {
			timer.setRate(slSpeed.getValue());
		});

		Scene scene = new Scene(pane, 420, 200);
		primaryStage.setTitle("PE2219_SolutionRatio_24Game");
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
					JOptionPane.showMessageDialog(null, "Numbers in the expression don't match !", 
							"Input error !", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	public void autoRefresh()  {
		setImages();
		findSolution();
		count++;
		
		index4++;
		if (index4 < card4Set.size()) {
			setCard(4);
		} else {
			index3++;
			if (index3 < card3Set.size()) {
				setCard(3);
				index4 = 0;
				card4 = card4Set.get(index4);
			} else {
				index2++;
				if (index2 < card2Set.size()) {
					setCard(2);
					index4 = 0;
					index3 = 0;
					setCard(3);
					setCard(4);
				} else {
					index1++;
					if (index1 < card1Set.size()) {
						setCard(1);
						index4 = 0;
						index3 = 0;
						index2 = 0;
						setCard(2);
						setCard(3);
						setCard(4);
					} else {
						stop = true;
					}
				}
			}
		}
		
		solutionCount = count - noSolutionCount;
		double percentage = (((double)solutionCount / (double)count) * 100.00);
        System.out.println("Total: " + count + ", Solutions: " + solutionCount + ", Percentage: " + percentage + "%");
		
		if (stop) {
			System.out.println("Number of possible picks: " + count);
			System.out.println("Number of found solutions: " + solutionCount);
			System.out.println("Check: " + (solutionCount + noSolutionCount));
			System.out.println("Success rate: " + (solutionCount / count) * 100.00);
		}

	}


	public void setCard(int card) {

		card1Set.clear();
		card2Set.clear();
		card3Set.clear();
		card4Set.clear();

		for (int i = 1; i <= 52; i++) {
			card1Set.add(i);
			if (i != card1)
				card2Set.add(i);
			if (i != card1 && i != card2)
				card3Set.add(i);
			if (i != card1 && i != card2 && i != card3)
				card4Set.add(i);
		}

		switch (card) {
		case 1: card1 = card1Set.get(index1); break;
		case 2: card2 = card2Set.get(index2); break;
		case 3: card3 = card3Set.get(index3); break;
		case 4: card4 = card4Set.get(index4); break;
		}
		
		card1Rank = (card1 % 13 == 0) ? 13 : card1 % 13;
		card2Rank = (card2 % 13 == 0) ? 13 : card2 % 13;
		card3Rank = (card3 % 13 == 0) ? 13 : card3 % 13;
		card4Rank = (card4 % 13 == 0) ? 13 : card4 % 13;
	}

	public void refresh() {
		card1 = hdR.mtd.getRandomNumber(1, 52);
		card2 = hdR.mtd.getRandomNumber(1, 52);
		card3 = hdR.mtd.getRandomNumber(1, 52);
		card4 = hdR.mtd.getRandomNumber(1, 52);

		setImages();
	}

	public void setImages() {
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
					if (evaluateExpression(expression) == 24) {
						tfSolution.setText(expression);
					}
				}
			}
		}
		if (tfSolution.getText().length() == 0) {
			tfSolution.setText("No solution found !");
			noSolutionCount++;
		}
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
