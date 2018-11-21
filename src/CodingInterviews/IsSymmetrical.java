package CodingInterviews;

/**
 * 剑指offer-59-对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) {
            return true;
        }

        return comRoot(pRoot.left, pRoot.right);
    }


    private boolean comRoot(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            return left.val == right.val && comRoot(left.right, right.left) && comRoot(left.left, right.right);

        }

        return false;
    }
}
