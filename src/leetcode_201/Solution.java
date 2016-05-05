package leetcode_201;

/**
 * Created by Jason on 2016/5/5.
 */

/**
 * Problem definition:
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */

/**
 * Answer:
 * the last bit of (odd & even) is 0
 * if m!=n, must exist odd and even
 * move m and n right bitwise until m=n
 */
public class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m!=n) {
            m>>=1;
            n>>=1;
            offset += 1;
        }
        return m<<offset;
    }

}
