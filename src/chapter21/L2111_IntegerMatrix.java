/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 10:09:11 
 */
public class L2111_IntegerMatrix extends L2110_GenericMatrix<Integer> {

	@Override
	protected Integer add(Integer o1, Integer o2) {
		return o1 + o2;
	}
	
	@Override
	protected Integer multiply(Integer o1, Integer o2) {
		return o1 * o2;
	}
	
	@Override
	protected Integer zero() {
		return 0;
	}
	
}
