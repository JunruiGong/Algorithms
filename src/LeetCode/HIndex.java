package LeetCode;

/**
 * Leetcode-274-H-Index
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 */
public class HIndex {
    public int hIndex(int[] citations) {

        // 采用计数排序的思想
        // 第一次遍历
        // 根据数组的长度n 创建n+1个bucket（0...n）
        // 将对应的数字放到相应的bucket中，如果数字大于n，就都放在第n+1个bucket中，
        // 第二次遍历
        // 从后往前读取bucket中的个数
        // 直到数量大于等于当前的index
        // 返回index

        if (citations.length == 0) {
            return 0;
        }

        int[] bucket = new int[citations.length + 1];

        for (int i : citations) {

            if (i > citations.length) {
                bucket[citations.length]++;
            } else {
                bucket[i]++;
            }
        }

        int count = 0;
        for (int i = citations.length; i >= 0; i--) {
            count = count + bucket[i];

            if (count >= i) {
                return i;
            }
        }

        return 0;
    }
}

