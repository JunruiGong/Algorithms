package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode-347-Top K Frequent Elements-Medium
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            // 确定每个数的出现次数
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (int key : hashMap.keySet()) {

            // count表示数字出现的次数
            int count = hashMap.get(key);

            // 越后面，出现的次数越多
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            // 将出现次数相同的数字放入同一个index中
            bucket[count].add(key);
        }

        List<Integer> result = new ArrayList<>();

        // 从后往前，取k个数
        for (int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos--) {
            if (bucket[pos] != null) {
                result.addAll(bucket[pos]);
            }
        }

        return result;
    }
}