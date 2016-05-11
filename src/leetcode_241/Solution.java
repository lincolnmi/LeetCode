package leetcode_241;

import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jason on 2016/5/11.
 */

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

 * Example 1
 * Input: "2-1-1".

 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]


 * Example 2
 * Input: "2*3-4*5"

 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */

/**
 * Answer:
 * Catlan number
 * use map to cache result
 * split by operator
 * use list to add multi results
 */
public class Solution {
    private HashMap<String,List<Integer>> map = new HashMap<String, List<Integer>>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if (ch=='-'||ch=='+'||ch=='*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int a:left) {
                    for (int b:right) {
                        if (ch=='-') {
                            result.add(a-b);
                        } else if (ch=='+') {
                            result.add(a+b);
                        } else {
                            result.add(a*b);
                        }
                    }
                }
            }
        }
        if (result.size()==0) {
            result.add(Integer.valueOf(input));
        }
        map.put(input,result);
        return result;
    }

}
