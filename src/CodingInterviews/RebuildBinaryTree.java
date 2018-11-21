package CodingInterviews;

/**
 * 剑指offer-6-重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */

import java.util.Arrays;

public class RebuildBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        TreeNode root = new TreeNode(0);

        for (int i = 0; i < in.length; i++) {

            if (pre[0] == in[i]) {

                //找到根节点
                root.val = pre[0];

                //以根节点为界，划分左右子树，并进行递归。
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));

                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }


        return root;
    }

}
