package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode-112-Path Sum II-Medium
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> paths = new LinkedList<>();

        List<Integer> currentPath = new LinkedList<>();

        pathSum(root, sum, paths, currentPath);

        return paths;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> currentPath) {
        if (root == null) {
            return;
        }

        currentPath.add(root.val);
        if (root.left == null && root.right == null && (sum - root.val == 0)) {
            //  如果root的左边和右边都为null，且最后的sum=root.val，则说明该条路径符合要求
            paths.add(new LinkedList(currentPath));
            currentPath.remove(currentPath.size() - 1);  // 移除最后一个数
            return;
        } else {
            pathSum(root.left, sum - root.val, paths, currentPath);
            pathSum(root.right, sum - root.val, paths, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
