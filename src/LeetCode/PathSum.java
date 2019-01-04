package LeetCode;

/**
 * Leetcode-112-Path Sum-Easy
 *
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {


        // The basic idea is to subtract the value of current node from sum
        // until it reaches a leaf node and the subtraction equals 0,
        // then we know that we got a hit.
        // Otherwise the subtraction at the end could not be 0.

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && (sum - root.val == 0)) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
