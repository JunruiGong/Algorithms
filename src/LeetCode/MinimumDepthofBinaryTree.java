package LeetCode;

/**
 * Leetcode-111-Minimum Depth of Binary Tree-Easy
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 *
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }

        if (root.left==null|| root.right==null){
            // 因为题目要求的是从根节点到叶节点，
            // 如果出现一个节点只有一个子节点的情况，需要计算到他的子节点，
            // 而不是在该节点就结束，因为该节点不是叶节点
            //     3
            //    / \
            //   9  20
            //     /
            //    15
            // 如上图：需要一直计算到15，所以需要使用Math.max()，而不是Math.min()
            return Math.max(minDepth(root.left),minDepth(root.right))+1;
        }

        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
