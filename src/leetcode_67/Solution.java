package leetcode_67;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem definition:
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 Subscribe to see which companies asked this question
 */

/**
 * Answer
 * string add method
 * add bitwise, mention carry
 */
public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int i = m - 1, j = n - 1, temp = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0||j>=0||temp==1) {
            temp += (i>=0?a.charAt(i--) - '0':0);
            temp += (j>=0?b.charAt(j--) - '0':0);
            sb.append(temp%2);
            temp = temp/2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11","1"));
    }

}
