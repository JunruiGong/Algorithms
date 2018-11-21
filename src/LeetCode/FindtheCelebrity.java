package LeetCode;

/**
 * Leetcode-277-Find the Celebrity
 * <p>
 * Suppose you are at a party with n people (labeled from 0 to n-1) and among them,
 * there may (may not) exist on celebrity. The definition of a celebrity is that
 * all the other n-1 people know him/her but he/she does not know any of them.
 */

/**
 * 1. Find a candidate by one pass: (make sure other people are not a celebrity)
 * 2. Make sure if the candidate is a celebrity by one pass
 * <p>
 * 根据题目给出的candidate的定义，每一次的比较都能够确定其中一个人是否是celebrity
 * 如： 比较a, b
 * 如果a不认识b，那么b肯定就不是celebrity；
 * 如果a认识b，那么a肯定不是celebrity。
 */

public class FindtheCelebrity {

    // 已经定义的API，用于比较两个人是否认识
    // 如果a认识b，return true
    // 否则return false
    boolean knows(int a, int b) {
        return false;
    }

    public int findCelebrity(int n) {

        if (n < 2) {
            return -1;
        }

        int candidate = 0;
        // Find a candidate by one pass: (make sure other people are not a celebrity)
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Make sure if the candidate is a celebrity by one pass
        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }

            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}
