package LeetCode;

import org.junit.Test;

/**
 * Leetcode-204-Count Primes-Easy
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];

        // 新建的array默认值为false
        for (int i = 0; i < n; i++) {
            primes[i] = true;
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }

            for (int j = 2; i * j < n; j++) {
                primes[i * j] = false;
            }
        }

        return count;
    }

    @Test
    public void test() {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
