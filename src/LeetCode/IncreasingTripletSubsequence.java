package LeetCode;

/**
 * Leetcode-334-Trapping Rain Water
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: true
 *
 * Example 2:
 * Input: [5,4,3,2,1]
 * Output: false
 * */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }


        // 先设置两个数用于记录这个递增子序列的前两个数（min1 < min2）
        // 接下来分3种情况进行讨论：
        // 如果num小于或等于min1，将num赋值给min1
        // 如果num大于min1小于等于min2，将num赋值给min2
        // 如果num比min2大，则min1，min2，num形成一个递增的子序列，返回 true。

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= min1) {
                min1 = num;
            } else if (num > min1 && num <= min2) {
                min2 = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
