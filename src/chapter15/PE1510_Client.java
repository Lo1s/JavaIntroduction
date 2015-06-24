package chapter15;

public class PE1510_Client {
	public static void main(String[] args) throws CloneNotSupportedException {
	
	PE1510_MyStack stack = new PE1510_MyStack();
    
	stack.push("S1");
    stack.push("S2");
    stack.push("S");
    
    PE1510_MyStack stack2 = (PE1510_MyStack)stack.clone();
    stack2.push("S1");
    stack2.push("S2");
    stack2.push("S");
    System.out.println(stack.getSize());
    System.out.println(stack2.getSize());
	}
}
