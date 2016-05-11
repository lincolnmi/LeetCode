package leetcode_115;

/**
 * Created by Jason on 2016/5/11.
 */

/**
 * Problem definition:
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 * Here is an example:
 * S = "rabbbit", T = "rabbit"

 * Return 3.
 */

/**
 * Answer:
 * mem[i][j] means s(0...j) contains t(0...i)
 * if s(j)==t(i) mem[i][j] = mem[i-1][j-1] + mem[i][j-1]
 * else mem[i][j] = mem[i][j-1]
 */

public class Solution {

    public int numDistinct(String s, String t) {
        int row = t.length(), col = s.length();
        int[][] mem = new int[row+1][col+1];
        for (int i=0;i<=col;i++) {
            mem[0][i] = 1;
        }
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (t.charAt(i)==s.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
        return mem[row][col];
    }

}
