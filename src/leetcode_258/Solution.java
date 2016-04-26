package leetcode_258;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem Definition
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:
 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */

/**
 * Answer
 * num = a_1*10^(n-1)+a_2*10^(n-2)+...+a_{n-1}*10+a_n
 * num%9 = (a_1*10^(n-1)+a_2*10^(n-2)+...+a_{n-1}*10+a_n)%9
 * =(a_1+a_2+...+a_n)%9
 * note that num=9, num%9==0, so we use (num-1)%9+1 to avoid 9 scenario
 */
public class Solution {
    public int addDigits(int num) {
        return 1 + (num-1) % 9;
    }
}
