package LeetCode;

/**
 * Leetcode-298-Binary Tree Longest Consecutive Sequence-Medium
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 *
 *
 * 各个节点按从小到达顺序
 */
public class BinaryTreeLongestConsecutiveSequence {

    private int max = 1;

    public int longestConsecutive(TreeNode root) {

        if (root == null) {
            return 0;
        }

        help(root, 0, 0);
        return max;
    }

    private void help(TreeNode root, int prev, int len) {
        if (prev + 1 == root.val) {
            // 如果子节点比父节点大1，则长度加1
            len++;
        } else {
            // 否则重新计算
            len = 1;
        }

        max = Math.max(max, len);

        if (root.left != null) {
            help(root.left, root.val, len);
        }

        if (root.right != null) {
            help(root.right, root.val, len);
        }
    }

}
