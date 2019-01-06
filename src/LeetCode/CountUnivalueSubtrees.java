package LeetCode;


/**
 * Leetcode-250-Count Univalue Subtrees-Medium
 *
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 * Given binary tree,
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 *
 * return 4.
 */
public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] result = {0};

        help(root, result);
        return result[0];
    }

    private boolean help(TreeNode root, int[] result) {
        if (root == null) {
            return true;
        }

        boolean left = help(root.left, result);
        boolean right = help(root.right, result);

        if (left && right) {

            // 如果子节点与本身不相同，返回false
            if (root.left != null && root.val != root.left.val) {
                return false;
            }

            if (root.right != null && root.val != root.right.val) {
                return false;
            }

            // 如果相同，result++;
            result[0]++;
            return true;
        }

        return false;
    }
}
