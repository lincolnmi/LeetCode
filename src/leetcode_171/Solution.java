package leetcode_171;

/**
 * Created by Jason on 2016/5/12.
 */

/**
 * Problem definition:
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 * For example:

 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */

/**
 * Answer:
 * calculate result = result*26 + num
 */
public class Solution {

    public int titleToNumber(String s) {
        int result = 0;
        for (int i=0,len=s.length();i<len;i++) {
            result = result*26 + s.charAt(i)-'A' + 1;
        }
        return result;
    }

}
