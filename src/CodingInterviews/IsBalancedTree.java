package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-39-判断是否是平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 简单做法，遍历所有节点，得到深度
    // 每个节点的深度不超过1就是平衡的
    public boolean isBalanced_Solution1(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        int diff = left - right;

        if (diff > 1 || diff < -1) {
            return false;
        } else {
            return isBalanced_Solution1(root.left) && isBalanced_Solution1(root.right);
        }
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int numberLeft = treeDepth(root.left);
        int numberRight = treeDepth(root.right);

        return numberLeft < numberRight ? (numberRight + 1) : (numberLeft + 1);
    }


    // 采用后序遍历的方式，先遍历根节点的左子树和右子树
    // 每遍历一个节点，如果它的左子树和右子树的深度差不超过1，就需要记录该节点的深度
    // 最后遍历到根节点
    public boolean isBalanced_Solution2(TreeNode root) {

        int[] depth = new int[1];

        return isBalancedHelper(root, depth);

    }

    private boolean isBalancedHelper(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];

        if (isBalancedHelper(root.left, left) && isBalancedHelper(root.right, right)) {

            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                // 如果左右子树的深度相差超过1，就认为这不是一个平衡二叉树
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }

        return false;
    }

    @Test
    public void Test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;

        isBalanced_Solution2(n1);

    }

}
