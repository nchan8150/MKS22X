//got operations.contains(str) idea from Amit.

import java.util.*;
import java.lang.*;

public class Calculator {
	public static double eval(String s) {
    	Stack stack = new Stack();
    	String operations = "+-*/%";
    	//LinkedList<Double> stack = new LinkedList<>();
    	String[] arr = s.split(" ");
    	for (int x = 0; x < arr.length; x++) {
    		String str = arr[x];
    		if (operations.contains(str)) {
    			if (str.equals("+")) {
    				double num1 = stack.pop();
    				double num2 = stack.pop();
    				stack.push(num1+num2);
    			}
    			else if(str.equals("-")) {
    				double num1 = stack.pop();
    				double num2 = stack.pop();
    				stack.push(num2-num1);
    			}
    			else if (str.equals("*")) {
    				double num1 = stack.pop();
    				double num2 = stack.pop();
    				stack.push(num1*num2);
    			}
    			else if (str.equals("/")) {
    				double num1 = stack.pop();
    				double num2 = stack.pop();
    				stack.push(num2/num1);
    			}
    			else if (str.equals("%")) {
    				double num1 = stack.pop();
    				double num2 = stack.pop();
    				stack.push(num1%num2);
    			}
    		}
    		else {
    			Double d = Double.parseDouble(str);
    			stack.push(d);
    		}
    		
    		
    	}
    	return stack.peek();
    }
/*
    public static void main(String[] args) {
    	System.out.println(eval("5 4 +")); //Should be 9
    	System.out.println(eval("5 4 -")); //1
    	System.out.println(eval("8 4 /")); // 2
    	System.out.println(eval("10 2.0 +")); //12
    	System.out.println(eval("11 3 - 4 + 2.5 *")); //30
    	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //893
    }
    */
}
