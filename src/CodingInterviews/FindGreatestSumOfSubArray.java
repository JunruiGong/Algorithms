package CodingInterviews;

/**
 * 剑指offer-31-连续子数组的最大和
 * <p>
 * 输入一个整数数组，数组里含有正数和负数。数组中的一个或多个连续整数组成一个子数组。
 * 求子数组可以得到的最大和。
 */
public class FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array) {

        if (array.length < 1) {
            throw new IllegalArgumentException("The length of array must large than 0");
        }

        //用于记录最大的子数组和，开始时设置为最小整数
        int max = Integer.MIN_VALUE;

        int curMax = 0;

        for (int i : array) {

            // 在第i这个数字前，如果和是小于等于0的话，这个和再加上第i个数
            // 这个和肯定会比第i个数本身要小，所以直接将当前和设置为第i个数。
            if (curMax <= 0) {
                // 如果当前和小于等于0，就重新设置当前和
                curMax = i;
            } else {
                // 如果当前和大于0，累加当前和
                curMax += i;
            }

            // 更新记录最大的子数组和
            if (max < curMax) {
                max = curMax;
            }
        }

        return max;
    }


}
