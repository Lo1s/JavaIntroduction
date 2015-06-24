/**
 * 
 */
package chapter15_JavaFX;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * @author jslapnicka
 * @Date & @Time 7. 1. 2015 2015 7:56:01 
 */
public class L1517_BallPane extends Pane {

	public final double radius = 20;
	private double x = radius, y = radius;
	private double dx = 1, dy = 1;
	private Circle circle = new Circle(x, y, radius);
	private Timeline animation;
	
	public L1517_BallPane() {
		// TODO Auto-generated constructor stub
		circle.setFill(Color.GREEN);
		getChildren().add(circle);
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	
	public void play() {
		animation.play();
	}
	
	public void pause() {
		animation.pause();
	}
	
	public void stop() {
		animation.stop();
	}
	
	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 0.1);
	}
	
	public void decreaseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}
	
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	
	protected void moveBall() {
		
		if (x < radius || x > getWidth() - radius) {
			dx *= -1; // Change ball move direction
		}
		
		if (y < radius || y > getHeight() - radius) {
			dy *= -1; // Change ball move direction
		}
		
		// Adjust ball position
		x += dx;
		y += dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
}
