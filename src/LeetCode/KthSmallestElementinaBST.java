package LeetCode;

import java.util.Stack;

/**
 * Leetcode-230-Kth Smallest Element in a BST-Medium
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // 先找到最左边的子节点
                stack.push(root);
                root = root.left;
            } else {
                // 找到之后再判断该子节点位于第几位
                TreeNode node = stack.pop();
                if (++count == k) {
                    return node.val;
                }
                root = node.right;

            }
        }

        return Integer.MIN_VALUE;
    }
}
