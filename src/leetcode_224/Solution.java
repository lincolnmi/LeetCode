package leetcode_224;

import java.util.Stack;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem Definition:
 Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 */

/**
 * Answer:
 * split by the parenthesis, compute expression in the stack
 * once encounter the right parenthesis, pop all elements in the stack before the left parenthesis and compute the value
 */
public class Solution {

    public int calculate(String s) {
        Stack<String> expressions = new Stack<String>();
        int len = s.length(), i = 0;
        while (i<len){
            char ch = s.charAt(i);
            if (ch=='+') {
                expressions.push("+");
                i++;
            } else if (ch=='-') {
                expressions.push("-");
                i++;
            } else if (ch=='(') {
                expressions.push("(");
                i++;
            } else if (ch==')') {
                Stack<String> expression = getPartExpression(expressions);
                int value = getValue(expression);
                expressions.push(value+"");
                i++;
            } else if (ch==' ') {
                i++;
            } else {
                int start = i++;
                while (i<len) {
                    char temp = s.charAt(i);
                    if (temp<'0'||temp>'9') {
                        break;
                    } else {
                        i++;
                    }
                }
                expressions.push(s.substring(start,i));
            }
        }
        return getValue(reverse(expressions));
    }

    private Stack<String> getPartExpression(Stack<String> expressions) {
        Stack<String> expression = new Stack<String>();
        while (expressions.peek()!="(") {
            expression.push(expressions.pop());
        }
        expressions.pop();
        return expression;
    }

    private Stack<String> reverse(Stack<String> stack) {
        Stack<String> expression = new Stack<String>();
        while (!stack.isEmpty()) {
            expression.push(stack.pop());
        }
        return expression;
    }

    private int getValue(Stack<String> expression) {
        if (expression.isEmpty()) {
            return 0;
        }
        while (!expression.isEmpty()) {
            int num1 = Integer.valueOf(expression.pop());
            if (expression.isEmpty()) {
                return num1;
            }
            String operation = expression.pop();
            int num2 = Integer.valueOf(expression.pop());
            if (operation.equals("+")) {
                expression.push(num1+num2+"");
            } else {
                expression.push(num1-num2+"");
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.calculate("1+1");
        System.out.println(result);
    }

}
