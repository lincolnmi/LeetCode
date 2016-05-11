package leetcode_29;

/**
 * Created by Jason on 2016/5/11.
 */

/**
 * Problem definition:
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */

/**
 * Answer:
 * let dividend minus the most approximate to the dividend which value shifted from the divisor
 * eg. compute(15,3) (15-3<<2)=3 next to compute(3,3) (3-3)=0, end result = 1<<2+1<<0 = 5
 *
 * According to the problem statement, we need to handle some exceptions, such as overflow.
 * Well, two cases may cause overflow:
 * divisor = 0;
 * dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1).
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if(divisor==0||(dividend==Integer.MIN_VALUE&&divisor==-1)) {
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend<0)^(divisor<0))?-1:1;
        int result = 0;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        while (dvd>=dvs) {
            long temp = dvs,count = 1;
            while (dvd>=(temp<<1)) {
                temp<<=1;
                count<<=1;
            }
            dvd -= temp;
            result+=count;
        }
        return sign==-1?-result:result;
    }

}
