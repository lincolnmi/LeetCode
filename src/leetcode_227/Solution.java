package leetcode_227;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem definition:
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */

/**
 * Answer:
 * 3+2*2 =>   0+3+2*2,
 * init pre-0, cur-2
 * +/-  result += pre, pre = (+/-)cur
 * * /  pre = pre*cul, pre = pre/cul
 * result += pre
 *
 * 0+3+2*2 => 3+2*2 => 3+4 => 7
 * pre 0 cur 3 result 3
 * pre 3 cur 2 result 3
 * pre 2 cur 2 result 3
 * pre 4 cur 2 result 7
 */
public class Solution {

    public int calculate(String s) {
        if (s==null||s.equals("")) {
            return 0;
        }
        s = s.trim().replaceAll(" +", "");
        int result = 0, len = s.length(), preVal = 0, i = 0;
        char sign = '+';
        while (i<len) {
            int curVal = 0;
            while (i<len && Character.isDigit(s.charAt(i))) {
                curVal = curVal*10 + s.charAt(i) - '0';
                i++;
            }
            if (sign=='+') {
                result += preVal;
                preVal = curVal;
            } else if (sign=='-') {
                result += preVal;
                preVal = -curVal;
            } else if (sign=='*') {
                preVal = preVal*curVal;
            } else if (sign=='/') {
                preVal = preVal/curVal;
            }
            if (i<len) {
                sign = s.charAt(i);
                i++;
            }
        }
        result += preVal;
        return result;
    }

}
