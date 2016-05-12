package leetcode_150;

import java.util.Stack;

/**
 * Created by Jason on 2016/5/12.
 */

/**
 * Problem definition:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

/**
 * Answer:
 * use a stack to store number
 * once come up with operator, pop pre two numbers from the stack, calculate the result based on the operator
 * and push the result in
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String str:tokens) {
            if (str.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1+num2);
            } else if (str.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1-num2);
            } else if (str.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1*num2);
            } else if (str.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1/num2);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }

}
