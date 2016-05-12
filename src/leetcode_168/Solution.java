package leetcode_168;

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
 * num--/26 to avoid % result is zero while / result is 1
 * 26 - Z
 */
public class Solution {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            sb.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return sb.toString();
    }

}
