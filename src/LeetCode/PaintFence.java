package LeetCode;

/**
 * Leetcode-276-Paint Fence-Easy
 *
 * There is a fence with n posts, each post can be painted with one of the k colors.
 *
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 *
 * Note:
 * n and k are non-negative integers.
 */
public class PaintFence {
    public int numWayPaintFence(int n, int k) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        // 现在的same和diff相当于n=2时可以产生的不同涂法
        // 两个相邻的涂相同的颜色，则有k种涂法
        int same = k;

        // 两个相邻的涂不同的颜色，则有k * (k - 1)种涂法
        int diff = k * (k - 1);

        for (int i = 3; i <= n; i++) {
            int prevDiff = diff;

            // 当前位置涂的颜色与前一个不同
            diff = (same + diff) * (k - 1);

            // 当前位置涂的颜色于前一个相同
            same = prevDiff;
        }

        return Math.max(diff, same);
    }
}
