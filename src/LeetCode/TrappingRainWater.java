package LeetCode;

import org.junit.Test;

/**
 * Leetcode-42-Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 *
 * 当前单元能装多少水是取决于左右两边挡板最小值与当前值之差
 *
 *          0,1,0,2,1,0,1,3,2,1,2,1
 *
 *                        *
 *                *       * *   *
 *            *   * *   * * * * * *
 *          0 1 2 3 4 5 6 7 8 9 0 1
 *            l
 *
 *          假设leftMax = 1, left = 1
 *          在进行下一个循环时，左边的高度变为0
 *          此时，leftMax>height[i], 则在i = 2处必定可以放入水
 *          水量为leftMax - height[i]
 *
 *
 * */
public class TrappingRainWater {
    public int trap(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;  // 左挡板的高度
        int rightMax = 0; // 右挡板的高度
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }


    @Test
    public void test(){

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));

    }
}
