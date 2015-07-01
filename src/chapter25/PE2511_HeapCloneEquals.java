/**
 * 
 */
package chapter25;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 29. 6. 2015 2015 10:32:26 
 */
public class PE2511_HeapCloneEquals<E extends Comparable<E>> {

private java.util.ArrayList<E> list = new ArrayList<E>();
	
	/** Create a default heap */
	public PE2511_HeapCloneEquals() {
		// TODO Auto-generated constructor stub
		
	}
	
	/** Create a heap from an array of objects */
	public PE2511_HeapCloneEquals(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	/** Add a new object into the heap */
	public void add(E newObject) {
		list.add(newObject); // Append to the heap
		int currentIndex = list.size() - 1; // The index of the last node
		
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			// Swap if the current object is greater than its parent
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			} else {
				break; // The tree is a heap now
			}
			
			currentIndex = parentIndex;
		}
	}
	
	/** Remove the root of the heap */
	public E remove() {
		if (list.size() == 0) return null;
		
		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			// Find the maximum between two children
			if (leftChildIndex >= list.size()) break; // The tree is a heap
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}
			
			// Swap if the current node is less than maximum
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
			} else {
				break; // The tree is a heap
			}
		}
		return removedObject;
	}
	
	@Override
	public ArrayList<E> clone() {
		ArrayList<E> newArray = new ArrayList<E>(this.list.size());
		for (int i = 0; i < list.size(); i++) {
			newArray.add(list.get(i));
		}
		
		return newArray;
	}
	
	@Override
	public boolean equals(Object object) {
		@SuppressWarnings("unchecked")
		ArrayList<E> temp = (ArrayList<E>)object;
		if (object == null || temp.size() == 0)
			return false;
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i) != temp.get(i))
				return false;
		}
		return true;
	}
	
	/** Get the number o objects in the tree */
	public int getSize() {
		return list.size();
	}

}
