/**
 * 
 */
package chapter15_JavaFX;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author jslapnicka
 * @Date & @Time 6. 1. 2015 2015 15:12:59 
 */
public class L1510_ObservablePropertyDemo {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleProperty balance = new SimpleDoubleProperty();
		balance.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable ov) {
				System.out.println("The new value is " + balance.doubleValue());
			}
		});
		
		balance.setValue(4.5);
	}

}
