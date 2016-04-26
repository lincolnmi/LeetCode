package leetcode_306;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem Definition:
 Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 1 + 99 = 100, 99 + 100 = 199
 Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 */

/**
 * Answer:
 select the first and second number recursively.
 first [0,i), second [i,j)  sum = first+second, check str.startswith(sum)?
 invalid: (str[0]=='0'&&i>=2) || (str[i]=='0'&&j-i>=2)
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i=1;i<=(len-1)/2;i++) {
            if (num.charAt(0)=='0'&&i>=2) {
                break;
            }
            for (int j=i+1;len-j>=j-i&&len-j>=i;j++) {
                if (num.charAt(i)=='0'&&j-i>=2) {
                    break;
                }
                long num1 = Long.valueOf(num.substring(0, i));
                long num2 = Long.valueOf(num.substring(i, j));
                String substr = num.substring(j);
                if (isAdditive(substr,num1,num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdditive(String str, long num1, long num2) {
        if(str.equals("")) return true; // reaches the end of string means a yes

        long sum = num1+num2;
        String s = String.valueOf(sum);
        if(!str.startsWith(s)) {
            return false; // if string does not start with sum of num1 and num2, returns false
        }

        return isAdditive(str.substring(s.length()), num2, sum); // recursively checks the remaining string
    }

}
