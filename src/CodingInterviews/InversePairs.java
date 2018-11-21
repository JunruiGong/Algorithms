package CodingInterviews;


/**
 * 剑指offer-36-数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class InversePairs {

    public int inversePairs(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余

    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;

        //前半段的最后一个数字的下标
        int i = mid;

        //后半段最后一个数字的下标
        int j = high;

        //开始拷贝的位置
        int locCopy = high;

        while (i >= low && j > mid) {

            // 两段数组都已经按升序排好序
            // 如果前半段最后一个数字比后半段的最后一个数字大
            // 说明前半段最后一个数字比后半段所有数字都要大
            // 将前半段的最后一个数字拷贝到copy中
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                // 否则将后半的最后一个数字拷贝到copy中
                copy[locCopy--] = array[j--];
            }
        }

        // 将剩下的数字依次拷贝到copy中
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }

        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }

        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }

        return (leftCount + rightCount + count) % 1000000007;
    }
}
