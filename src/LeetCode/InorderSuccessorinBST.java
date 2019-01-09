package LeetCode;

/**
 * Leetcode-285-Inorder Successor in BST-Medium
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        // 找到比p大的最小值

        TreeNode result = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                result = root;
                root = root.left;

            }
        }
        return result;
    }
}
