package leetcode_72;

/**
 * Created by Jason on 2016/5/12.
 */

/**
 * Problem definition:
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 * You have the following 3 operations permitted on a word:

 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */

/**
 * Answer:
 * dynamic programming
 * a1...n -> b1...m three steps
 * 1. a1...n-1 -> b1...m, delete an  => distance[i+1][j+1] = distance[i][j+1] + 1
 * 2. a1...n -> b1...m-1, delete bm  => distance[i+1][j+1] = distance[i+1][j] + 1
 * 3. a1..n-1 -> b1...m-1, replace an-1 to bm-1  => distance[i+1][j+1] = distance[i][j] + cost
 *
 * cost = a[i]==b[j]?0:1
 *
 */

public class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] distance = new int[m+1][n+1];
        for (int i=0;i<=n;i++) {
            distance[0][i] = i;
        }
        for (int i=0;i<=m;i++) {
            distance[i][0] = i;
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int cost = word1.charAt(i)==word2.charAt(j)?0:1;
                int minValue = Math.min(distance[i+1][j],distance[i][j+1]);
                distance[i+1][j+1] = distance[i][j]<=minValue?distance[i][j]+cost:minValue+1;

            }
        }
        return distance[m][n];
    }

}
