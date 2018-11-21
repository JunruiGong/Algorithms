package CodingInterviews;

/**
 * 剑指offer-39-二叉树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int numberLeft = treeDepth(root.left);

        int numberRight = treeDepth(root.right);

        return numberLeft < numberRight ? (numberRight + 1) : (numberLeft + 1);
    }
}
