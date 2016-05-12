package leetcode_171;

/**
 * Created by Jason on 2016/5/12.
 */

/**
 * Problem definition:
 * Related to question Excel Sheet Column Title

 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 8 For example:

 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
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
