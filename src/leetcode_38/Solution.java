package leetcode_38;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...

 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.

 * Note: The sequence of integers will be represented as a string.
 */

/**
 * Answer:
 * just traverse the string one by one to count the duplicate element
 */

public class Solution {

    public String countAndSay(int n) {
        String result = "1";
        for (int i=1;i<n;i++) {
            result = countAndSay(result);
        }
        return result;
    }

    private String countAndSay(String input) {
        StringBuilder result = new StringBuilder();
        char current = input.charAt(0);
        int count = 1;
        for (int i=1;i<input.length();i++) {
            if (input.charAt(i)==current) {
                count++;
            } else {
                result.append(count);
                result.append(current);
                current = input.charAt(i);
                count = 1;
            }
        }
        result.append(count);
        result.append(current);
        return result.toString();
    }

}
