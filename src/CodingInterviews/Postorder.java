package CodingInterviews;

/**
 * 剑指offer-24-二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * */

import org.junit.Test;

import java.util.Arrays;

public class Postorder {

    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence.length == 0) {
            return false;
        }

        int root = sequence[sequence.length - 1];

        int i;

        //找到左右子树的分界点
        for (i = 0; i < sequence.length - 1; i++) {

            if (sequence[i] > root) {
                break;
            }
        }

        //判断右子树是否都大于root
        for (int j = i; j < sequence.length - 1; j++) {

            if (sequence[j] < root) {
                return false;
            }
        }

        boolean right = true, left = true;
        if (i > 0) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }


        if (i < sequence.length - 1) {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));

        }


        return right && left;

    }

    @Test
    public void test() {
//        int[] sequence = {2,9,5,16,17,15,19,18,12};
        int[] sequence = {4, 8, 6, 12, 16, 14, 10};
        VerifySquenceOfBST(sequence);
    }
}
