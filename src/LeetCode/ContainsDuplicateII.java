package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * Leetcode-219-Contains Duplicate II
 * <p>
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {

    // time O(n*k)
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j - i <= k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // time O(n) space O(n)
    // 将数字及index存入HashMap中，如果存在相同的数字，则比较他们的index的差是否小于等于k
    public boolean containsNearbyDuplicateII2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // time O(n) space O(k)
    // 通过滑动窗口实现，set里面只保存k+1个数，
    // 如果这k+1个数有重复的，则return true
    // 每向右遍历一次，需要将最前面的数移除
    public boolean containsNearbyDuplicateII3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) {
                set.remove(nums[i - k - 1]);

            }
            if (!set.add(nums[i])) {
                return true;
            }
        }


        return false;

    }

    @Test
    public void Test() {
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {-1, -1};
//        int[] nums = {4,1,2,3,1,5};
        int[] nums = {1, 0, 1, 1};
        containsNearbyDuplicateII3(nums, 1);
    }
}
