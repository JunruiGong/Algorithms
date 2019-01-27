package LeetCode;

import java.util.Stack;

/**
 * Leetcode-84-Largest Rectangle in Histogram-Hard
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length < 1) {
            return 0;
        }

        // stack保存的是heights的index
        Stack<Integer> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i <= heights.length; i++) {

            // 获得高度
            int h = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                // 起始index
                int start = stack.isEmpty() ? -1 : stack.peek();

                // 计算面积
                int area = height * (i - start - 1);

                result = Math.max(result, area);
            }
            stack.push(i);

        }

        return result;
    }
}
