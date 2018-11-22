package LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Leetcode-220-Contains Duplicate III
 * <p>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 * <p>
 * Example
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class ContainsDuplicateIII {

    // time O(n*k) 可能会超时
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    // time O(n*logk) space O(k)
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            // 找到比该数大的最小值
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && Math.abs(Long.valueOf(ceil) - (long) nums[i]) <= t) {
                return true;
            }

            // 找到比该数小的最大值
            Integer floor = set.floor(nums[i]);
            if (floor != null && Math.abs(Long.valueOf(floor) - (long) nums[i]) <= t) {
                return true;
            }
            set.add(nums[i]);

            if (i > k) {
                set.remove(nums[i - k]);

            }
        }

        return false;
    }

    // time O(n) space O(bucket_size)
    // 将每个数放个对应的bucket（bucket_index）=(number-min_num)/(t+1)
    // 同一个bucket中的数差值一定小于5，如果存在两个数在同一个bucket则返回true
    // 此外还要比较相邻的bucket，相邻的bucket的差值也可能小于t
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        long diff = (long) t + 1;  // In case of t = 0

        for (int i = 0; i < nums.length; i++) {
            long index = ((long) nums[i] - min) / diff;

            // 比较左边的bucket和当前bucket的差值
            Integer leftBucket = map.get(index - 1);
            if (leftBucket != null && Math.abs((long)leftBucket - (long)nums[i]) <= t) {
                return true;
            }

            // 比较右边的bucket和当前bucket的差值
            Integer rightBucket = map.get(index + 1);
            if (rightBucket != null && Math.abs((long)rightBucket - (long)nums[i]) <= t) {
                return true;
            }

            Integer currentBucket = map.get(index);
            if (currentBucket != null) {
                return true;
            }
            map.put(index, nums[i]);

            if (i >= k) {
                map.remove(((long) nums[i - k] - (long) min) / diff);
            }

        }

        return false;
    }

    @Test
    public void Test() {
        int[] nums = {1, 2, 3, 1};
//        int[] nums = {-1, 2147483647};
//        int[] nums = {1, 5, 9, 1, 5, 9};
        containsNearbyAlmostDuplicate3(nums, 3, 0);
    }
}
