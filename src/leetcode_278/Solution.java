package leetcode_278;

/**
 * Created by Jason on 2016/5/14.
 */

/**
 * Problem definition:
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
 * of your product fails the quality check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.

 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.

 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 */

/**
 * Answer:
 * binary search to get the first bad version
 * if the mid version is bad, may exist bad version before it, set right = mid
 * otherwise, the bad version must be after the mid, set left = mid+1
 */
public class Solution extends VersionControl{

    public int firstBadVersion(int n) {
        int left = 0,right = n;
        while (left<right) {
            int mid = left + (right-left)/2;
            if (!isBadVersion(mid)) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
