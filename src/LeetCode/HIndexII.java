package LeetCode;

/**
 * Leetcode-275-H-Index II
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 */

public class HIndexII {
    public int hIndex(int[] citations) {

        // 采用二分法
        // 如果当前mid上的数等于length-mid
        // 说明该数是H-index，因为比它大的数的个数等于它等于它本身

        // 如果当前mid上的数大于length-mid
        // 说明大于它的数的个数不足，mid需要向左移
        //反之向右移

        int length = citations.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = (high + low) >> 1;
            if (citations[mid] == length - mid) {
                return length - mid;
            } else if (citations[mid] > length - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return length - low;

    }
}
