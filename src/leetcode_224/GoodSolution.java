package leetcode_224;

import java.util.Stack;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Answer
 * see the negative number as plus a negative number, thus we can use sign (1 or -1) to do operation
 * default sign is 1, since + is usually ignored. '+()' is the common situation
 * use a stack to store the pre result and the sign, '+()-()'
 */
public class GoodSolution {

    public int calculate(String s) {
        Stack<Integer> expressions = new Stack<Integer>();
        int len = s.length(), i = 0, result = 0, sign = 1;
        while (i<len){
            char ch = s.charAt(i);
            if (ch=='+') {
                sign = 1;
            } else if (ch=='-') {
                sign = -1;
            } else if (ch=='(') {
                expressions.push(result);
                expressions.push(sign);
                result = 0;
                sign = 1;
            } else if (ch==')') {
                result = result*expressions.pop() + expressions.pop();
            } else if (Character.isDigit(ch)) {
                int sum = ch-'0';
                while (i+1<len) {
                    ch = s.charAt(i+1);
                    if (Character.isDigit(ch)) {
                        sum = sum*10 + ch - '0';
                        i++;
                    } else {
                        break;
                    }
                }
                result += sum;
            }
        }
        return result;
    }
}
