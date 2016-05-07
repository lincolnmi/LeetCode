package leetcode_165;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 * Here is an example of version numbers ordering:

 * 0.1 < 1.1 < 1.2 < 13.37
 */

/**
 * Answer:
 * special case 0.0.1<0.1
 * split by '.' since version may contains multiple '.'
 * let '.' split each version into multiple segments, compare each segment
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] values1 = version1.split("\\.");
        String[] values2 = version2.split("\\.");
        int len1 = values1.length, len2 = values2.length, len = Math.max(len1,len2);
        for (int i=0;i<len;i++) {
            int v1 = i<len1?Integer.valueOf(values1[i]):0;
            int v2 = i<len2?Integer.valueOf(values2[i]):0;
            if (v1<v2) {
                return -1;
            } else if (v1>v2) {
                return 1;
            }
        }
        return 0;
    }

}
