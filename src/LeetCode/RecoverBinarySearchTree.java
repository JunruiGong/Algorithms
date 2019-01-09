package LeetCode;

import java.util.Stack;

/**
 * Leetcode-99-Recover Binary Search Tree-Hard
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {

    // 采用中序遍历的两种方法：递归，迭代
    // 找到交换位置的两个节点，再交换

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }
        help(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;
        help(root.right);
    }


    public void recoverTree2(TreeNode root) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (prev != null && root.val <= prev.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = root;
                }
                prev = root;
                root = root.right;
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
