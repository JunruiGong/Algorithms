package LeetCode;


import org.junit.Test;

/**
 * Leetcode-287-Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * */
public class FindtheDuplicateNumber {

    // 用二分法查找
    // 我们在区间[1, n]中搜索，
    // 首先求出中点mid，然后遍历整个数组，
    // 统计所有小于等于mid的数的个数，
    // 如果个数小于等于mid，则说明重复值在[mid+1, n]之间，
    // 反之，重复值应在[1, mid-1]之间，然后依次类推，直到搜索完成，
    // 此时的low就是我们要求的重复值。
    // 复杂度较高
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }


    // 将数组想象成链表，如果存在相同的数，则一定存在环，且环的入口节点就是重复的值。
    // 就可以将问题转化为找有环链表的入口节点
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    @Test
    public void Test(){

        int[] nums = {1,3,4,2,2};
        findDuplicate1(nums);

    }
}
