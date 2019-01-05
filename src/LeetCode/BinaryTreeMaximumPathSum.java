package LeetCode;

/**
 * Leetcode-124-Binary Tree Maximum Path Sum-Hard
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 * 任意两个节点之间的路径
 */
public class BinaryTreeMaximumPathSum {


    // 一条路径是从叶节点出发，向上走，到达最高点，然后开始向下走，最终到达叶节点
    // 每一条路径都有一个最高节点，它就是这条路径的所有节点的最小公共祖先

    private int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        help(root);
        return maxValue;

    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, help(root.left));
        int right = Math.max(0, help(root.right));

        // 最长路径为左子路径+右子路径+该节点的值
        maxValue = Math.max(maxValue, left + right + root.val);

        // 向上回溯，需要确定经过其左子结点的路径之和大还是经过右子节点的路径之和大
        return Math.max(left, right) + root.val;
    }
}
