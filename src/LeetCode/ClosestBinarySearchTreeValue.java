package LeetCode;

/**
 * Leetcode-270-Closest Binary Search Tree Value-Easy
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {

        int closest = root.val;
        double min = Double.MAX_VALUE;

        while (root != null) {
            if (Math.abs(root.val - target) < min) {
                min = Math.abs(root.val - target);
                closest = root.val;
            }

            if (root.val < target) {
                root = root.right;
            } else if (root.val > target) {
                root = root.left;
            } else {
                return root.val;
            }
        }

        return closest;
    }

}
