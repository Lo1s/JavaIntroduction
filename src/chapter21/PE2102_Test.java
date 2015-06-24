/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 13:00:42 
 */
public class PE2102_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE2102_GenericStackInheritance intArray = new PE2102_GenericStackInheritance();
		PE2102_GenericStackInheritance doubleArray = new PE2102_GenericStackInheritance();
		
		for (int i = 0; i < 100; i++) {
			intArray.push(i);
			doubleArray.push((double)i);
		}
		
		
		System.out.println("---- Integer ----");
		System.out.println(intArray.toString());
		System.out.println("size: " + intArray.getSize());
		System.out.println("isEmpty ? " + intArray.isEmpty());
		System.out.println("peek: " + intArray.peek());
		int lengthInt = intArray.getSize();
		for (int i = 0; i < lengthInt; i++) {
			System.out.print(intArray.pop() + ", ");
		}
		
		System.out.println("\nsize now: " + intArray.getSize());
		System.out.println("isEmpty ? " + intArray.isEmpty());
		
		System.out.println("---- Double ----");
		System.out.println(doubleArray.toString());
		System.out.println("size: " + doubleArray.getSize());
		System.out.println("isEmpty ? " + doubleArray.isEmpty());
		System.out.println("peek: " + doubleArray.peek());
		int lengthDouble = doubleArray.getSize();
		for (int i = 0; i < lengthDouble; i++) {
			System.out.print(doubleArray.pop() + ", ");
		}
		
		System.out.println("\nsize now: " + doubleArray.getSize());
		System.out.println("isEmpty ? " + doubleArray.isEmpty());
	}

}
