package LeetCode;

import java.util.Arrays;

/**
 * Leetcode-164-Maximum Gap
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * Example 1:
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 *
 * Example 2:
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * Note:
 *
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 * */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums==null||nums.length<2){
            return 0;
        }

        // 题目要求是要线性的时间和空间，那么只能用桶排序或者基排序。

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // 每个桶之间的差值
        // k-th bucket contains all numbers in [min + (k-1)gap, min + k*gap).
        // 需要在每个桶中找出局部最大值和最小值，而最大间距的两个数不会在同一个桶中，而是一个桶的最小值和另一个桶的最大值之间的间距。
        int gap = (int) Math.ceil((double)(max-min)/(nums.length-1));

        int[] bucketMin = new int[nums.length-1];
        int[] bucketMax = new int[nums.length-1];

        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        Arrays.fill(bucketMax,Integer.MIN_VALUE);


        // 把数存放到各个bucket中，因为只需要获得最小值和最大值的间距，
        // 所以每个bucket只需要存放最大值和最小值
        for(int num:nums){
            if (num==min|| num==max){
                continue;
            }

            // index为需要放入哪一个bucket
            int index = (num-min)/gap;
            bucketMin[index] = Math.min(bucketMin[index],num);  // 当前bucket里面的最小值
            bucketMax[index] = Math.max(bucketMax[index],num);  // 当前bucket里面的最大值
        }

        // 用于记录最大的间距
        int maxGap = Integer.MIN_VALUE;

        int previous = min;

        for(int i=0;i<nums.length-1;i++)
        {
            if (bucketMax[i]==Integer.MIN_VALUE && bucketMin[i]==Integer.MAX_VALUE){
                // empty bucket
                continue;
            }

            maxGap = Math.max(maxGap,bucketMin[i]-previous);
            previous = bucketMax[i];
        }

        maxGap = Math.max(maxGap,max-previous);

        return maxGap;
    }
}
