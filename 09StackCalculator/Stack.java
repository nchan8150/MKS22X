import java.util.*;

public class Stack {

	private LinkedList<Double> stack;

	public Stack() {
		stack = new LinkedList<Double>();
	}
	public Double pop() {
		return stack.remove(stack.size()-1);
	}
	public Double peek() {
		return stack.get(stack.size()-1);
	}
	public void push(Double d) {
		stack.add(d);
	}
}
