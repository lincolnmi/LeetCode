package leetcode_204;

/**
 * Created by Jason on 2016/5/11.
 */

/**
 * Problem definition:

 * Count the number of prime numbers less than a non-negative number, n.
 */

/**
 * Answer:
 * Sieve of Eratosthenes method to find prime
 * 2 4 6 8 10 12 14 ...
 * 3 9 12 15 18 21 24 ...
 * 5 25 30 35 40 45 ...
 * 7 49 56 ...
 * check i is prime, j = i*i+i is not prime
 */

public class Solution {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i=2;i<n;i++) {
            isPrime[i] = true;
        }
        int count = 0;
        for (int i=2;i*i<n;i++) {
            if (isPrime[i]) {
                for (int j=i*i;j<n;j+=i) {
                    isPrime[j] = false;
                }
                count++;
            }
        }
        return count;
    }

}
