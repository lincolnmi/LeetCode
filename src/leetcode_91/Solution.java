package leetcode_91;

import java.util.HashMap;

/**
 * Created by Jason on 2016/5/11.
 */

/**
 * Problem definition:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.

 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 * The number of ways decoding "12" is 2.
 */

/**
 * Answer:
 * method1:
 *
 * recursion, remove the first and first two chars respectively
 * use the cache to store the result
 * method2:
 * compute from the right to the left
 * the last is 1, '0' means 0
 * if the two chars is less than 26, the current result equals the last and the last two sum
 * otherwise, the current result equals the last value
 */
public class Solution {
    private HashMap<String,Integer> cache = new HashMap<String, Integer>();

    //dp method
    public int numDecodings2(String s) {
        if (s.equals("")) {
            return 0;
        } else {
            int n = s.length();
            int[] num = new int[n+1];
            num[n] = 1;
            num[n-1] = s.charAt(n-1)=='0'?0:1;
            for (int i=0;i<n;i++) {
                if (s.charAt(i)!='0') {
                    num[i] = Integer.valueOf(s.substring(i,i+2))<=26?(num[i+1]+num[i+2]):num[i+1];
                }
            }
            return num[0];
        }
    }

    public int numDecodings(String s) {
        if (s.equals("")) {
            return 0;
        } else {
            return decoding(s);
        }
    }

    private int decoding(String s) {
        int size = s.length();
        if (s.startsWith("0")) {
            return 0;
        }
        if (size==0) {
            return 1;
        } else if (size==1) {
            if (Integer.valueOf(s)<1||Integer.valueOf(s)>26) {
                return 0;
            } else {
                return 1;
            }
        }  else {
            if (cache.containsKey(s)) {
                return cache.get(s);
            } else {
                int num1 = decoding(s.substring(1)), num2 = 0;
                if (Integer.valueOf(s.substring(0, 2)) <= 26 && Integer.valueOf(s.substring(0, 2)) >= 1) {
                    num2 = decoding(s.substring(2));
                }
                cache.put(s,num1+num2);
                return num1 + num2;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("10"));
    }

}
