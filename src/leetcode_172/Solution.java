package leetcode_172;

/**
 * Created by Jason on 2016/5/13.
 */

/**
 * Problem definition:
 * Given an integer n, return the number of trailing zeroes in n!.
 */

/**
 * Answer:
 * n!=2^x * 3^y * 5^z ...
 * number of traingZeros = min(x,z)=z
 * z = n/5 + n/25 + n/125s + n/625 + ...
 */
public class Solution {

    public int trailingZeroes(int n) {
        int result = 0;
        while (n>0) {
            result += n/5;
            n/=5;
        }
        return result;
    }

}
