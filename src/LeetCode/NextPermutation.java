package LeetCode;

/**
 * Leetcode-31-Next Permutations-Medium
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 *
 * 1 2 7 4 3 1
 *   ^
 * 1 2 7 4 3 1
 *         ^
 * 1 3 7 4 2 1
 *   ^     ^
 * 1 3 1 2 4 7
 *     ^ ^ ^ ^
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }

        // 如果是递减序列，将该序列翻转并返回
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }


        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }

        // 交换2，3
        swap(nums, firstSmall, firstLarge);

        // 翻转剩余数字
        reverse(nums, firstSmall + 1, nums.length - 1);
        return;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
